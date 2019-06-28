package com.spring.lwxm.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lwxm.Service.PaperService;
import com.spring.lwxm.common.entity.CheckRecord;
import com.spring.lwxm.common.entity.UserStudent;
import com.spring.lwxm.common.result.Result;




@RestController
@RequestMapping("file")
public class PaperController {

	@Autowired
	private PaperService paperService;
	
	/**
	 * 提交论文
	 */
	@PostMapping("submitPaper")
	public Result submitPaper(@Valid CheckRecord checkRecord,Integer checkResult,MultipartFile file){	
		return paperService.submitPaper(checkRecord,checkResult,file);
	}
	
	/**
	 * 根据学生查询论文
	 */
	@PostMapping("findPaper")
	public Result findPaper(UserStudent userStudent,Integer page,Integer limit){	
		return paperService.findPaper(userStudent,page,limit);
	}
}
