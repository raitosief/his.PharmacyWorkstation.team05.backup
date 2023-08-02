package com.neuedu.his.entity;

public class Expenseclass {//费用科目表
	private Integer ID;//id主键
	private String ExpCode;//费用科目编码
	private String ExpName;//费用科目名字
	private Integer DelMark;//删除标记
	public Expenseclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expenseclass(Integer iD, String expCode, String expName, Integer delMark) {
		super();
		ID = iD;
		ExpCode = expCode;
		ExpName = expName;
		DelMark = delMark;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getExpCode() {
		return ExpCode;
	}
	public void setExpCode(String expCode) {
		ExpCode = expCode;
	}
	public String getExpName() {
		return ExpName;
	}
	public void setExpName(String expName) {
		ExpName = expName;
	}
	public Integer getDelMark() {
		return DelMark;
	}
	public void setDelMark(Integer delMark) {
		DelMark = delMark;
	}
	@Override
	public String toString() {
		return "Expenseclass [ID=" + ID + ", ExpCode=" + ExpCode + ", ExpName=" + ExpName + ", DelMark=" + DelMark
				+ "]";
	}
}