package com.neuedu.his.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Drugs {
    private Integer ID;// ID 自增长类型
    private String DrugsCode;// 药品编码
    private String DrugsName;// 药品名称
    private String DrugsFormat;// 药品规格
    private String DrugsUnit;// 包装单位
    private String Manufacturer;// 生产厂家
    private Integer DrugsDosageID;// 药品剂型 指向ConstatntItem（ID）
    private Integer DrugsTypeID;// 药品类型 指向ConstatntItem（ID）
    private BigDecimal DrugsPrice;// 药品单价
    private String MnemonicCode;// 拼音助记码
    
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
    private Date CreationDate;// 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
    private Date LastUpdateDate;// 最后修改时间
    private Integer DelMark;// 删除标记 1-正常 0-已删除
	public Drugs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Drugs(Integer id, String drugsCode, String drugsName, String drugsFormat, String drugsUnit,
			String manufacturer, Integer drugsDosageID, Integer drugsTypeID, BigDecimal drugsPrice, String mnemonicCode,
			Date creationDate, Date lastUpdateDate, Integer delMark) {
		super();
		ID = id;
		DrugsCode = drugsCode;
		DrugsName = drugsName;
		DrugsFormat = drugsFormat;
		DrugsUnit = drugsUnit;
		Manufacturer = manufacturer;
		DrugsDosageID = drugsDosageID;
		DrugsTypeID = drugsTypeID;
		DrugsPrice = drugsPrice;
		MnemonicCode = mnemonicCode;
		CreationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
		DelMark = delMark;
	}
	public Integer getId() {
		return ID;
	}
	public void setId(Integer id) {
		ID = id;
	}
	public String getDrugsCode() {
		return DrugsCode;
	}
	public void setDrugsCode(String drugsCode) {
		DrugsCode = drugsCode;
	}
	public String getDrugsName() {
		return DrugsName;
	}
	public void setDrugsName(String drugsName) {
		DrugsName = drugsName;
	}
	public String getDrugsFormat() {
		return DrugsFormat;
	}
	public void setDrugsFormat(String drugsFormat) {
		DrugsFormat = drugsFormat;
	}
	public String getDrugsUnit() {
		return DrugsUnit;
	}
	public void setDrugsUnit(String drugsUnit) {
		DrugsUnit = drugsUnit;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public Integer getDrugsDosageID() {
		return DrugsDosageID;
	}
	public void setDrugsDosageID(Integer drugsDosageID) {
		DrugsDosageID = drugsDosageID;
	}
	public Integer getDrugsTypeID() {
		return DrugsTypeID;
	}
	public void setDrugsTypeID(Integer drugsTypeID) {
		DrugsTypeID = drugsTypeID;
	}
	public BigDecimal getDrugsPrice() {
		return DrugsPrice;
	}
	public void setDrugsPrice(BigDecimal drugsPrice) {
		DrugsPrice = drugsPrice;
	}
	public String getMnemonicCode() {
		return MnemonicCode;
	}
	public void setMnemonicCode(String mnemonicCode) {
		MnemonicCode = mnemonicCode;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public Date getLastUpdateDate() {
		return LastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		LastUpdateDate = lastUpdateDate;
	}
	public Integer getDelMark() {
		return DelMark;
	}
	public void setDelMark(Integer delMark) {
		DelMark = delMark;
	}
	@Override
	public String toString() {
		return "Drugs [Id=" + ID + ", DrugsCode=" + DrugsCode + ", DrugsName=" + DrugsName + ", DrugsFormat="
				+ DrugsFormat + ", DrugsUnit=" + DrugsUnit + ", Manufacturer=" + Manufacturer + ", DrugsDosageID="
				+ DrugsDosageID + ", DrugsTypeID=" + DrugsTypeID + ", DrugsPrice=" + DrugsPrice + ", MnemonicCode="
				+ MnemonicCode + ", CreationDate=" + CreationDate + ", LastUpdateDate=" + LastUpdateDate + ", DelMark="
				+ DelMark + "]";
	}
	
	
}


