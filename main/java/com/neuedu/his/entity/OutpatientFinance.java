package com.neuedu.his.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OutpatientFinance {//invoice和user表的组合，用来在前端时作为对象被引入
	private Integer ID;//id主键
	private String InvoiceNum;//发票号码
	private BigDecimal Money;//发票金额
	private Integer State;//发票状态  1-正常  2-作废 
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
	private Date CreationTime;//收/退费时间 
	private Integer UserID;//收/退费人员ID
	private Integer RegistID;//挂号ID
	private Integer FeeType;//收费方式 
	private String Back;//冲红发票号码
	private Integer DailyState;//发票状态  0-未日结  1-已提交  2-已审核 
	private String UserName;//登录名
	private String Password;//密码
	private String RealName;//真实姓名
	private Integer UseType;//用户类型
	private Integer DocTitleID;//医生职称id
	private Character IsScheduling;//是否参与排班
	private Integer DeptID;//所在科室id
	private Integer RegistLeID;//挂号级别id
	private Integer DelMark;//删除标记
	public OutpatientFinance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutpatientFinance(Integer iD, String invoiceNum, BigDecimal money, Integer state, Date creationTime,
			Integer userID, Integer registID, Integer feeType, String back, Integer dailyState, String userName,
			String password, String realName, Integer useType, Integer docTitleID, Character isScheduling,
			Integer deptID, Integer registLeID, Integer delMark) {
		super();
		ID = iD;
		InvoiceNum = invoiceNum;
		Money = money;
		State = state;
		CreationTime = creationTime;
		UserID = userID;
		RegistID = registID;
		FeeType = feeType;
		Back = back;
		DailyState = dailyState;
		UserName = userName;
		Password = password;
		RealName = realName;
		UseType = useType;
		DocTitleID = docTitleID;
		IsScheduling = isScheduling;
		DeptID = deptID;
		RegistLeID = registLeID;
		DelMark = delMark;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getInvoiceNum() {
		return InvoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		InvoiceNum = invoiceNum;
	}
	public BigDecimal getMoney() {
		return Money;
	}
	public void setMoney(BigDecimal money) {
		Money = money;
	}
	public Integer getState() {
		return State;
	}
	public void setState(Integer state) {
		State = state;
	}
	public Date getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(Date creationTime) {
		CreationTime = creationTime;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Integer getRegistID() {
		return RegistID;
	}
	public void setRegistID(Integer registID) {
		RegistID = registID;
	}
	public Integer getFeeType() {
		return FeeType;
	}
	public void setFeeType(Integer feeType) {
		FeeType = feeType;
	}
	public String getBack() {
		return Back;
	}
	public void setBack(String back) {
		Back = back;
	}
	public Integer getDailyState() {
		return DailyState;
	}
	public void setDailyState(Integer dailyState) {
		DailyState = dailyState;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public Integer getUseType() {
		return UseType;
	}
	public void setUseType(Integer useType) {
		UseType = useType;
	}
	public Integer getDocTitleID() {
		return DocTitleID;
	}
	public void setDocTitleID(Integer docTitleID) {
		DocTitleID = docTitleID;
	}
	public Character getIsScheduling() {
		return IsScheduling;
	}
	public void setIsScheduling(Character isScheduling) {
		IsScheduling = isScheduling;
	}
	public Integer getDeptID() {
		return DeptID;
	}
	public void setDeptID(Integer deptID) {
		DeptID = deptID;
	}
	public Integer getRegistLeID() {
		return RegistLeID;
	}
	public void setRegistLeID(Integer registLeID) {
		RegistLeID = registLeID;
	}
	public Integer getDelMark() {
		return DelMark;
	}
	public void setDelMark(Integer delMark) {
		DelMark = delMark;
	}
	@Override
	public String toString() {
		return "OutpatientFinance [ID=" + ID + ", InvoiceNum=" + InvoiceNum + ", Money=" + Money + ", State=" + State
				+ ", CreationTime=" + CreationTime + ", UserID=" + UserID + ", RegistID=" + RegistID + ", FeeType="
				+ FeeType + ", Back=" + Back + ", DailyState=" + DailyState + ", UserName=" + UserName + ", Password="
				+ Password + ", RealName=" + RealName + ", UseType=" + UseType + ", DocTitleID=" + DocTitleID
				+ ", IsScheduling=" + IsScheduling + ", DeptID=" + DeptID + ", RegistLeID=" + RegistLeID + ", DelMark="
				+ DelMark + "]";
	}
	

}
