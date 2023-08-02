package com.neuedu.his.entity;

// 表名：用户表
public class User {
    private Integer ID;// ID 自增长类型
    private String UserName;// 登录名
    private String Password;// 密码
    private String RealName;// 真实姓名
    private Integer UseType;// 用户类别 1-医院管理员 2-挂号收费员 3-门诊医生 4-医技医生 5-药房操作员 6-财务管理员 7-患者
    private Integer DocTitleID;// 医生职称 ID 指向ConstantItem（ID）
    private String IsScheduling;// 是否参与排班 是/否
    private Integer DeptID;// 所在科室 ID 指向Department( ID )
    private Integer RegistLeID;// 挂号级别 ID 指向RegistLevel(ID)
    private Integer DelMark;// 删除标记 1-正常 0-已删除

    public User(Integer ID, String userName, String password, String realName, Integer useType, Integer docTitleID, String isScheduling, Integer deptID, Integer registLeID, Integer delMark) {
        this.ID = ID;
        UserName = userName;
        Password = password;
        RealName = realName;
        UseType = useType;
        DocTitleID = docTitleID;
        IsScheduling = isScheduling;
        DeptID = deptID;
        RegistLeID = registLeID;
        DelMark = delMark;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public Integer getUseType() {
        return UseType;
    }

    public void setUseType(Integer useType) {
        UseType = useType;
    }

    public Integer getDocTitleID() {
        return DocTitleID;
    }

    public void setDocTitleID(Integer docTitleID) {
        DocTitleID = docTitleID;
    }

    public String getIsScheduling() {
        return IsScheduling;
    }

    public void setIsScheduling(String isScheduling) {
        IsScheduling = isScheduling;
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

    public Integer getRegistLeID() {
        return RegistLeID;
    }

    public void setRegistLeID(Integer registLeID) {
        RegistLeID = registLeID;
    }

    public Integer getDelMark() {
        return DelMark;
    }

    public void setDelMark(Integer delMark) {
        DelMark = delMark;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", RealName='" + RealName + '\'' +
                ", UseType=" + UseType +
                ", DocTitleID=" + DocTitleID +
                ", IsScheduling='" + IsScheduling + '\'' +
                ", DeptID=" + DeptID +
                ", RegistLeID=" + RegistLeID +
                ", DelMark=" + DelMark +
                '}';
    }

    
}
