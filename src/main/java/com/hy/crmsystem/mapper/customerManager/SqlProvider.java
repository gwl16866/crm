package com.hy.crmsystem.mapper.customerManager;

import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import org.apache.ibatis.annotations.Param;

public class SqlProvider {
    public String select_emp_like(@Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe) {

        StringBuffer buffer = new StringBuffer("SELECT c.cname,c.bussiness_count,b.bpredict_money,c.contract_count,c1.contract_money,r.return_money,c.caftersale_count,a.service_score FROM customer c,businessoppo b,aftersell a,contract c1,returnmoneydetails r WHERE c.cid=b.cid AND c.cid=c1.customer_id AND c.cid=a.customer_id AND a.cid=c1.cid AND c1.cid=r.cid");
     /*   if (!StringUtils.isNullOrEmpty(emp.getEmpName())) {
            buffer.append(" and e.empname like '%" + emp.getEmpName() + "%'");
        }
        if (emp.getEmpSex() !=0) {
            buffer.append(" and e.empsex="+emp.getEmpSex()+"");
        }
        if (!StringUtils.isNullOrEmpty(emp.getPhone())) {
            buffer.append(" and e.phone like '%" +emp.getPhone() + "%'");
        }
        if(emp.getDeptNo()!=0){
            buffer.append(" and e.deptno = " +emp.getDeptNo() + "");
        }*/

        return buffer.toString();
    }


}
