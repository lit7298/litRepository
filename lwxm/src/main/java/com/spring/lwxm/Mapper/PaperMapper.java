package com.spring.lwxm.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.lwxm.common.entity.CheckRecord;
import com.spring.lwxm.common.entity.UserStudent;

@Mapper
public interface PaperMapper extends BaseMapper<CheckRecord>{

	
    int findStudentId(Integer id);//根据studentId查询数据库中是否有本条记录
	
	Long findId(Integer studentId);//根据studentId查询本条记录的id
	
	String getPathId(Long id);//根据id获取原始路径
	
	int selectCheckCount(Integer studentId);//根据studentId查询已经提交的次数
	
	List<Map> findPaperList(UserStudent userStudent);
	
}
