package com.hy.crmsystem.mapper.bussinessOppo;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider2 {


    public String select_businessoppo_like(@Param("businessoppo") Businessoppo businessoppo) {

        StringBuffer buffer = new StringBuffer("select bid,bname,status,bpredict_money,bprincipal,last_time from businessoppo where 1=1 ");
        if (!StringUtils.isNullOrEmpty(businessoppo.getBname())) {
            buffer.append(" and bname like '%" + businessoppo.getBname() + "%'");
        }

        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()<=3) {
        buffer.append(" and status=" + businessoppo.getStatus()+"");
    }
        if (!StringUtils.isNullOrEmpty(businessoppo.getBprincipal())) {
            buffer.append(" and bprincipal like '%" + businessoppo.getBprincipal() + "%'");
        }
        if (!StringUtils.isNullOrEmpty(businessoppo.getBpredictMoney())) {
            buffer.append(" and bpredict_money like '%" + businessoppo.getBpredictMoney() + "%'");
        }
        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()==9) {
            buffer.append(" and status=" + businessoppo.getStatus()+"");
        }
        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()==10) {
            buffer.append(" and status=" + businessoppo.getStatus()+"");
        }
        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()==11) {
            buffer.append(" and status=" + businessoppo.getStatus()+"");
        }
        return buffer.toString();
    }

    /*
     * 查询新增条数
     * */
    public String selectNewCount(@Param("type") String type){
        StringBuffer buffer = new StringBuffer("select count(*) from businessoppo where 1=1");
        if(type.equals("6")){
            //11代表本周
            buffer.append(" and YEARWEEK( DATE_FORMAT(insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }else if(type.equals("7")){
            //13代表本月
            buffer.append(" AND  DATE_FORMAT(insert_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }else if(type.equals("8")){
            //15代表本季度
            buffer.append(" AND QUARTER(insert_date)=QUARTER(NOW())");
        }
        return buffer.toString();
    }



}
