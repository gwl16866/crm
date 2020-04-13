package com.hy.crmsystem.controller.contract;

import com.hy.crmsystem.entity.contract.Contract;

public class ContractDao {

    public String selectAllCont(Contract contract, Integer condition) {
        StringBuffer sql = new StringBuffer("select * from contract where  1=1  ");
        //按合同名称
        if (condition != null && condition == 1 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append("and contract_name like '%" + contract.getKeyword() + "%'");
        }
        //按合同编号
        if (condition != null && condition == 2 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append("and contract_num like '%" + contract.getKeyword() + "%'");
        }
        //按合同所属部门
        if (condition != null && condition == 3 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append("and ofdept like '%" + contract.getKeyword() + "%'");
        }//按关联人员
        if (condition != null && condition == 4 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append("and ofpeople like '%" + contract.getKeyword() + "%'");
        }
        //按合同金额
        if (condition != null && condition == 5 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append("and contract_money like '%" + contract.getKeyword() + "%'");
        }
        //按签约日期
        if (condition != null && condition == 6 && contract.getKeyword() != null && contract.getKeyword() != "") {
            sql.append("and signed_time like '%" + contract.getKeyword() + "%'");
        }

        return sql.toString();
    }
}
