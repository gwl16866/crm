package com.hy.crmsystem.entity.afterSell;

import com.baomidou.mybatisplus.annotation.TableField;

import java.sql.Date;

public class AfterSellBoTwo {

    private static final long serialVersionUID = 1L;



    @TableField("theme")
    private Integer themeNo;

    private Integer status;

    @TableField("customer_id")
    private Integer customerId;

    private String cid;

    @TableField("contract_infor")
    private String contractInfor;

    private String linkman;

    private String officeno;

    private String phoneno;

    private String emails;

    @TableField("service_type")
    private String serviceType;

    @TableField("service_style")
    private String serviceStyle;

    private java.sql.Date starttime;

    private java.sql.Date endtime;

    @TableField("service_text")
    private String serviceText;

    @TableField("customer_return")
    private String customerReturn;

    @TableField("service_people")
    private String username;

    @TableField("service_score")
    private Integer serviceScore;

    private String file;


    public Integer getThemeNo() {
        return themeNo;
    }

    public void setThemeNo(Integer themeNo) {
        this.themeNo = themeNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getContractInfor() {
        return contractInfor;
    }

    public void setContractInfor(String contractInfor) {
        this.contractInfor = contractInfor;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getOfficeno() {
        return officeno;
    }

    public void setOfficeno(String officeno) {
        this.officeno = officeno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceStyle() {
        return serviceStyle;
    }

    public void setServiceStyle(String serviceStyle) {
        this.serviceStyle = serviceStyle;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getServiceText() {
        return serviceText;
    }

    public void setServiceText(String serviceText) {
        this.serviceText = serviceText;
    }

    public String getCustomerReturn() {
        return customerReturn;
    }

    public void setCustomerReturn(String customerReturn) {
        this.customerReturn = customerReturn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Aftersell{" +

                ", status=" + status +
                ", customerId=" + customerId +
                ", cid='" + cid + '\'' +
                ", contractInfor='" + contractInfor + '\'' +
                ", linkman='" + linkman + '\'' +
                ", officeno='" + officeno + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", emails='" + emails + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceStyle='" + serviceStyle + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", serviceText='" + serviceText + '\'' +
                ", customerReturn='" + customerReturn + '\'' +
                ", servicePeople='" + username + '\'' +
                ", serviceScore=" + serviceScore +
                ", file='" + file + '\'' +
                '}';
    }
}
