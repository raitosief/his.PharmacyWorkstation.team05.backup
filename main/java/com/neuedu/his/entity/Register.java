package com.neuedu.his.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Register {
	 private Integer ID;// ID 自增长类型
	    private String CaseNumber;// 病历号
	    private String RealName;// 姓名
	    private Integer Gender;// 性别
	    private String IDnumber;// 身份证号
//	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
	    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
	    private Date BirthDate;// 出生日期
	    private Integer Age;// 年龄
	    private String AgeType;// 年龄类型 岁/月/天
	    private String HomeAddress;// 家庭住址
//	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
	    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
	    private Date VisitDate;// 本次看诊日期
	    private String Noon;// 午别 上午/下午
	    private Integer DeptID;// 本次挂号科室ID 指向 Department( ID )
	    private Integer UserID;// 本次挂号医生ID 指向 User (ID)
	    private Integer RegistLeID;// 本次挂号级别ID 指向 RegistLevel(ID)
	    private Integer SettleID;// 结算类别 ID 指向SettleCategory(ID)
	    private String IsBook;// 病历本要否 是/否
//	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
	    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
	    private Date RegistTime;// 挂号时间
	    private Integer RegisterID;// 挂号员 ID 指向 User(ID)
	    private Integer VisitState;// 本次看诊状态 1-已挂号 2-医生接诊 3-看诊结束 4-已退号
	    private String StartTime;
	    private String EndTime;
		public Register() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Register(Integer iD, String caseNumber, String realName, Integer gender, String iDnumber, Date birthDate,
				Integer age, String ageType, String homeAddress, Date visitDate, String noon, Integer deptID,
				Integer userID, Integer registLeID, Integer settleID, String isBook, Date registTime,
				Integer registerID, Integer visitState, String startTime, String endTime) {
			super();
			ID = iD;
			CaseNumber = caseNumber;
			RealName = realName;
			Gender = gender;
			IDnumber = iDnumber;
			BirthDate = birthDate;
			Age = age;
			AgeType = ageType;
			HomeAddress = homeAddress;
			VisitDate = visitDate;
			Noon = noon;
			DeptID = deptID;
			UserID = userID;
			RegistLeID = registLeID;
			SettleID = settleID;
			IsBook = isBook;
			RegistTime = registTime;
			RegisterID = registerID;
			VisitState = visitState;
			StartTime = startTime;
			EndTime = endTime;
		}
		public Integer getID() {
			return ID;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public String getCaseNumber() {
			return CaseNumber;
		}
		public void setCaseNumber(String caseNumber) {
			CaseNumber = caseNumber;
		}
		public String getRealName() {
			return RealName;
		}
		public void setRealName(String realName) {
			RealName = realName;
		}
		public Integer getGender() {
			return Gender;
		}
		public void setGender(Integer gender) {
			Gender = gender;
		}
		public String getIDnumber() {
			return IDnumber;
		}
		public void setIDnumber(String iDnumber) {
			IDnumber = iDnumber;
		}
		public Date getBirthDate() {
			return BirthDate;
		}
		public void setBirthDate(Date birthDate) {
			BirthDate = birthDate;
		}
		public Integer getAge() {
			return Age;
		}
		public void setAge(Integer age) {
			Age = age;
		}
		public String getAgeType() {
			return AgeType;
		}
		public void setAgeType(String ageType) {
			AgeType = ageType;
		}
		public String getHomeAddress() {
			return HomeAddress;
		}
		public void setHomeAddress(String homeAddress) {
			HomeAddress = homeAddress;
		}
		public Date getVisitDate() {
			return VisitDate;
		}
		public void setVisitDate(Date visitDate) {
			VisitDate = visitDate;
		}
		public String getNoon() {
			return Noon;
		}
		public void setNoon(String noon) {
			Noon = noon;
		}
		public Integer getDeptID() {
			return DeptID;
		}
		public void setDeptID(Integer deptID) {
			DeptID = deptID;
		}
		public Integer getUserID() {
			return UserID;
		}
		public void setUserID(Integer userID) {
			UserID = userID;
		}
		public Integer getRegistLeID() {
			return RegistLeID;
		}
		public void setRegistLeID(Integer registLeID) {
			RegistLeID = registLeID;
		}
		public Integer getSettleID() {
			return SettleID;
		}
		public void setSettleID(Integer settleID) {
			SettleID = settleID;
		}
		public String getIsBook() {
			return IsBook;
		}
		public void setIsBook(String isBook) {
			IsBook = isBook;
		}
		public Date getRegistTime() {
			return RegistTime;
		}
		public void setRegistTime(Date registTime) {
			RegistTime = registTime;
		}
		public Integer getRegisterID() {
			return RegisterID;
		}
		public void setRegisterID(Integer registerID) {
			RegisterID = registerID;
		}
		public Integer getVisitState() {
			return VisitState;
		}
		public void setVisitState(Integer visitState) {
			VisitState = visitState;
		}
		public String getStartTime() {
			return StartTime;
		}
		public void setStartTime(String startTime) {
			StartTime = startTime;
		}
		public String getEndTime() {
			return EndTime;
		}
		public void setEndTime(String endTime) {
			EndTime = endTime;
		}
		@Override
		public String toString() {
			return "Register [ID=" + ID + ", CaseNumber=" + CaseNumber + ", RealName=" + RealName + ", Gender=" + Gender
					+ ", IDnumber=" + IDnumber + ", BirthDate=" + BirthDate + ", Age=" + Age + ", AgeType=" + AgeType
					+ ", HomeAddress=" + HomeAddress + ", VisitDate=" + VisitDate + ", Noon=" + Noon + ", DeptID="
					+ DeptID + ", UserID=" + UserID + ", RegistLeID=" + RegistLeID + ", SettleID=" + SettleID
					+ ", IsBook=" + IsBook + ", RegistTime=" + RegistTime + ", RegisterID=" + RegisterID
					+ ", VisitState=" + VisitState + ", StartTime=" + StartTime + ", EndTime=" + EndTime + "]";
		}
	    
}
