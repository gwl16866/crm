package com.hy.crmsystem.entity.contract;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Returnmoneydetails implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //回款日期
    @TableField("return_date")
    private String returnDate;

    //收入分类
    @TableField("return_class")
    private String returnClass;

    //收入金额
    @TableField("return_money")
    private String returnMoney;

    //金额大写
    @TableField("money_capital")
    private String moneyCapital;

    //回款方式
    @TableField("return_money_style")
    private String returnMoneyStyle;

    //登记人
    @TableField("write_people")
    private String writePeople;

    //关联人
    @TableField("relevance_people")
    private String relevancePeople;

    //关联部门
    @TableField("relevance_dept")
    private String relevanceDept;

    //客户单位
    @TableField("customer_company")
    private Integer customerCompany;

    //合同
    private Integer cid;

    //收入说明
    @TableField("return_details")
    private String returnDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnClass() {
        return returnClass;
    }

    public void setReturnClass(String returnClass) {
        this.returnClass = returnClass;
    }

    public String getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(String returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getMoneyCapital() {
        return moneyCapital;
    }

    public void setMoneyCapital(String moneyCapital) {
        this.moneyCapital = moneyCapital;
    }

    public String getReturnMoneyStyle() {
        return returnMoneyStyle;
    }

    public void setReturnMoneyStyle(String returnMoneyStyle) {
        this.returnMoneyStyle = returnMoneyStyle;
    }

    public String getWritePeople() {
        return writePeople;
    }

    public void setWritePeople(String writePeople) {
        this.writePeople = writePeople;
    }

    public String getRelevancePeople() {
        return relevancePeople;
    }

    public void setRelevancePeople(String relevancePeople) {
        this.relevancePeople = relevancePeople;
    }

    public String getRelevanceDept() {
        return relevanceDept;
    }

    public void setRelevanceDept(String relevanceDept) {
        this.relevanceDept = relevanceDept;
    }

    public Integer getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(Integer customerCompany) {
        this.customerCompany = customerCompany;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getReturnDetails() {
        return returnDetails;
    }

    public void setReturnDetails(String returnDetails) {
        this.returnDetails = returnDetails;
    }

    @Override
    public String toString() {
        return "Returnmoneydetails{" +
                "id=" + id +
                ", returnDate=" + returnDate +
                ", returnClass='" + returnClass + '\'' +
                ", returnMoney=" + returnMoney +
                ", moneyCapital='" + moneyCapital + '\'' +
                ", returnMoneyStyle=" + returnMoneyStyle +
                ", writePeople='" + writePeople + '\'' +
                ", relevancePeople='" + relevancePeople + '\'' +
                ", relevanceDept=" + relevanceDept +
                ", customerCompany=" + customerCompany +
                ", cid=" + cid +
                ", returnDetails='" + returnDetails + '\'' +
                '}';
    }
}
