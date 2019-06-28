package com.spring.lwxm.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.druid.util.StringUtils;


@Component
public class DataImport {
	@Autowired
	private  MyProperties myProperties;
	private static MyProperties staticMyProperties;
	//将bean  注入到静态属性对象中
	
	@PostConstruct
	public void init() {
		staticMyProperties = this.myProperties;
	}
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	
	
	/**
	 * 将文件保存到本地，并将路径返回
	 * @param request
	 * @return
	 */
	public static String dataImportUserFile(MultipartFile file,String paper){
		String userFileName= file.getOriginalFilename();//建军大业观后感.docx
		Date d = new Date();  
        String time=sdf.format(d);
		String filePath=staticMyProperties.getExportPath()+"\\";//D:\lit.uc\paper\
        //File uploadDir = new File(filePath);  
       // if (!uploadDir.exists()) uploadDir.mkdirs();     
        String newFileNamePath=filePath+paper+userFileName.substring(userFileName.lastIndexOf("."));//D:\lit.uc\paper\9paper.docx
        File newFile = new File(newFileNamePath);//D:\lit.uc\paper\9paper.docx 
        if(!newFile.getParentFile().exists()) {
        	newFile.getParentFile().mkdirs();
        }
        try {
        	file.transferTo(newFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
    
        return "/"+paper+userFileName.substring(userFileName.lastIndexOf("."));
	}
	
	
}
