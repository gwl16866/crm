package com.hy.crmsystem.mapper.customerManager;

import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider1 {
    public String select_emp_like(@Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe) {

        StringBuffer buffer = new StringBuffer("SELECT cname,cb.cob as bussinessCount,cb.bpr as bpredictMoney,cc.cou as contractCount,cc.mon as contractMoney,cr.su as returnMoney, ca.un as caftersaleCount,ca.ag as serviceScore FROM customer c LEFT JOIN (SELECT  c.cid,COUNT(b.cid) cob,b.bpredict_money bpr FROM customer c LEFT JOIN businessoppo b ON c.cid=b.cid GROUP BY b.cid) cb ON c.cid=cb.cid LEFT JOIN (SELECT c.cid,COUNT(c1.customer_id) cou,c1.contract_money mon  FROM customer c LEFT JOIN contract c1 ON c.cid=c1.customer_id GROUP BY c1.customer_id ) cc ON c.cid=cc.cid LEFT JOIN (SELECT c1.cid,SUM(r.return_money) su FROM contract c1 LEFT JOIN returnmoneydetails r ON c1.cid=r.cid GROUP BY r.cid) cr ON c.cid=cr.cid LEFT JOIN (SELECT  c.cid,COUNT(a.customer_id) un,AVG(a.service_score) ag FROM customer c LEFT JOIN aftersell a ON c.cid=a.customer_id GROUP BY a.customer_id) ca ON c.cid=ca.cid ");
       if (!StringUtils.isNullOrEmpty(kehuiganlizonghe.getCname())) {
            buffer.append(" and c.cname like '%" + kehuiganlizonghe.getCname() + "%'");
        }
        if (kehuiganlizonghe.getContractCount() !=0) {
            buffer.append(" and c.contract_count=" + kehuiganlizonghe.getContractCount() +"");
        }
        /*if (!StringUtils.isNullOrEmpty(emp.getPhone())) {
            buffer.append(" and e.phone like '%" +emp.getPhone() + "%'");
        }
        if(emp.getDeptNo()!=0){
            buffer.append(" and e.deptno = " +emp.getDeptNo() + "");
        }*/

        return buffer.toString();
    }


}
