package com.hy.crmsystem.mapper.bussinessOppo;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider2 {


    public String select_businessoppo_like(@Param("businessoppo") Businessoppo businessoppo) {
        System.out.println(businessoppo.getStatus()+"99999999999999999999999999999999999999999999999999999999999");

        StringBuffer buffer = new StringBuffer("select bid,bname,status,bpredict_money,bprincipal,last_time from businessoppo where 1=1 ");
        if (!StringUtils.isNullOrEmpty(businessoppo.getBname())) {
            buffer.append(" and bname like '%" + businessoppo.getBname() + "%'");
        }

        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()!=0) {
        buffer.append(" and status=" + businessoppo.getStatus()+"");
    }
        if (!StringUtils.isNullOrEmpty(businessoppo.getBprincipal())) {
            buffer.append(" and bprincipal like '%" + businessoppo.getBprincipal() + "%'");
        }
        if (!StringUtils.isNullOrEmpty(businessoppo.getBpredictMoney())) {
            buffer.append(" and bpredict_money like '%" + businessoppo.getBpredictMoney() + "%'");
        }

        return buffer.toString();
    }
}
