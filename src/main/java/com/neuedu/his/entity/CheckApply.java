package com.neuedu.his.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

// 表名：患者检查/检验/处置申请表
public class CheckApply {
    private Integer Count;
    private String StartTime;

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

	private String EndTime;

    private String RealName;
    private String DeptName;
    private Float SUM;
    private Integer ID;// ID 自增长类型
    private Integer MedicalID;// 病历 ID 指向 MedicalRecord(ID)
    private Integer RegistID;// 挂号 ID 指向 Register(ID)
    private Integer ItemID;// 项目 ID 指向 Fmeditem(ID)
    private String Name;// 项目名称
    private String Objective;// 目的要求
    private String Position;// 检查部位
    private Integer IsUrgent;// 是否加急 1 为加急 0 为不加急
    private Integer Num;// 数量

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
    private Date CreationTime;// 开立时间
    private Integer DoctorID;// 开立医生ID 指向 User(ID)
    private Integer CheckOperID;// 检查人员ID 指向 User (ID)
    private Integer ResultOperID;// 结果录入人员 ID 指向 User (ID)
    private Integer CaseNumber;
    private Integer age;
    private Integer gender;


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
    private Date CheckTime;// 检查时间
    private String Result;// 检查结果

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8") //返回时间类型
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //接收时间类型
    private Date ResultTime;// 结果时间
    private Integer State;// 状态1-暂存 2-已开立 3-已交费 4-已登记 5-执行完 6-已退费 0-已作废
    private Integer RecordType;// 记录类型 1-检查 2-检验 3-处置
    private BigDecimal TotalCost;//个人总金额
    private String RegisterName; //患者姓名
    private String ItemName;//检查项目名称
   

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getMedicalID() {
        return MedicalID;
    }

    public void setMedicalID(Integer medicalID) {
        MedicalID = medicalID;
    }

    public Integer getRegistID() {
        return RegistID;
    }

    public void setRegistID(Integer registID) {
        RegistID = registID;
    }

    public Integer getItemID() {
        return ItemID;
    }

    public void setItemID(Integer itemID) {
        ItemID = itemID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getObjective() {
        return Objective;
    }

    public void setObjective(String objective) {
        Objective = objective;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Integer getIsUrgent() {
        return IsUrgent;
    }

    public void setIsUrgent(Integer isUrgent) {
        IsUrgent = isUrgent;
    }

    public Integer getNum() {
        return Num;
    }

    public void setNum(Integer num) {
        Num = num;
    }

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }

    public Integer getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(Integer doctorID) {
        DoctorID = doctorID;
    }

    public Integer getCheckOperID() {
        return CheckOperID;
    }

    public void setCheckOperID(Integer checkOperID) {
        CheckOperID = checkOperID;
    }

    public Integer getResultOperID() {
        return ResultOperID;
    }

    public void setResultOperID(Integer resultOperID) {
        ResultOperID = resultOperID;
    }

    public Date getCheckTime() {
        return CheckTime;
    }

    public void setCheckTime(Date checkTime) {
        CheckTime = checkTime;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public Date getResultTime() {
        return ResultTime;
    }

    public void setResultTime(Date resultTime) {
        ResultTime = resultTime;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public Integer getRecordType() {
        return RecordType;
    }

    public void setRecordType(Integer recordType) {
        RecordType = recordType;
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

    public Float getSUM() {
        return SUM;
    }

    public void setSUM(Float SUM) {
        this.SUM = SUM;
    }


    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public Integer getCaseNumber() {
        return CaseNumber;
    }

    public void setCaseNumber(Integer caseNumber) {
        CaseNumber = caseNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }



	@Override
	public String toString() {
		return "CheckApply [Count=" + Count + ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", RealName="
				+ RealName + ", DeptName=" + DeptName + ", SUM=" + SUM + ", ID=" + ID + ", MedicalID=" + MedicalID
				+ ", RegistID=" + RegistID + ", ItemID=" + ItemID + ", Name=" + Name + ", Objective=" + Objective
				+ ", Position=" + Position + ", IsUrgent=" + IsUrgent + ", Num=" + Num + ", CreationTime="
				+ CreationTime + ", DoctorID=" + DoctorID + ", CheckOperID=" + CheckOperID + ", ResultOperID="
				+ ResultOperID + ", CaseNumber=" + CaseNumber + ", age=" + age + ", gender=" + gender + ", CheckTime="
				+ CheckTime + ", Result=" + Result + ", ResultTime=" + ResultTime + ", State=" + State + ", RecordType="
				+ RecordType + ", TotalCost=" + TotalCost + ", RegisterName=" + RegisterName + ", ItemName=" + ItemName
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + ", getItemName()="
				+ getItemName() + ", getID()=" + getID() + ", getMedicalID()=" + getMedicalID() + ", getRegistID()="
				+ getRegistID() + ", getItemID()=" + getItemID() + ", getName()=" + getName() + ", getObjective()="
				+ getObjective() + ", getPosition()=" + getPosition() + ", getIsUrgent()=" + getIsUrgent()
				+ ", getNum()=" + getNum() + ", getCreationTime()=" + getCreationTime() + ", getDoctorID()="
				+ getDoctorID() + ", getCheckOperID()=" + getCheckOperID() + ", getResultOperID()=" + getResultOperID()
				+ ", getCheckTime()=" + getCheckTime() + ", getResult()=" + getResult() + ", getResultTime()="
				+ getResultTime() + ", getState()=" + getState() + ", getRecordType()=" + getRecordType()
				+ ", getRealName()=" + getRealName() + ", getDeptName()=" + getDeptName() + ", getSUM()=" + getSUM()
				+ ", getCount()=" + getCount() + ", getCaseNumber()=" + getCaseNumber() + ", getAge()=" + getAge()
				+ ", getGender()=" + getGender() + ", getRegisterName()=" + getRegisterName() + ", getTotalCost()="
				+ getTotalCost() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String getRegisterName() {
		return RegisterName;
	}

	public void setRegisterName(String registerName) {
		RegisterName = registerName;
	}

	public BigDecimal getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		TotalCost = totalCost;
	}

	public CheckApply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckApply(Integer count, String startTime, String endTime, String realName, String deptName, Float sUM,
			Integer iD, Integer medicalID, Integer registID, Integer itemID, String name, String objective,
			String position, Integer isUrgent, Integer num, Date creationTime, Integer doctorID, Integer checkOperID,
			Integer resultOperID, Integer caseNumber, Integer age, Integer gender, Date checkTime, String result,
			Date resultTime, Integer state, Integer recordType, BigDecimal totalCost, String registerName,
			String itemName) {
		super();
		Count = count;
		StartTime = startTime;
		EndTime = endTime;
		RealName = realName;
		DeptName = deptName;
		SUM = sUM;
		ID = iD;
		MedicalID = medicalID;
		RegistID = registID;
		ItemID = itemID;
		Name = name;
		Objective = objective;
		Position = position;
		IsUrgent = isUrgent;
		Num = num;
		CreationTime = creationTime;
		DoctorID = doctorID;
		CheckOperID = checkOperID;
		ResultOperID = resultOperID;
		CaseNumber = caseNumber;
		this.age = age;
		this.gender = gender;
		CheckTime = checkTime;
		Result = result;
		ResultTime = resultTime;
		State = state;
		RecordType = recordType;
		TotalCost = totalCost;
		RegisterName = registerName;
		ItemName = itemName;
	}
}

