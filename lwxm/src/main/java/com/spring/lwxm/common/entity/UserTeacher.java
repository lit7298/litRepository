package com.spring.lwxm.common.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class UserTeacher {

	
	    // id
		private Long id;
		
		@Excel(name = "老师工号", orderNum = "0")
		private String teacherNumber;
		
		@Excel(name = "登入密码", orderNum = "1")
		private String teacherPassword;
		
		@Excel(name = "老师姓名", orderNum = "2")
		private String teacherName;
		
		@Excel(name = "类型", orderNum = "3", replace = { "教师_0", "管理员_1" })
		private Integer userType;
		
		@Excel(name = "电话号码", orderNum = "4")
		private String phoneNumber;
		
		// 创建时间
		@TableField(value="gmt_create",fill=FieldFill.INSERT)
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Timestamp gmtCreate;

		// 修改时间
		@TableField(value="gmt_modified",fill=FieldFill.INSERT_UPDATE)
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Timestamp gmtModified;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTeacherNumber() {
			return teacherNumber;
		}

		public void setTeacherNumber(String teacherNumber) {
			this.teacherNumber = teacherNumber;
		}

		public String getTeacherPassword() {
			return teacherPassword;
		}

		public void setTeacherPassword(String teacherPassword) {
			this.teacherPassword = teacherPassword;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		public Integer getUserType() {
			return userType;
		}

		public void setUserType(Integer userType) {
			this.userType = userType;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Timestamp getGmtCreate() {
			return gmtCreate;
		}

		public void setGmtCreate(Timestamp gmtCreate) {
			this.gmtCreate = gmtCreate;
		}

		public Timestamp getGmtModified() {
			return gmtModified;
		}

		public void setGmtModified(Timestamp gmtModified) {
			this.gmtModified = gmtModified;
		}

		@Override
		public String toString() {
			return "teacher [id=" + id + ", teacherNumber=" + teacherNumber + ", teacherPassword=" + teacherPassword
					+ ", teacherName=" + teacherName + ", userType=" + userType + ", phoneNumber=" + phoneNumber
					+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
		}
		
		
}
