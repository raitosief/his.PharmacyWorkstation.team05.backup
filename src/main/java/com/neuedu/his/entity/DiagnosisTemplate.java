package com.neuedu.his.entity;

// 表名：医生诊断模板表
public class DiagnosisTemplate {
    private Integer ID;// ID 自增长类型
    private Integer UserID;// 医生 ID 指向 User (ID)
    private String TempName;//模板名称
    private String Physique;//体格检查
    private String Proposal;//检查建议
    private String Careful;//注意事项
    private String CheckResult;//检查结果
    private String Diagnosis;// 诊断结果
    private String Handling;// 处理意见
    
	public DiagnosisTemplate(Integer iD, Integer userID, String tempName, String physique, String proposal,
			String careful, String checkResult, String diagnosis, String handling) {
		super();
		ID = iD;
		UserID = userID;
		TempName = tempName;
		Physique = physique;
		Proposal = proposal;
		Careful = careful;
		CheckResult = checkResult;
		Diagnosis = diagnosis;
		Handling = handling;
	}

	public DiagnosisTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	public String getTempName() {
		return TempName;
	}

	public void setTempName(String tempName) {
		TempName = tempName;
	}

	public String getPhysique() {
		return Physique;
	}

	public void setPhysique(String physique) {
		Physique = physique;
	}

	public String getProposal() {
		return Proposal;
	}

	public void setProposal(String proposal) {
		Proposal = proposal;
	}

	public String getCareful() {
		return Careful;
	}

	public void setCareful(String careful) {
		Careful = careful;
	}

	public String getCheckResult() {
		return CheckResult;
	}

	public void setCheckResult(String checkResult) {
		CheckResult = checkResult;
	}

	public String getDiagnosis() {
		return Diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}

	public String getHandling() {
		return Handling;
	}

	public void setHandling(String handling) {
		Handling = handling;
	}

	@Override
	public String toString() {
		return "DiagnosisTemplate [ID=" + ID + ", UserID=" + UserID + ", TempName=" + TempName + ", Physique="
				+ Physique + ", Proposal=" + Proposal + ", Careful=" + Careful + ", CheckResult=" + CheckResult
				+ ", Diagnosis=" + Diagnosis + ", Handling=" + Handling + ", getID()=" + getID() + ", getUserID()="
				+ getUserID() + ", getTempName()=" + getTempName() + ", getPhysique()=" + getPhysique()
				+ ", getProposal()=" + getProposal() + ", getCareful()=" + getCareful() + ", getCheckResult()="
				+ getCheckResult() + ", getDiagnosis()=" + getDiagnosis() + ", getHandling()=" + getHandling()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

 
}
