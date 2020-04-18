package com.hy.crmsystem.entity.afterSell;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.sql.Date;

public class AfterSellThree implements Serializable {


    private Integer status;
    private Integer aid;

    @TableField("theme")
    private String theme;

    @TableField("cname")
    private String cname;

    @TableField("contract_name")
    private String contractName;

    @TableField("contract_num")
    private String contractNum;

    @TableField("contract_infor")
    private String contractInfor;

    private String linkman;

    private String officeno;

    private String phoneno;

    private String emails;

    @TableField("service_type")
    private String serviceType;

    @TableField("service_people")
    private String servicePeople;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getServicePeople() {
        return servicePeople;
    }

    public void setServicePeople(String servicePeople) {
        this.servicePeople = servicePeople;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
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

}
