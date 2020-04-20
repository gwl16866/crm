package com.hy.crmsystem.mapper.bussinessOppo;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider2 {


    public String select_businessoppo_like(@Param("businessoppo") Businessoppo businessoppo) {

        StringBuffer buffer = new StringBuffer("select b.*,u.* from businessoppo b,user u where b.bprincipal=u.uid and 1=1 ");
        //我的商机
        if (businessoppo.getBprincipal() != null) {
            buffer.append(" and b.bprincipal = " + businessoppo.getBprincipal()+" ");
        }
//商机名称
        if (!StringUtils.isNullOrEmpty(businessoppo.getBname())) {
            buffer.append(" and b.bname like '%" + businessoppo.getBname() + "%'");
        }
        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()<=3) {
        buffer.append(" and b.status=" + businessoppo.getStatus()+"");
        }
        if (!StringUtils.isNullOrEmpty(businessoppo.getBpredictMoney())) {
            buffer.append(" and b.bpredict_money like '%" + businessoppo.getBpredictMoney() + "%'");
        }
        //七天
        if(null!=businessoppo.getStatus() && businessoppo.getStatus()==4){
            buffer.append(" and YEARWEEK( DATE_FORMAT(b.last_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }
        //三十天
        if(null!=businessoppo.getStatus() && businessoppo.getStatus()==5){
            buffer.append(" AND  DATE_FORMAT(b.last_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }
        //已成交
        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()==9) {
            buffer.append(" and b.status=" + businessoppo.getStatus()+"");
        }
        //已丢单
        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()==10) {
            buffer.append(" and b.status=" + businessoppo.getStatus()+"");
        }
        //已搁置
        if (  null!=businessoppo.getStatus() && businessoppo.getStatus()==11) {
            buffer.append(" and b.status=" + businessoppo.getStatus()+"");
        }
        //本周新增
        if(null!=businessoppo.getStatus() && businessoppo.getStatus()==6){
            buffer.append(" and YEARWEEK( DATE_FORMAT(b.insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }
        //本月新增
        if(null!=businessoppo.getStatus() && businessoppo.getStatus()==7){
            buffer.append(" AND  DATE_FORMAT(b.insert_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }
        //本季新增
        if(null!=businessoppo.getStatus() && businessoppo.getStatus()==8){
            buffer.append(" AND QUARTER(b.insert_date)=QUARTER(NOW())");
        }
        return buffer.toString();
    }
}
