package com.neuedu.his.entity;

import java.beans.Transient;

// 表名：成药模板明细表
public class DrugsDetailed {
    private Integer ID;// ID 自增长类型
    private Integer DrugsTempID;// 成药模板ID 指向 DrugsTemplate(ID)
    private Integer DrugsID;// 药品 ID 指向 Drugs (ID)
    private String DrugsUsage;// 用法
    private String Dosage;// 用量
    private String Frequency;// 频次
    private String DrugsName;//药品名

    public Integer getID() {
        return ID;
    }

    public DrugsDetailed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrugsDetailed(Integer iD, Integer drugsTempID, Integer drugsID, String drugsUsage, String dosage,
			String frequency, String drugsName) {
		super();
		ID = iD;
		DrugsTempID = drugsTempID;
		DrugsID = drugsID;
		DrugsUsage = drugsUsage;
		Dosage = dosage;
		Frequency = frequency;
		DrugsName = drugsName;
	}

	public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getDrugsTempID() {
        return DrugsTempID;
    }

    public void setDrugsTempID(Integer drugsTempID) {
        DrugsTempID = drugsTempID;
    }

    public Integer getDrugsID() {
        return DrugsID;
    }

    public void setDrugsID(Integer drugsID) {
        DrugsID = drugsID;
    }

    public String getDrugsUsage() {
        return DrugsUsage;
    }

    public void setDrugsUsage(String drugsUsage) {
        DrugsUsage = drugsUsage;
    }

    public String getDosage() {
        return Dosage;
    }

    public void setDosage(String dosage) {
        Dosage = dosage;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String frequency) {
        Frequency = frequency;
    }

    @Override
	public String toString() {
		return "DrugsDetailed [ID=" + ID + ", DrugsTempID=" + DrugsTempID + ", DrugsID=" + DrugsID + ", DrugsUsage="
				+ DrugsUsage + ", Dosage=" + Dosage + ", Frequency=" + Frequency + ", DrugsName=" + DrugsName
				+ ", getID()=" + getID() + ", getDrugsTempID()=" + getDrugsTempID() + ", getDrugsID()=" + getDrugsID()
				+ ", getDrugsUsage()=" + getDrugsUsage() + ", getDosage()=" + getDosage() + ", getFrequency()="
				+ getFrequency() + ", getDrugsName()=" + getDrugsName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getDrugsName() {
		return DrugsName;
	}

	public void setDrugsName(String drugsName) {
		DrugsName = drugsName;
	}
}
