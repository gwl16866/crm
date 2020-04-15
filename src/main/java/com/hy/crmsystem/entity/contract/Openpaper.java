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
public class Openpaper implements Serializable {

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;
    //详细地址
    private String address;
    //结束时间
    private String endtime;
    //开票主题
    private String theme;
    //申请人姓名
    @TableField("apply_name")
    private String applyName;
    //所属部门
    @TableField("apply_of_dept")
    private Integer applyOfDept;
    //申请日期
    @TableField("apply_time")
    private String applyTime;
    //技术条款
    private String technical;
    //对方单位全称
    @TableField("unit_name")
    private String unitName;
    //合同
    @TableField("contract_file")
    private Integer contractFile;
    //开票种类
    @TableField("ticket_class")
    private String ticketClass;
    //识别号
    @TableField("ident_number")
    private String identNumber;
    //银行账号
    private String account;
    //地址
    @TableField("apply_address")
    private String applyAddress;
    //电话
    @TableField("apply_phone")
    private String applyPhone;
    //开票金额
    @TableField("ticket_money")
    private String ticketMoney;
    //金额大写
    @TableField("money_capital")
    private String moneyCapital;
    //开票日期
    @TableField("ticket_time")
    private String ticketTime;
    //发票号码
    private String ticketno;
    //附件
    @TableField("file")
    private String fileName;
    //过程
    private String process;
    //优先级
    private Integer priority;

    public String getMoneyCapital() {
        return moneyCapital;
    }

    public void setMoneyCapital(String moneyCapital) {
        this.moneyCapital = moneyCapital;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Integer getApplyOfDept() {
        return applyOfDept;
    }

    public void setApplyOfDept(Integer applyOfDept) {
        this.applyOfDept = applyOfDept;
    }


    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;

    }

    public Integer getContractFile() {
        return contractFile;
    }

    public void setContractFile(Integer contractFile) {
        this.contractFile = contractFile;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getApplyAddress() {
        return applyAddress;
    }

    public void setApplyAddress(String applyAddress) {
        this.applyAddress = applyAddress;
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    public String getTicketMoney() {
        return ticketMoney;
    }

    public void setTicketMoney(String ticketMoney) {
        this.ticketMoney = ticketMoney;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(String ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Openpaper{" +
                "oid=" + oid +
                ", address='" + address + '\'' +
                ", endtime=" + endtime +
                ", theme='" + theme + '\'' +
                ", applyName='" + applyName + '\'' +
                ", applyOfDept=" + applyOfDept +
                ", applyTime=" + applyTime +
                ", technical='" + technical + '\'' +
                ", unitName='" + unitName + '\'' +
                ", contractFile='" + contractFile + '\'' +
                ", ticketClass='" + ticketClass + '\'' +
                ", identNumber='" + identNumber + '\'' +
                ", account='" + account + '\'' +
                ", applyAddress='" + applyAddress + '\'' +
                ", applyPhone='" + applyPhone + '\'' +
                ", ticketMoney='" + ticketMoney + '\'' +
                ", moneyCapital='" + moneyCapital + '\'' +
                ", ticketTime=" + ticketTime +
                ", ticketno='" + ticketno + '\'' +
                ", fileName='" + fileName + '\'' +
                ", process='" + process + '\'' +
                ", priority=" + priority +
                '}';
    }
}
