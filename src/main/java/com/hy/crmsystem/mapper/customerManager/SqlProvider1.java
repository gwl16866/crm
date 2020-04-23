package com.hy.crmsystem.mapper.customerManager;

import com.hy.crmsystem.entity.afterSell.AftersellBo;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.contract.Contract;
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
   public String select1(@Param("bid") String[] bid,@Param("businessoppo") Businessoppo businessoppo) {
       StringBuffer buffer = new StringBuffer("select bid,bname,status,bpredict_money,bprincipal,last_time from businessoppo");
       buffer.append(" where bid in");
       buffer.append("(");
       for(int i=0;i<bid.length;i++){
           buffer.append(bid[i]);
           if(i<bid.length-1){
               buffer.append(",");
           }
       }
       buffer.append(")");
       if (businessoppo.getBprincipal() != null) {
           buffer.append(" and bprincipal = " + businessoppo.getBprincipal()+" ");
       }
//商机名称
       if (!StringUtils.isNullOrEmpty(businessoppo.getBname())) {
           buffer.append(" and bname like '%" + businessoppo.getBname() + "%'");
       }
       if (  null!=businessoppo.getStatus() && businessoppo.getStatus()<=3) {
           buffer.append(" and status=" + businessoppo.getStatus()+"");
       }
       if (!StringUtils.isNullOrEmpty(businessoppo.getBpredictMoney())) {
           buffer.append(" and bpredict_money like '%" + businessoppo.getBpredictMoney() + "%'");
       }
       return buffer.toString();
   }
   public String select2(@Param("cid") String[] cid,@Param("contract") Contract contract) {
       StringBuffer buffer = new StringBuffer("SELECT c.cid,c.contract_name,c.contract_num,c.contract_money,r.return_money,SUM(o.ticket_money) openMoney,c.signed_time FROM contract c,returnmoneydetails r,openpaper o WHERE c.cid=r.cid AND c.cid=o.contract_file ");
       buffer.append(" and c.cid in ");
       buffer.append("(");
       for(int i=0;i<cid.length;i++){
           buffer.append(cid[i]);
           if(i<cid.length-1){
               buffer.append(",");
           }
       }
       buffer.append(")");
       //我的合同
       if (contract.getUid() != null) {
           buffer.append(" and c.uid = '"+contract.getUid()+"' ");
       }
       //状态
       if (contract.getContractStatus() != null && contract.getContractStatus()<5) {
           buffer.append(" and c.contract_status = '"+contract.getContractStatus()+"' ");
       }
       return buffer.toString();
   }
   public String select3(@Param("aid") String[] aid,@Param("aftersellBo") AftersellBo aftersellBo) {
       StringBuffer buffer = new StringBuffer("SELECT t.id,t.theme,a.service_type,a.starttime,a.service_people,a.service_score,a.ststus FROM aftersell a ,theme t WHERE a.theme_id=t.id  ");
       buffer.append(" and a.aid in ");
       buffer.append("(");
       for (int i = 0; i < aid.length; i++) {
           buffer.append(aid[i]);
           if (i < aid.length - 1) {
               buffer.append(",");
           }
       }
       buffer.append(")");
       if (!StringUtils.isNullOrEmpty(aftersellBo.getTheme())) {
           buffer.append(" and t.id = " + aftersellBo.getTheme() + "");
       } else if (!StringUtils.isNullOrEmpty(aftersellBo.getServiceType())) {
           buffer.append(" and ase.service_type = '" + aftersellBo.getServiceType() + "'");
       } else if (!StringUtils.isNullOrEmpty(aftersellBo.getStarttime())) {
           buffer.append(" and ase.starttime = '" + aftersellBo.getStarttime() + "'");
       } else if (!StringUtils.isNullOrEmpty(aftersellBo.getServicePeople())) {
           buffer.append(" and ase.service_people like '%" + aftersellBo.getServicePeople() + "%'");
       } else if (!StringUtils.isNullOrEmpty(aftersellBo.getServiceScore())) {
           buffer.append(" and ase.service_score = '" + aftersellBo.getServiceScore() + "'");
       } else if (null != aftersellBo.getStatus() && aftersellBo.getStatus() <= 3) {
           System.out.println("=========" + aftersellBo.getStatus());
           buffer.append(" and ase.status = " + aftersellBo.getStatus() + "");

       }
       return buffer.toString();
   }


}
