package com.hy.crmsystem.entity.bussinessOppo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Businessoppo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    private Integer cid;

    private String bname;

    @TableField("bpredict_money")
    private String bpredictMoney;

    @TableField("bover_date")
    private Date boverDate;

    private String blinkman;

    private Integer bdept;

    private String bjob;

    private String bofficeno;

    private String bphoneno;

    private String bemail;

    private String bneed;

    private String bfile;

    @TableField("bof_dept")
    private String bofDept;

    private String bprincipal;

    @TableField("bjoin_man")
    private String bjoinMan;

    private String battention;

    private String priority;

    private Integer status;
    @TableField("last_time")
    private Date lastTime;


    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }



    public String getBpredictMoney() {
        return bpredictMoney;
    }

    public void setBpredictMoney(String bpredictMoney) {
        this.bpredictMoney = bpredictMoney;
    }

    public Date getBoverDate() {
        return boverDate;
    }

    public void setBoverDate(Date boverDate) {
        this.boverDate = boverDate;
    }

    public String getBlinkman() {
        return blinkman;
    }

    public void setBlinkman(String blinkman) {
        this.blinkman = blinkman;
    }

    public Integer getBdept() {
        return bdept;
    }

    public void setBdept(Integer bdept) {
        this.bdept = bdept;
    }

    public String getBjob() {
        return bjob;
    }

    public void setBjob(String bjob) {
        this.bjob = bjob;
    }

    public String getBofficeno() {
        return bofficeno;
    }

    public void setBofficeno(String bofficeno) {
        this.bofficeno = bofficeno;
    }

    public String getBphoneno() {
        return bphoneno;
    }

    public void setBphoneno(String bphoneno) {
        this.bphoneno = bphoneno;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getBneed() {
        return bneed;
    }

    public void setBneed(String bneed) {
        this.bneed = bneed;
    }

    public String getBfile() {
        return bfile;
    }

    public void setBfile(String bfile) {
        this.bfile = bfile;
    }

    public String getBofDept() {
        return bofDept;
    }

    public void setBofDept(String bofDept) {
        this.bofDept = bofDept;
    }

    public String getBprincipal() {
        return bprincipal;
    }

    public void setBprincipal(String bprincipal) {
        this.bprincipal = bprincipal;
    }

    public String getBjoinMan() {
        return bjoinMan;
    }

    public void setBjoinMan(String bjoinMan) {
        this.bjoinMan = bjoinMan;
    }

    public String getBattention() {
        return battention;
    }

    public void setBattention(String battention) {
        this.battention = battention;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "Businessoppo{" +
                "bid=" + bid +
                ", cid=" + cid +
                ", bname='" + bname + '\'' +
                ", bpredictMoney='" + bpredictMoney + '\'' +
                ", boverDate=" + boverDate +
                ", blinkman='" + blinkman + '\'' +
                ", bdept=" + bdept +
                ", bjob='" + bjob + '\'' +
                ", bofficeno='" + bofficeno + '\'' +
                ", bphoneno='" + bphoneno + '\'' +
                ", bemail='" + bemail + '\'' +
                ", bneed='" + bneed + '\'' +
                ", bfile='" + bfile + '\'' +
                ", bofDept='" + bofDept + '\'' +
                ", bprincipal='" + bprincipal + '\'' +
                ", bjoinMan='" + bjoinMan + '\'' +
                ", battention='" + battention + '\'' +
                ", priority='" + priority + '\'' +
                ", status=" + status +
                ", lastTime=" + lastTime +
                '}';
    }
}
