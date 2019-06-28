package com.spring.lwxm.common.entity;

import java.sql.Timestamp;

import javax.xml.crypto.Data;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class UserStudent {

	// id
	private Long id;
	
	@Excel(name = "学号", orderNum = "0")
	private String studentNumber;
	
	@Excel(name = "登入密码", orderNum = "1")
	private String studentPassword;
	
	@Excel(name = "学生姓名", orderNum = "2")
	private String fullName;
	
	@Excel(name = "曾用名", orderNum = "3")
	private String beforeName;
	
	@Excel(name = "性别", orderNum = "4", replace = { "女性_0", "男性_1" })
	private Integer sex;
	
	@Excel(name = "证件照", orderNum = "5")
	private String faceImage;
	
	@Excel(name = "民族", orderNum = "6")
	private String nameFamily;
	
	@Excel(name = "姓名拼音", orderNum = "7")
	private String namePhoneticAlphabet;
	
	@Excel(name = "政治面貌", orderNum = "8")
	private String politicalOutlook;
	
	@Excel(name = "婚姻状态", orderNum = "9", replace = { "未婚_0", "已婚_1" })
	private Integer maritalStatus;
	
	@Excel(name = "出生日期", orderNum = "10")
	private Data dateOfBirth;
	
	
	@Excel(name = "证件号码", orderNum = "11")
	private String identificationNumber;
	
	@Excel(name = "生源地", orderNum = "12")
	private String birthplace;
	
	@Excel(name = "国籍", orderNum = "13")
	private String nationality;
	
	@Excel(name = "籍贯", orderNum = "14")
	private String nativePlace;
	
	@Excel(name = "户口所在地", orderNum = "15")
	private String registeredResidence;
	
	@Excel(name = "院系", orderNum = "16")
	private String collegeName;
	
	@Excel(name = "专业", orderNum = "17")
	private String majorName;
	
	@Excel(name = "年级id", orderNum = "18")
	private Integer classId;
	
	@Excel(name = "校区", orderNum = "19")
	private String campus;
	
	@Excel(name = "学制", orderNum = "20")
	private Integer schoolSystem;
	
	@Excel(name = "班级", orderNum = "21")
	private String className;
	
	@Excel(name = "学生类别（本科生）", orderNum = "22")
	private String classOfStudents;
	
	@Excel(name = "就读学历（大学本科）", orderNum = "23")
	private String studyEducation;
	
	@Excel(name = "就读学位（学士）", orderNum = "24")
	private String academicDegree;
	
	@Excel(name = "培养方式（国家任务）", orderNum = "25")
	private String cultureMode;
	
	@Excel(name = "在籍状态(0:离籍;1:在籍)", orderNum = "26", replace = { "离籍_0", "在籍_1" })
	private Integer statusHome;
	
	@Excel(name = "在校状态(0:离校;1:在校)", orderNum = "27", replace = { "离校_0", "在校_1" })
	private Integer schoolState;
	
	@Excel(name = "联系电话", orderNum = "28")
	private String contactNumber;
	
	@Excel(name = "手机号码", orderNum = "29")
	private String phoneNumber;
	
	@Excel(name = "通讯地址", orderNum = "30")
	private String postalAddress;

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

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBeforeName() {
		return beforeName;
	}

	public void setBeforeName(String beforeName) {
		this.beforeName = beforeName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getFaceImage() {
		return faceImage;
	}

	public void setFaceImage(String faceImage) {
		this.faceImage = faceImage;
	}

	public String getNameFamily() {
		return nameFamily;
	}

	public void setNameFamily(String nameFamily) {
		this.nameFamily = nameFamily;
	}

	public String getNamePhoneticAlphabet() {
		return namePhoneticAlphabet;
	}

	public void setNamePhoneticAlphabet(String namePhoneticAlphabet) {
		this.namePhoneticAlphabet = namePhoneticAlphabet;
	}

	public String getPoliticalOutlook() {
		return politicalOutlook;
	}

	public void setPoliticalOutlook(String politicalOutlook) {
		this.politicalOutlook = politicalOutlook;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Data getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Data dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getRegisteredResidence() {
		return registeredResidence;
	}

	public void setRegisteredResidence(String registeredResidence) {
		this.registeredResidence = registeredResidence;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public Integer getSchoolSystem() {
		return schoolSystem;
	}

	public void setSchoolSystem(Integer schoolSystem) {
		this.schoolSystem = schoolSystem;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassOfStudents() {
		return classOfStudents;
	}

	public void setClassOfStudents(String classOfStudents) {
		this.classOfStudents = classOfStudents;
	}

	public String getStudyEducation() {
		return studyEducation;
	}

	public void setStudyEducation(String studyEducation) {
		this.studyEducation = studyEducation;
	}

	public String getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}

	public String getCultureMode() {
		return cultureMode;
	}

	public void setCultureMode(String cultureMode) {
		this.cultureMode = cultureMode;
	}

	public Integer getStatusHome() {
		return statusHome;
	}

	public void setStatusHome(Integer statusHome) {
		this.statusHome = statusHome;
	}

	public Integer getSchoolState() {
		return schoolState;
	}

	public void setSchoolState(Integer schoolState) {
		this.schoolState = schoolState;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
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
		return "UserStudent [id=" + id + ", studentNumber=" + studentNumber + ", studentPassword=" + studentPassword
				+ ", fullName=" + fullName + ", beforeName=" + beforeName + ", sex=" + sex + ", faceImage=" + faceImage
				+ ", nameFamily=" + nameFamily + ", namePhoneticAlphabet=" + namePhoneticAlphabet
				+ ", politicalOutlook=" + politicalOutlook + ", maritalStatus=" + maritalStatus + ", dateOfBirth="
				+ dateOfBirth + ", identificationNumber=" + identificationNumber + ", birthplace=" + birthplace
				+ ", nationality=" + nationality + ", nativePlace=" + nativePlace + ", registeredResidence="
				+ registeredResidence + ", collegeName=" + collegeName + ", majorName=" + majorName + ", classId="
				+ classId + ", campus=" + campus + ", schoolSystem=" + schoolSystem + ", className=" + className
				+ ", classOfStudents=" + classOfStudents + ", studyEducation=" + studyEducation + ", academicDegree="
				+ academicDegree + ", cultureMode=" + cultureMode + ", statusHome=" + statusHome + ", schoolState="
				+ schoolState + ", contactNumber=" + contactNumber + ", phoneNumber=" + phoneNumber + ", postalAddress="
				+ postalAddress + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	
}
