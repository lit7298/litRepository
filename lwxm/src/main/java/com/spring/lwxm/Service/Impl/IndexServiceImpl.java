package com.spring.lwxm.Service.Impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.spring.lwxm.Mapper.IndexMapper;
import com.spring.lwxm.Service.IndexService;
import com.spring.lwxm.common.entity.UserTeacher;
import com.spring.lwxm.common.result.Result;
import com.spring.lwxm.common.result.ResultUtil;
import com.spring.lwxm.common.util.MD5Helper;
import com.spring.lwxm.common.util.MyProperties;



@Service
public class IndexServiceImpl implements IndexService{

	@Autowired
	private IndexMapper indexMapper;
	
	@Autowired  
    private RedisTemplate<String, String> redisTemplate; 
	
	@Autowired
    private MyProperties myProperties;
	
	@Value("${token.timeout}")
    private Integer timeOut;

	public Result userLogin(String userName, String password, Integer type) {
		//老师登录
		if(type==0) {
			Map teacherInfo = indexMapper.findTeacherByUserName(userName);
			if(teacherInfo==null){
				return ResultUtil.error(10001, "该用户不存在");
			}else{
				if(teacherInfo.get("password").equals(MD5Helper.encrypt16(password))){
					UserTeacher teacher = new UserTeacher();
					teacher.setTeacherNumber(teacherInfo.get("userNumber").toString());
					String uuidMd5 = MD5Helper.encrypt16(UUID.randomUUID().toString()); //生成一个token值
			        //将token值和用户信息加入redis缓存中
			        redisTemplate.opsForValue().set(uuidMd5, JSON.toJSONString(teacherInfo),timeOut,TimeUnit.SECONDS); 
			        Map<String, Object> map = new HashMap();
			        map.put("user", teacherInfo);
			        map.put("token", uuidMd5);
			        return ResultUtil.success(map);
				}else{
					return ResultUtil.error(10002, "密码不正确");
				}
			}
		}
		
		//学生登录
//		if(type==1) {
//			Map studentInfo = indexMapper.findStudentByUserName(userName);
//			if(studentInfo==null){
//				return ResultUtil.error(10001, "该用户不存在");
//			}else{
//				if(studentInfo.get("password").equals(MD5Helper.encrypt16(password))){
//					UserStudent student = new UserStudent();
//					if(studentInfo.get("faceImage")!=null){
//						studentInfo.put("faceImage", myProperties.getDataUrl()+studentInfo.get("faceImage"));
//					}
//					student.setStudentNumber(studentInfo.get("userNumber").toString());
//					String uuidMd5 = MD5Helper.encrypt16(UUID.randomUUID().toString()); 
//			        //用户信息加入redis缓存中
//			        redisTemplate.opsForValue().set(uuidMd5, JSON.toJSONString(studentInfo),timeOut,TimeUnit.SECONDS); 
//			        Map<String, Object> map = new HashMap();        
//			        map.put("user", studentInfo);
//			        map.put("token", uuidMd5);
//			        return ResultUtil.success(map);
//				}else{
//					return ResultUtil.error(10002, "密码不正确");
//				}
//			}
//		}
		return ResultUtil.error(10003, "不当操作");
	}
	
	/**
	 * 用户退出
	 */
	
	public Result longout(HttpServletRequest request) {
		redisTemplate.delete(request.getHeader("Authorization"));
		return ResultUtil.success();
	}

}
	

