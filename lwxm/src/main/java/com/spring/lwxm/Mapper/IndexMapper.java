package com.spring.lwxm.Mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IndexMapper {


	public Map findTeacherByUserName(String userName);

	public Map findStudentByUserName(String userName);

}
