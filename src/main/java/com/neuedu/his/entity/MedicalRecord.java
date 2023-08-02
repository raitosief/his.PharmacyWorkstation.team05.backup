package com.neuedu.his.entity;

public class MedicalRecord {
	private Integer ID;// ID 自增长类型
    private String CaseNumber;// 病历号
    private Integer RegistID;// 挂号 ID 指向 Register(ID)
    private String Readme;// 主诉
    private String Present;// 现病史
    private String PresentTreat;// 现病治疗情况
    private String History;// 既往史
    private String Allergy;// 过敏史
    private String Physique;// 体格检查
    private String Proposal;// 检查建议
    private String Careful;// 注意事项
    private String CheckResult;// 检查结果
    private String Diagnosis;// 诊断结果
    private String Handling;// 处理意见
    private Integer CaseState;// 病历状态 1-暂存 2-已提交 3-诊毕
	public MedicalRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicalRecord(Integer iD, String caseNumber, Integer registID, String readme, String present,
			String presentTreat, String history, String allergy, String physique, String proposal, String careful,
			String checkResult, String diagnosis, String handling, Integer caseState) {
		super();
		ID = iD;
		CaseNumber = caseNumber;
		RegistID = registID;
		Readme = readme;
		Present = present;
		PresentTreat = presentTreat;
		History = history;
		Allergy = allergy;
		Physique = physique;
		Proposal = proposal;
		Careful = careful;
		CheckResult = checkResult;
		Diagnosis = diagnosis;
		Handling = handling;
		CaseState = caseState;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCaseNumber() {
		return CaseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		CaseNumber = caseNumber;
	}
	public Integer getRegistID() {
		return RegistID;
	}
	public void setRegistID(Integer registID) {
		RegistID = registID;
	}
	public String getReadme() {
		return Readme;
	}
	public void setReadme(String readme) {
		Readme = readme;
	}
	public String getPresent() {
		return Present;
	}
	public void setPresent(String present) {
		Present = present;
	}
	public String getPresentTreat() {
		return PresentTreat;
	}
	public void setPresentTreat(String presentTreat) {
		PresentTreat = presentTreat;
	}
	public String getHistory() {
		return History;
	}
	public void setHistory(String history) {
		History = history;
	}
	public String getAllergy() {
		return Allergy;
	}
	public void setAllergy(String allergy) {
		Allergy = allergy;
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
	public Integer getCaseState() {
		return CaseState;
	}
	public void setCaseState(Integer caseState) {
		CaseState = caseState;
	}
	@Override
	public String toString() {
		return "MedicalRecord [ID=" + ID + ", CaseNumber=" + CaseNumber + ", RegistID=" + RegistID + ", Readme="
				+ Readme + ", Present=" + Present + ", PresentTreat=" + PresentTreat + ", History=" + History
				+ ", Allergy=" + Allergy + ", Physique=" + Physique + ", Proposal=" + Proposal + ", Careful=" + Careful
				+ ", CheckResult=" + CheckResult + ", Diagnosis=" + Diagnosis + ", Handling=" + Handling
				+ ", CaseState=" + CaseState + "]";
	}

}
