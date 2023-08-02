package com.neuedu.his.entity;



public class WorkloadStatistics {//工作量统计
	 private Integer ID;//
	    private String Name;//项目名称
	    private float Price;//项目单价
	    private float Amount;//数量
	    private Integer DeptID;//执行科室id
	    private String DeptName;//科室名称
	    private String DeptType;//科室类型
	    private String StartTime;//开始时间
	    private String EndTime;//结束时间
	    
	    private float revenue;//单项项目的金额
	   		public WorkloadStatistics() {
			super();
			// TODO Auto-generated constructor stub
		}
		public WorkloadStatistics(Integer iD, String name, float price, float amount, Integer deptID, String deptName,
				String deptType, String startTime, String endTime, float revenue) {
			super();
			ID = iD;
			Name = name;
			Price = price;
			Amount = amount;
			DeptID = deptID;
			DeptName = deptName;
			DeptType = deptType;
			StartTime = startTime;
			EndTime = endTime;
			this.revenue = revenue;
		}
		public Integer getID() {
			return ID;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public float getPrice() {
			return Price;
		}
		public void setPrice(float price) {
			Price = price;
		}
		public float getAmount() {
			return Amount;
		}
		public void setAmount(float amount) {
			Amount = amount;
		}
		public Integer getDeptID() {
			return DeptID;
		}
		public void setDeptID(Integer deptID) {
			DeptID = deptID;
		}
		public String getDeptName() {
			return DeptName;
		}
		public void setDeptName(String deptName) {
			DeptName = deptName;
		}
		public String getDeptType() {
			return DeptType;
		}
		public void setDeptType(String deptType) {
			DeptType = deptType;
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
		public float getRevenue() {
			return revenue;
		}
		public void setRevenue(float revenue) {
			this.revenue = revenue;
		}
		@Override
		public String toString() {
			return "WorkloadStatistics [ID=" + ID + ", Name=" + Name + ", Price=" + Price + ", Amount=" + Amount
					+ ", DeptID=" + DeptID + ", DeptName=" + DeptName + ", DeptType=" + DeptType + ", StartTime="
					+ StartTime + ", EndTime=" + EndTime + ", revenue=" + revenue + "]";
		}
	    

}