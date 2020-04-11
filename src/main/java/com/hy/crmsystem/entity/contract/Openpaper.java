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
public class Openpaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    private String address;

    private Date endtime;

    private String theme;

    @TableField("apply_name")
    private String applyName;

    @TableField("apply_of_dept")
    private Integer applyOfDept;

    @TableField("apply_time")
    private Date applyTime;

    private String technical;

    @TableField("unit_name")
    private String unitName;

    @TableField("contract_file")
    private String contractFile;

    @TableField("ticket_class")
    private String ticketClass;

    @TableField("ident_number")
    private String identNumber;

    private String account;

    @TableField("apply_address")
    private String applyAddress;

    @TableField("apply_phone")
    private String applyPhone;

    @TableField("ticket_money")
    private String ticketMoney;

    @TableField("ticket_time")
    private Date ticketTime;

    private String ticketno;

    private String file;

    private String process;

    private Integer priority;

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

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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

    public String getContractFile() {
        return contractFile;
    }

    public void setContractFile(String contractFile) {
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

    public Date getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Date ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
                ", ticketTime=" + ticketTime +
                ", ticketno='" + ticketno + '\'' +
                ", file='" + file + '\'' +
                ", process='" + process + '\'' +
                ", priority=" + priority +
                '}';
    }
}
