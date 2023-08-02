package com.neuedu.his.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;;

// 表名：非药品收费项目表
public class Fmeditem {
    private Integer ID;// ID 自增长类型
    private String ItemCode;// 项目编码
    private String ItemName;// 项目名称
    private String Format;// 规格
    private BigDecimal Price;// 单价
    private Integer ExpClassID;// 所属费用科目 ID 指向 ExpenseClass(ID)
    private Integer DeptID;// 执行科室 ID 指向 Department(ID)
    private String MnemonicCode;// 拼音助记码

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CreationDate;// 创建时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date LastUpdateDate;// 最后修改时间
    private Integer RecordType;// 项目类型 1-检查 2-检验 3-处置
    private Integer DelMark;// 删除标记 1-正常 0-已删除

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public Integer getExpClassID() {
        return ExpClassID;
    }

    public void setExpClassID(Integer expClassID) {
        ExpClassID = expClassID;
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

    public String getMnemonicCode() {
        return MnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        MnemonicCode = mnemonicCode;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreationDate() {
        return CreationDate;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return LastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        LastUpdateDate = lastUpdateDate;
    }

    public Integer getRecordType() {
        return RecordType;
    }

    public void setRecordType(Integer recordType) {
        RecordType = recordType;
    }

    public Integer getDelMark() {
        return DelMark;
    }

    public void setDelMark(Integer delMark) {
        DelMark = delMark;
    }

    @Override
    public String toString() {
        return "Fmeditem{" +
                "ID=" + ID +
                ", ItemCode='" + ItemCode + '\'' +
                ", ItemName='" + ItemName + '\'' +
                ", Format='" + Format + '\'' +
                ", Price=" + Price +
                ", ExpClassID=" + ExpClassID +
                ", DeptID=" + DeptID +
                ", MnemonicCode='" + MnemonicCode + '\'' +
                ", CreationDate=" + CreationDate +
                ", LastUpdateDate=" + LastUpdateDate +
                ", RecordType=" + RecordType +
                ", DelMark=" + DelMark +
                '}';
    }
}
