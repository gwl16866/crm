package com.hy.crmsystem.entity.customerManager;

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
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    private Integer mid;

    private String cname;

    private String cspell;

    private Integer cclass;

    private Integer csource;

    private String cindustry;

    private String curl;

    private String cnation;

    private String ccity;

    private String caddress;

    private String cpostalcode;

    private String cfax;

    private String clinkman;

    private String cdept;

    private String cjob;

    private String cofficeno;

    private String cphonrno;

    private String cemail;

    @TableField("clegal_person")
    private String clegalPerson;

    /**
     * ע
     */
    private String ccapital;

    /**
     * ˵
     */
    private String cexplain;
    @TableField("caftersale_count")
    private Integer caftersaleCount;
    @TableField("bussiness_count")
    private Integer bussinessCount;
    @TableField("contract_count")
    private Integer contractCount;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getCspell() {
        return cspell;
    }

    public void setCspell(String cspell) {
        this.cspell = cspell;
    }
    public Integer getCclass() {
        return cclass;
    }

    public void setCclass(Integer cclass) {
        this.cclass = cclass;
    }
    public Integer getCsource() {
        return csource;
    }

    public void setCsource(Integer csource) {
        this.csource = csource;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }
    public String getCnation() {
        return cnation;
    }

    public void setCnation(String cnation) {
        this.cnation = cnation;
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
    public String getCpostalcode() {
        return cpostalcode;
    }

    public void setCpostalcode(String cpostalcode) {
        this.cpostalcode = cpostalcode;
    }
    public String getCfax() {
        return cfax;
    }

    public void setCfax(String cfax) {
        this.cfax = cfax;
    }
    public String getClinkman() {
        return clinkman;
    }

    public void setClinkman(String clinkman) {
        this.clinkman = clinkman;
    }
    public String getCdept() {
        return cdept;
    }

    public void setCdept(String cdept) {
        this.cdept = cdept;
    }
    public String getCjob() {
        return cjob;
    }

    public void setCjob(String cjob) {
        this.cjob = cjob;
    }
    public String getCofficeno() {
        return cofficeno;
    }

    public void setCofficeno(String cofficeno) {
        this.cofficeno = cofficeno;
    }
    public String getCphonrno() {
        return cphonrno;
    }

    public void setCphonrno(String cphonrno) {
        this.cphonrno = cphonrno;
    }
    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCcapital() {
        return ccapital;
    }

    public void setCcapital(String ccapital) {
        this.ccapital = ccapital;
    }
    public String getCexplain() {
        return cexplain;
    }

    public void setCexplain(String cexplain) {
        this.cexplain = cexplain;
    }

    public Integer getCaftersaleCount() {
        return caftersaleCount;
    }

    public void setCaftersaleCount(Integer caftersaleCount) {
        this.caftersaleCount = caftersaleCount;
    }

    public Integer getBussinessCount() {
        return bussinessCount;
    }

    public void setBussinessCount(Integer bussinessCount) {
        this.bussinessCount = bussinessCount;
    }

    public Integer getContractCount() {
        return contractCount;
    }

    public void setContractCount(Integer contractCount) {
        this.contractCount = contractCount;
    }

    public String getClegalPerson() {
        return clegalPerson;
    }

    public void setClegalPerson(String clegalPerson) {
        this.clegalPerson = clegalPerson;
    }

    public String getCindustry() {
        return cindustry;
    }

    public void setCindustry(String cindustry) {
        this.cindustry = cindustry;
    }

    @Override
    public String toString() {
        return "Customer{" +
        "cid=" + cid +
        ", mid=" + mid +
        ", cname=" + cname +
        ", cspell=" + cspell +
        ", cclass=" + cclass +
        ", csource=" + csource +
        ", cindustry=" + cindustry +
        ", curl=" + curl +
        ", cnation=" + cnation +
        ", ccity=" + ccity +
        ", caddress=" + caddress +
        ", cpostalcode=" + cpostalcode +
        ", cfax=" + cfax +
        ", clinkman=" + clinkman +
        ", cdept=" + cdept +
        ", cjob=" + cjob +
        ", cofficeno=" + cofficeno +
        ", cphonrno=" + cphonrno +
        ", cemail=" + cemail +
        ", clegal_person=" + clegalPerson +
        ", ccapital=" + ccapital +
        ", cexplain=" + cexplain +
        ", caftersale_count=" + caftersaleCount +
        ", bussiness_count=" + bussinessCount +
        ", contract_count=" + contractCount +
        "}";
    }
}
