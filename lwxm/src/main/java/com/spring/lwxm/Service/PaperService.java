package com.spring.lwxm.Service;

import org.springframework.web.multipart.MultipartFile;

import com.spring.lwxm.common.entity.CheckRecord;
import com.spring.lwxm.common.entity.UserStudent;
import com.spring.lwxm.common.result.Result;


public interface PaperService {

	Result submitPaper(CheckRecord checkRecord, Integer checkResult, MultipartFile file);
	
	Result findPaper(UserStudent userStudent,Integer page, Integer limit);

}
