package com.hy.crmsystem.controller.contract;

import com.hy.crmsystem.entity.contract.Contract;

public class ContractDao {

    public String selectAllCont(Contract contract, Integer condition) {
        StringBuffer sql = new StringBuffer("select c.*,r.* from contract c,customer r where c.customer_id=r.cid and contract_status='1' and 1=1 ");
        //我的合同
        if (contract.getUid() != null) {
            sql.append(" and c.uid = '"+contract.getUid()+"' ");
        }
        //状态
        if (contract.getContractStatus() != null && contract.getContractStatus()<5) {
            sql.append(" and c.contract_status = '"+contract.getContractStatus()+"' ");
        }
      /*  //已搁置 and YEARWEEK( DATE_FORMAT(c.signed_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)
        if (contract.getContractStatus() != null && contract.getContractStatus()==4) {
            sql.append(" and YEARWEEK( DATE_FORMAT(c.time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1) ");
        }*/
        //本周
        if(contract.getContractStatus()!=null && contract.getContractStatus()==5){
            sql.append("  and YEARWEEK( DATE_FORMAT(c.signed_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");

        }
        //本月
        if(contract.getContractStatus()!=null && contract.getContractStatus()==6){
            sql.append("  AND DATE_FORMAT(c.signed_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");

        }
        //本季度
        if(contract.getContractStatus()!=null && contract.getContractStatus()==7){
            sql.append(" and  QUARTER(c.signed_time)=QUARTER(now())");
        }

        //按合同名称
        if (condition != null && condition == 1 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append(" and c.contract_name like '%" + contract.getKeyword() + "%'");
        }
        //按合同编号
        if (condition != null && condition == 2 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append(" and c.contract_num like '%" + contract.getKeyword() + "%'");
        }
        //按合同所属行业
        if (condition != null && condition == 3 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append(" and r.cindustry = '"+contract.getKeyword()+"' ");
        }

        return sql.toString();
    }
}
