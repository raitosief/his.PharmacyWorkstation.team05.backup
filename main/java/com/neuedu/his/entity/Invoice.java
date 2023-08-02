package com.neuedu.his.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Invoice {//发票表
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
	public Invoice() {
		super();
	}
	public Invoice(Integer iD, String invoiceNum, BigDecimal money, Integer state, Date creationTime, Integer userID,
			Integer registID, Integer feeType, String back, Integer dailyState) {
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
	@Override
	public String toString() {
		return "invoice [ID=" + ID + ", InvoiceNum=" + InvoiceNum + ", Money=" + Money + ", State=" + State
				+ ", CreationTime=" + CreationTime + ", UserID=" + UserID + ", RegistID=" + RegistID + ", FeeType="
				+ FeeType + ", Back=" + Back + ", DailyState=" + DailyState + "]";
	}
	

}
