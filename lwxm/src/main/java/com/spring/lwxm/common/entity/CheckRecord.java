package com.spring.lwxm.common.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.afterturn.easypoi.excel.annotation.Excel;


public class CheckRecord {

	 // id
	@Excel(name = "论文检测记录id")
	private Long id;
	
	@Excel(name = "学生id", orderNum = "1")
	private Integer studentId;
	
	@Excel(name = "论文检测次数", orderNum = "2")
	private Integer checkCount;
	
	@Excel(name = "论文检测结果 0:未通过；1：通过", orderNum = "3", replace = { "未通过_0", "通过_1" })
	private Integer checkResult;
	
	@Excel(name = "最后一次提交论文存放路径", orderNum = "4")
	private String thesisPath;
	
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

	public void setId(Long i) {
		this.id = i;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCheckCount() {
		return checkCount;
	}

	public void setCheckCount(Integer checkCount) {
		this.checkCount = checkCount;
	}

	public Integer getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}

	public String getThesisPath() {
		return thesisPath;
	}

	public void setThesisPath(String thesisPath) {
		this.thesisPath = thesisPath;
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
		return "checkRecord [id=" + id + ", studentId=" + studentId + ", checkCount=" + checkCount + ", checkResult="
				+ checkResult + ", thesisPath=" + thesisPath + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + "]";
	}

	
}
