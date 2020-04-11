package com.hy.crmsystem.entity.contract;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    @TableField("customer_id")
    private Integer customerId;

    @TableField("contract_name")
    private String contractName;

    @TableField("contract_num")
    private String contractNum;

    @TableField("contract_money")
    private String contractMoney;

    @TableField("signed_time")
    private Date signedTime;

    @TableField("star_time")
    private Date starTime;

    @TableField("service_time")
    private Date serviceTime;

    private String linkman;

    private String officeno;

    private String phoneno;

    private String email;

    private String technical;

    private String commerce;

    private String file;

    private Integer ofdept;

    private String ofpeople;

    @TableField("contract_status")
    private String contractStatus;

    private String priority;

    private String process;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(String contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getOfdept() {
        return ofdept;
    }

    public void setOfdept(Integer ofdept) {
        this.ofdept = ofdept;
    }

    public String getOfpeople() {
        return ofpeople;
    }

    public void setOfpeople(String ofpeople) {
        this.ofpeople = ofpeople;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "cid=" + cid +
                ", customerId=" + customerId +
                ", contractName='" + contractName + '\'' +
                ", contractNum='" + contractNum + '\'' +
                ", contractMoney='" + contractMoney + '\'' +
                ", signedTime=" + signedTime +
                ", starTime=" + starTime +
                ", serviceTime=" + serviceTime +
                ", linkman='" + linkman + '\'' +
                ", officeno='" + officeno + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", email='" + email + '\'' +
                ", technical='" + technical + '\'' +
                ", commerce='" + commerce + '\'' +
                ", file='" + file + '\'' +
                ", ofdept=" + ofdept +
                ", ofpeople='" + ofpeople + '\'' +
                ", contractStatus='" + contractStatus + '\'' +
                ", priority='" + priority + '\'' +
                ", process='" + process + '\'' +
                '}';
    }
}
