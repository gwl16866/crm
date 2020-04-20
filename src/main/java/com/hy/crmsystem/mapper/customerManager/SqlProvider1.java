package com.hy.crmsystem.mapper.customerManager;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider1 {

    public String select_emp_like(@Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe) {
        StringBuffer buffer = new StringBuffer("SELECT c.cid,c.cname,cb.cob as bussinessCount,cb.bpr as bpredictMoney,cc.cou as contractCount,cc.mon as contractMoney,cr.su as returnMoney, ca.un as caftersaleCount,ca.ag as serviceScore FROM customer c LEFT JOIN (SELECT  c.cid,COUNT(b.cid) cob,b.bpredict_money bpr FROM customer c LEFT JOIN businessoppo b ON c.cid=b.cid GROUP BY b.cid) cb ON c.cid=cb.cid LEFT JOIN (SELECT c.cid,COUNT(c1.customer_id) cou,c1.contract_money mon  FROM customer c LEFT JOIN contract c1 ON c.cid=c1.customer_id GROUP BY c1.customer_id ) cc ON c.cid=cc.cid LEFT JOIN (SELECT c1.cid,SUM(r.return_money) su FROM contract c1 LEFT JOIN returnmoneydetails r ON c1.cid=r.cid GROUP BY r.cid) cr ON c.cid=cr.cid LEFT JOIN (SELECT  c.cid,COUNT(a.customer_id) un,AVG(a.service_score) ag FROM customer c LEFT JOIN aftersell a ON c.cid=a.customer_id GROUP BY a.customer_id) ca ON c.cid=ca.cid  where 1=1 ");
       if (!StringUtils.isNullOrEmpty(kehuiganlizonghe.getCname())) {
            buffer.append(" and cname like '%" + kehuiganlizonghe.getCname() + "%'");
        }
        if (null != kehuiganlizonghe.getCclass()  &&  kehuiganlizonghe.getCclass()<=3) {
            buffer.append(" and cclass=" + kehuiganlizonghe.getCclass()+"");
        }

        return buffer.toString();
    }

   /* public String select_businessoppo_like(@Param("businessoppo") Businessoppo businessoppo) {

        StringBuffer buffer = new StringBuffer("select bid,bname,status,bpredict_money,bprincipal,last_time from businessoppo where 1=1 ");
        if (!StringUtils.isNullOrEmpty(businessoppo.getBname())) {
            buffer.append(" and bname like '%" + businessoppo.getBname() + "%'");
        }
        if (!businessoppo.getStatus().equals("null")&&businessoppo.getStatus()!=null) {
            buffer.append(" and status=" + businessoppo.getStatus()+"");
        }
        if (!StringUtils.isNullOrEmpty(businessoppo.getBprincipal())) {
            buffer.append(" and bprincipal like '%" + businessoppo.getBprincipal() + "%'");
        }
        if (!StringUtils.isNullOrEmpty(businessoppo.getBpredictMoney())) {
            buffer.append(" and bpredict_money like '%" + businessoppo.getBpredictMoney() + "%'");
        }

        return buffer.toString();
    }*/
}
