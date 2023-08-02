package com.neuedu.his.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatientCosts {
	  private String CaseNumber;
	    private String RealName;
	    private String DeptName;
	    private String StartTime;
	    private String EndTime;
	    private Integer ID;// ID 自增长类型
	    private Integer RegistID;// 挂号 ID 指向 Register (ID)
	    private Integer InvoiceID;// 发票 ID 指向 invoice(ID)
	    private Integer ItemID;// 项目 ID
	    private Integer ItemType;// 项目类型 1-非药品 2-药品
	    private String Name;// 项目名称
	    private BigDecimal Price;// 项目单价
	    private BigDecimal Amount;// 数量
	    private Integer DeptID;// 执行科室ID
//	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
	    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
	    private Date Createtime;// 开立时间
	    private Integer CreateOperID;// 开立人员ID
//	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
	    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
	    private Date PayTime;// 收/退费时间
	    private Integer RegisterID;// 收/退费人员 ID
	    private Integer FeeType;// 收费方式
	    private Integer BackID;// 退费对应记录 ID
		public PatientCosts() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PatientCosts(String caseNumber, String realName, String deptName, String startTime, String endTime,
				Integer iD, Integer registID, Integer invoiceID, Integer itemID, Integer itemType, String name,
				BigDecimal price, BigDecimal amount, Integer deptID, Date createtime, Integer createOperID,
				Date payTime, Integer registerID, Integer feeType, Integer backID) {
			super();
			CaseNumber = caseNumber;
			RealName = realName;
			DeptName = deptName;
			StartTime = startTime;
			EndTime = endTime;
			ID = iD;
			RegistID = registID;
			InvoiceID = invoiceID;
			ItemID = itemID;
			ItemType = itemType;
			Name = name;
			Price = price;
			Amount = amount;
			DeptID = deptID;
			Createtime = createtime;
			CreateOperID = createOperID;
			PayTime = payTime;
			RegisterID = registerID;
			FeeType = feeType;
			BackID = backID;
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
		public String getDeptName() {
			return DeptName;
		}
		public void setDeptName(String deptName) {
			DeptName = deptName;
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
		public Integer getID() {
			return ID;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public Integer getRegistID() {
			return RegistID;
		}
		public void setRegistID(Integer registID) {
			RegistID = registID;
		}
		public Integer getInvoiceID() {
			return InvoiceID;
		}
		public void setInvoiceID(Integer invoiceID) {
			InvoiceID = invoiceID;
		}
		public Integer getItemID() {
			return ItemID;
		}
		public void setItemID(Integer itemID) {
			ItemID = itemID;
		}
		public Integer getItemType() {
			return ItemType;
		}
		public void setItemType(Integer itemType) {
			ItemType = itemType;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public BigDecimal getPrice() {
			return Price;
		}
		public void setPrice(BigDecimal price) {
			Price = price;
		}
		public BigDecimal getAmount() {
			return Amount;
		}
		public void setAmount(BigDecimal amount) {
			Amount = amount;
		}
		public Integer getDeptID() {
			return DeptID;
		}
		public void setDeptID(Integer deptID) {
			DeptID = deptID;
		}
		public Date getCreatetime() {
			return Createtime;
		}
		public void setCreatetime(Date createtime) {
			Createtime = createtime;
		}
		public Integer getCreateOperID() {
			return CreateOperID;
		}
		public void setCreateOperID(Integer createOperID) {
			CreateOperID = createOperID;
		}
		public Date getPayTime() {
			return PayTime;
		}
		public void setPayTime(Date payTime) {
			PayTime = payTime;
		}
		public Integer getRegisterID() {
			return RegisterID;
		}
		public void setRegisterID(Integer registerID) {
			RegisterID = registerID;
		}
		public Integer getFeeType() {
			return FeeType;
		}
		public void setFeeType(Integer feeType) {
			FeeType = feeType;
		}
		public Integer getBackID() {
			return BackID;
		}
		public void setBackID(Integer backID) {
			BackID = backID;
		}
		@Override
		public String toString() {
			return "PatientCosts [CaseNumber=" + CaseNumber + ", RealName=" + RealName + ", DeptName=" + DeptName
					+ ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", ID=" + ID + ", RegistID=" + RegistID
					+ ", InvoiceID=" + InvoiceID + ", ItemID=" + ItemID + ", ItemType=" + ItemType + ", Name=" + Name
					+ ", Price=" + Price + ", Amount=" + Amount + ", DeptID=" + DeptID + ", Createtime=" + Createtime
					+ ", CreateOperID=" + CreateOperID + ", PayTime=" + PayTime + ", RegisterID=" + RegisterID
					+ ", FeeType=" + FeeType + ", BackID=" + BackID + "]";
		}
	    
}
