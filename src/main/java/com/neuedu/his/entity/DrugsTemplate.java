package com.neuedu.his.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;;

// 表名：成药处方模板表
public class DrugsTemplate {
    private Integer ID;// ID 自增长类型
    private String Name;// 名称
    private Integer UserID;// 医生 ID 指向 User (ID)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date CreationTime;// 创建时间
    private String Scope;// 使用范围 全院/科室/个人
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

    public Integer getDelMark() {
        return DelMark;
    }

    public void setDelMark(Integer delMark) {
        DelMark = delMark;
    }

    @Override
    public String toString() {
        return "DrugsTemplate{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", UserID=" + UserID +
                ", CreationTime=" + CreationTime +
                ", Scope='" + Scope + '\'' +
                ", DelMark=" + DelMark +
                '}';
    }
}
