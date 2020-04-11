package com.hy.crmsystem.entity.statistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Alias("Returnmoneydetails2")
public class Returnmoneydetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("return_date")
    private Date returnDate;

    @TableField("return_class")
    private String returnClass;

    @TableField("return_money")
    private Integer returnMoney;

    @TableField("money_capital")
    private String moneyCapital;

    @TableField("returnMoneyStyle")
    private Integer return_money_style;

    @TableField("write_people")
    private String writePeople;

    @TableField("relevance_people")
    private String relevancePeople;

    @TableField("relevance_dept")
    private Integer relevanceDept;

    @TableField("customer_company")
    private Integer customerCompany;

    private Integer cid;

    @TableField("return_details")
    private String returnDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnClass() {
        return returnClass;
    }

    public void setReturnClass(String returnClass) {
        this.returnClass = returnClass;
    }

    public Integer getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Integer returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getMoneyCapital() {
        return moneyCapital;
    }

    public void setMoneyCapital(String moneyCapital) {
        this.moneyCapital = moneyCapital;
    }

    public Integer getReturn_money_style() {
        return return_money_style;
    }

    public void setReturn_money_style(Integer return_money_style) {
        this.return_money_style = return_money_style;
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

    public Integer getRelevanceDept() {
        return relevanceDept;
    }

    public void setRelevanceDept(Integer relevanceDept) {
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
                ", return_money_style=" + return_money_style +
                ", writePeople='" + writePeople + '\'' +
                ", relevancePeople='" + relevancePeople + '\'' +
                ", relevanceDept=" + relevanceDept +
                ", customerCompany=" + customerCompany +
                ", cid=" + cid +
                ", returnDetails='" + returnDetails + '\'' +
                '}';
    }
}
