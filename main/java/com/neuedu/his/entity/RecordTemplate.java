package com.neuedu.his.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 表名：患者病历模板表
public class RecordTemplate {
    private Integer ID;// ID 自增长类型
    private String Name;// 名称
    private Integer DeptID;
    private Integer UserID;// 医生 ID 指向 User (ID)

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

    public RecordTemplate() {
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CreationTime;// 创建时间
    private String Scope;// 使用范围 全院/科室/个人

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

    private Integer DelMark;// 删除标记 1-正常 0-已删除

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }

    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
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

    public Integer getDelMark() {
        return DelMark;
    }

    public void setDelMark(Integer delMark) {
        DelMark = delMark;
    }

    public RecordTemplate(Integer ID, String name, Integer deptID, Integer userID, Date creationTime, String scope, String readme, String present, String presentTreat, String history, String allergy, String physique, String proposal, String careful, String checkResult, String diagnosis, String handling, Integer delMark) {
        this.ID = ID;
        Name = name;
        DeptID = deptID;
        UserID = userID;
        CreationTime = creationTime;
        Scope = scope;
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
        DelMark = delMark;
    }

    public RecordTemplate(Integer deptID) {
        DeptID = deptID;
    }

    @Override
    public String toString() {
        return "RecordTemplate{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", DeptID=" + DeptID +
                ", UserID=" + UserID +
                ", CreationTime=" + CreationTime +
                ", Scope='" + Scope + '\'' +
                ", Readme='" + Readme + '\'' +
                ", Present='" + Present + '\'' +
                ", PresentTreat='" + PresentTreat + '\'' +
                ", History='" + History + '\'' +
                ", Allergy='" + Allergy + '\'' +
                ", Physique='" + Physique + '\'' +
                ", Proposal='" + Proposal + '\'' +
                ", Careful='" + Careful + '\'' +
                ", CheckResult='" + CheckResult + '\'' +
                ", Diagnosis='" + Diagnosis + '\'' +
                ", Handling='" + Handling + '\'' +
                ", DelMark=" + DelMark +
                '}';
    }
}
