package com.hy.crmsystem.entity.customerManager;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * 客户管理总表
 */
/*SELECT c.cname,c.bussiness_count,b.bpredict_money,c.contract_count,c1.contract_money,r.return_money,c.caftersale_count,a.service_score FROM customer c,businessoppo b,aftersell a,contract c1,returnmoneydetails r WHERE c.cid=b.cid AND c.cid=c1.customer_id AND c.cid=a.customer_id AND a.cid=c1.cid AND c1.cid=r.cid;*/
public class Kehuiganlizonghe implements Serializable {
    /*客户名称*/
    private  String cname;
  /*  商机数*/
    @TableField("bussiness_count")
    private  int bussinessCount;
  /*  预计成交金额*/
    @TableField("bpredict_money")
    private String bpredictMoney;
  /*  合同数*/
    @TableField("contract_count")
    private int contractCount;
  /*  合同金额*/
    @TableField("contract_money")
    private String contractMoney;
   /* 回款额*/
    @TableField("return_money")
    private int returnMoney;
   /* 售后服务数*/
    @TableField("caftersale_count")
    private  int caftersaleCount;
  /*  服务均分*/
    @TableField("service_score")
    private int serviceScore;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getBussinessCount() {
        return bussinessCount;
    }

    public void setBussinessCount(int bussinessCount) {
        this.bussinessCount = bussinessCount;
    }

    public String getBpredictMoney() {
        return bpredictMoney;
    }

    public void setBpredictMoney(String bpredictMoney) {
        this.bpredictMoney = bpredictMoney;
    }

    public int getContractCount() {
        return contractCount;
    }

    public void setContractCount(int contractCount) {
        this.contractCount = contractCount;
    }

    public String getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(String contractMoney) {
        this.contractMoney = contractMoney;
    }

    public int getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(int returnMoney) {
        this.returnMoney = returnMoney;
    }

    public int getCaftersaleCount() {
        return caftersaleCount;
    }

    public void setCaftersaleCount(int caftersaleCount) {
        this.caftersaleCount = caftersaleCount;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }
}
