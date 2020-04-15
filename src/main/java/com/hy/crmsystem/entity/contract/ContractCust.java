package com.hy.crmsystem.entity.contract;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class ContractCust implements Serializable {

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    @TableField("customer_id")
    private Integer customerId;

    //合同名称
    @TableField("contract_name")
    private String contractName;

    //合同编号
    @TableField("contract_num")
    private String contractNum;

    //合同金额
    @TableField("contract_money")
    private String contractMoney;

    //签约日期
    @TableField("signed_time")
    private String signedTime;

    //生效日期
    @TableField("star_time")
    private String  starTime;

    //服务期
    @TableField("service_time")
    private String serviceTime;

    //对方联系人
    private String linkman;

    //固定电话
    private String officeno;

    //移动电话
    private String phoneno;

    //邮箱
    private String email;

    //技术条款
    private String technical;

    //商务条款
    private String commerce;

    //文件
    @TableField("file")
    private String fileName;

    //所属部门
    private Integer ofdept;

    //关联人员
    private String ofpeople;

    //合同状态
    @TableField("contract_status")
    private String contractStatus;

    //优先级
    private String priority;

    //处理过程
    private String process;

    //关键字
    private String keyword;

    //回款额度
    @TableField("return_money")
    private BigDecimal returnMoney;

   //客户名称
    private String cname;

    //所属行业
    private String cindustry;

    //所在城市
    private String ccity;
    //详细地址
    private String caddress;

    //剩余钱数
    @TableField("residue_money")
    private BigDecimal residueMoney;

    //用户ID
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getResidueMoney() {
        return residueMoney;
    }

    public void setResidueMoney(BigDecimal residueMoney) {
        this.residueMoney = residueMoney;
    }

   public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCindustry() {
        return cindustry;
    }

    public void setCindustry(String cindustry) {
        this.cindustry = cindustry;
    }

    public String getCcity() {
        return ccity;
    }

    public void setCcity(String ccity) {
        this.ccity = ccity;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

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

    public String getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(String signedTime) {
        this.signedTime = signedTime;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
        return "ContractCust{" +
                "cid=" + cid +
                ", customerId=" + customerId +
                ", contractName='" + contractName + '\'' +
                ", contractNum='" + contractNum + '\'' +
                ", contractMoney='" + contractMoney + '\'' +
                ", signedTime='" + signedTime + '\'' +
                ", starTime='" + starTime + '\'' +
                ", serviceTime='" + serviceTime + '\'' +
                ", linkman='" + linkman + '\'' +
                ", officeno='" + officeno + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", email='" + email + '\'' +
                ", technical='" + technical + '\'' +
                ", commerce='" + commerce + '\'' +
                ", fileName='" + fileName + '\'' +
                ", ofdept=" + ofdept +
                ", ofpeople='" + ofpeople + '\'' +
                ", contractStatus='" + contractStatus + '\'' +
                ", priority='" + priority + '\'' +
                ", process='" + process + '\'' +
                ", keyword='" + keyword + '\'' +
                ", returnMoney=" + returnMoney +
                ", cname='" + cname + '\'' +
                ", cindustry='" + cindustry + '\'' +
                ", ccity='" + ccity + '\'' +
                ", caddress='" + caddress + '\'' +
                '}';
    }
}
