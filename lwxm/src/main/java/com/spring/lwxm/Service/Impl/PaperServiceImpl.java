package com.spring.lwxm.Service.Impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.spring.lwxm.Mapper.PaperMapper;
import com.spring.lwxm.Service.PaperService;
import com.spring.lwxm.common.entity.CheckRecord;
import com.spring.lwxm.common.entity.UserStudent;
import com.spring.lwxm.common.result.Result;
import com.spring.lwxm.common.result.ResultUtil;
import com.spring.lwxm.common.util.DataImport;
import com.spring.lwxm.common.util.MyProperties;
import com.spring.lwxm.common.util.PageBean;




@Service
public class PaperServiceImpl implements PaperService{

	@Autowired
	private MyProperties myProperties;
	
	@Autowired
	private PaperMapper paperMapper;
	
	/**
	 * 提交论文
	 * @param checkRecord
	 * @return
	 */
	public Result submitPaper(CheckRecord checkRecord,Integer checkResult,MultipartFile file) {
		if(file==null) {
			return ResultUtil.error(20001,"file文件为空!");
		}
		if(checkResult==null) {
			return ResultUtil.error(20001,"未传入检查结果!");
		}
		if(checkRecord.getStudentId()==null) {
			return ResultUtil.error(20001,"传入的学生id为空!");
		}
		int studentIdCount= paperMapper.findStudentId(checkRecord.getStudentId());
		//查询的studentId记录为0，表明是第一次提交
		if(studentIdCount == 0){
			//将文件转化为路径存放
			int studentId = checkRecord.getStudentId();
			checkRecord.setThesisPath(DataImport.dataImportUserFile(file, studentId+"paper"));
			int checkCount =1;
			checkRecord.setCheckCount(checkCount);
			checkRecord.setCheckResult(checkResult);
			return ResultUtil.success(paperMapper.insert(checkRecord));
		}else{
			//查询的studentId记录不为0，表明不是第一次提交
			Long id = paperMapper.findId(checkRecord.getStudentId());
			checkRecord.setId(id);
			//根据id查询出已经提交的次数，再次提交次数加1
			int checkCount = paperMapper.selectCheckCount(checkRecord.getStudentId());
			checkRecord.setCheckCount(checkCount+1);
			//将文件夹的旧路径删除
			new File(myProperties.getExportPath()+paperMapper.getPathId(id)).delete();
			//将新路径放入实体
			int studentId = checkRecord.getStudentId();
			checkRecord.setThesisPath(DataImport.dataImportUserFile(file, studentId+"paper"+checkCount));
			checkRecord.setCheckResult(checkResult);
			return ResultUtil.success(paperMapper.updateById(checkRecord));
		}
	}
	
	/**
	 * 查看论文
	 */
	public Result findPaper(UserStudent userStudent, Integer page, Integer limit){
		PageHelper.startPage(page,limit);
		List<Map> list= paperMapper.findPaperList(userStudent);
		for(int i=0;i<list.size();i++) {
			list.get(i).put("filePath", myProperties.getDataUrl()+list.get(i).get("thesisPath"));
		}
		return ResultUtil.success(new PageBean<>(list));
		}

}
