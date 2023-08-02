package com.neuedu.his.entity;

import java.math.BigDecimal;

// 表名：患者成药处方明细表
public class PrescriptionDetailed {
    private Integer ID;// ID 自增长类型
    private Integer PrescriptionID;// 成药处方ID 指向 Prescription(ID)
    private Integer DrugsID;// 药品 ID 指向 Drugs (ID)
    private String DrugsName;//药品名称
    private String DrugsUsage;// 用法
    private String Dosage;// 用量
    private String Frequency;// 频次
    private BigDecimal Amount;// 数量
    private Integer State;// 状态 2-已开立 3-已交费 4-已发药 5-已退药 6-已退费
	public PrescriptionDetailed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrescriptionDetailed(Integer iD, Integer prescriptionID, Integer drugsID, String drugsName,
			String drugsUsage, String dosage, String frequency, BigDecimal amount, Integer state) {
		super();
		ID = iD;
		PrescriptionID = prescriptionID;
		DrugsID = drugsID;
		DrugsName = drugsName;
		DrugsUsage = drugsUsage;
		Dosage = dosage;
		Frequency = frequency;
		Amount = amount;
		State = state;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getPrescriptionID() {
		return PrescriptionID;
	}
	public void setPrescriptionID(Integer prescriptionID) {
		PrescriptionID = prescriptionID;
	}
	public Integer getDrugsID() {
		return DrugsID;
	}
	public void setDrugsID(Integer drugsID) {
		DrugsID = drugsID;
	}
	public String getDrugsName() {
		return DrugsName;
	}
	public void setDrugsName(String drugsName) {
		DrugsName = drugsName;
	}
	public String getDrugsUsage() {
		return DrugsUsage;
	}
	public void setDrugsUsage(String drugsUsage) {
		DrugsUsage = drugsUsage;
	}
	public String getDosage() {
		return Dosage;
	}
	public void setDosage(String dosage) {
		Dosage = dosage;
	}
	public String getFrequency() {
		return Frequency;
	}
	public void setFrequency(String frequency) {
		Frequency = frequency;
	}
	public BigDecimal getAmount() {
		return Amount;
	}
	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}
	public Integer getState() {
		return State;
	}
	public void setState(Integer state) {
		State = state;
	}
	@Override
	public String toString() {
		return "PrescriptionDetailed [ID=" + ID + ", PrescriptionID=" + PrescriptionID + ", DrugsID=" + DrugsID
				+ ", DrugsName=" + DrugsName + ", DrugsUsage=" + DrugsUsage + ", Dosage=" + Dosage + ", Frequency="
				+ Frequency + ", Amount=" + Amount + ", State=" + State + ", getID()=" + getID()
				+ ", getPrescriptionID()=" + getPrescriptionID() + ", getDrugsID()=" + getDrugsID()
				+ ", getDrugsName()=" + getDrugsName() + ", getDrugsUsage()=" + getDrugsUsage() + ", getDosage()="
				+ getDosage() + ", getFrequency()=" + getFrequency() + ", getAmount()=" + getAmount() + ", getState()="
				+ getState() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

    
}
