package com.neuedu.his.entity;
public class Department {//科室表
	private Integer ID;//id主键
	private String DeptCode;//科室编码
	private String DeptName;//科室名称
	private Integer DeptCategoryID;//科室分类
	private Integer DeptType;//科室类型
	private Integer DelMark;//删除标记
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(Integer iD, String deptCode, String deptName, Integer deptCategoryID, Integer deptType,
			Integer delMark) {
		super();
		ID = iD;
		DeptCode = deptCode;
		DeptName = deptName;
		DeptCategoryID = deptCategoryID;
		DeptType = deptType;
		DelMark = delMark;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getDeptCode() {
		return DeptCode;
	}
	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public Integer getDeptCategoryID() {
		return DeptCategoryID;
	}
	public void setDeptCategoryID(Integer deptCategoryID) {
		DeptCategoryID = deptCategoryID;
	}
	public Integer getDeptType() {
		return DeptType;
	}
	public void setDeptType(Integer deptType) {
		DeptType = deptType;
	}
	public Integer getDelMark() {
		return DelMark;
	}
	public void setDelMark(Integer delMark) {
		DelMark = delMark;
	}
	@Override
	public String toString() {
		return "department [ID=" + ID + ", DeptCode=" + DeptCode + ", DeptName=" + DeptName + ", DeptCategoryID="
				+ DeptCategoryID + ", DeptType=" + DeptType + ", DelMark=" + DelMark + "]";
	}
	

}
