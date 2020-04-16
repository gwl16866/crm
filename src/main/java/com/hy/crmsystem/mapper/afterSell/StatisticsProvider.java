package com.hy.crmsystem.mapper.afterSell;

import org.apache.ibatis.annotations.Param;

public class StatisticsProvider {



    //查询本周
    public String sumWeek(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(bpredict_money) FROM businessoppo WHERE 1=1 ");

        if(type.equals("bz")){
            str.append(" and YEARWEEK(DATE_FORMAT(insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }
        if(type.equals("sz")){
            str.append(" and YEARWEEK(DATE_FORMAT(insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
        }
        return str.toString();
    }


    //查询本周以及所有客户
    public String sumWeekAndCustomer(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT c.cname,SUM(b.bpredict_money) AS money FROM businessoppo b,customer c WHERE c.cid =b.cid  AND c.cname =#{name} ");

        if(type.equals("bz")){
            str.append(" and YEARWEEK(DATE_FORMAT(b.insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }

        if(type.equals("sz")){
            str.append(" and YEARWEEK(DATE_FORMAT(b.insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
        }
        return str.toString();
    }

    //查询本周以及所有客户数量
    public String sumWeekAndCustomerCounts(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT count(b.bpredict_money) FROM businessoppo b,customer c WHERE c.cid =b.cid  AND c.cname =#{name} ");

        if(type.equals("bz")){
            str.append(" and YEARWEEK(DATE_FORMAT(b.insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }

        if(type.equals("sz")){
            str.append(" and YEARWEEK(DATE_FORMAT(b.insert_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
        }
        return str.toString();
    }




    //查询本月
    public String sumMonth(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(bpredict_money) FROM businessoppo WHERE 1=1 ");

        if(type.equals("by")){
            str.append(" AND  DATE_FORMAT(b.insert_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }

        if(type.equals("sy")){
            str.append(" AND DATE_FORMAT(b.insert_date,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }
        return str.toString();
    }

    //查询本月及客户
    public String sumMonthAndCustomer(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT c.cname,SUM(b.bpredict_money) AS money FROM businessoppo b,customer c WHERE c.cid =b.cid  AND c.cname =#{name} ");

        if(type.equals("by")){
            str.append(" AND  DATE_FORMAT(b.insert_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }

        if(type.equals("sy")){
            str.append(" AND DATE_FORMAT(b.insert_date,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }
        return str.toString();
    }
    //查询本月及客户数量
    public String sumMonthAndCustomerCounts(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT count(b.bpredict_money) AS money FROM businessoppo b,customer c WHERE c.cid =b.cid  AND c.cname =#{name} ");

        if(type.equals("by")){
            str.append(" AND  DATE_FORMAT(b.insert_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }

        if(type.equals("sy")){
            str.append(" AND DATE_FORMAT(b.insert_date,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }
        return str.toString();
    }




    //查询本季度
    public String sumQuarter(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(bpredict_money) FROM businessoppo WHERE 1=1 ");

        if(type.equals("bj")){
            str.append(" AND QUARTER(insert_date)=QUARTER(NOW())");
        }

        if(type.equals("sj")){
            str.append(" AND QUARTER(insert_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }
        return str.toString();
    }

    //查询本季度及客户
    public String sumQuarterAndCustomer(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT c.cname,SUM(b.bpredict_money) AS money FROM businessoppo b,customer c WHERE c.cid =b.cid  AND c.cname =#{name} ");

        if(type.equals("bj")){
            str.append(" AND QUARTER(b.insert_date)=QUARTER(NOW())");
        }

        if(type.equals("sj")){
            str.append(" AND QUARTER(b.insert_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }
        return str.toString();
    }

    //查询本季度及客户数量
    public String sumQuarterAndCustomerCounts(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT count(b.bpredict_money) AS money FROM businessoppo b,customer c WHERE c.cid =b.cid  AND c.cname =#{name} ");

        if(type.equals("bj")){
            str.append(" AND QUARTER(b.insert_date)=QUARTER(NOW())");
        }

        if(type.equals("sj")){
            str.append(" AND QUARTER(b.insert_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }
        return str.toString();
    }





    //查询本年
    public String sumYear(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(bpredict_money) FROM businessoppo WHERE 1=1 ");

        if(type.equals("bn")){
            str.append(" and YEAR(insert_date)=YEAR(NOW())");
        }

        if(type.equals("sn")){
            str.append(" and YEAR(insert_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
        }
        return str.toString();
    }

    //查询本年及客户
    public String sumYearAndCustomer(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT c.cname,SUM(b.bpredict_money) as money FROM businessoppo b,customer c WHERE 1=1 AND c.cid =b.cid and c.cname=#{name} ");

        if(type.equals("bn")){
            str.append(" and YEAR(b.insert_date)=YEAR(NOW())");
        }

        if(type.equals("sn")){
            str.append(" and YEAR(b.insert_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
        }
        return str.toString();
    }
    //查询本年及客户数量
    public String sumYearAndCustomerCounts(@Param("type") String type,@Param("name")String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT count(b.bpredict_money) as money FROM businessoppo b,customer c WHERE 1=1 AND c.cid =b.cid and c.cname=#{name} ");

        if(type.equals("bn")){
            str.append(" and YEAR(b.insert_date)=YEAR(NOW())");
        }

        if(type.equals("sn")){
            str.append(" and YEAR(b.insert_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
        }
        return str.toString();
    }

















    //跟单数 各种查
    public String sumDocumentary(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(bpredict_money) FROM businessoppo WHERE bid IN(SELECT bid FROM documentary WHERE ");

        if(type.equals("gdbz")){
            str.append(" YEARWEEK(DATE_FORMAT(documentary_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
            str.append(")");
        }

        if(type.equals("gdsz")){
            str.append(" YEARWEEK(DATE_FORMAT(documentary_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
            str.append(")");
        }

        if(type.equals("gdby")){
            str.append("  DATE_FORMAT(documentary_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("gdsy")){
            str.append(" DATE_FORMAT(documentary_time,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("gdbj")){
            str.append(" QUARTER(documentary_time)=QUARTER(NOW())");
            str.append(")");
        }

        if(type.equals("gdsj")){
            str.append(" QUARTER(documentary_time)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
            str.append(")");
        }

        if(type.equals("gdbn")){
            str.append(" YEAR(documentary_time)=YEAR(NOW())");
            str.append(")");
        }

        if(type.equals("gdsn")){
            str.append(" YEAR(documentary_time)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
            str.append(")");
        }
        return str.toString();
    }

    //跟单数 各种查以及客户
    public String sumDocumentaryAndCustomer(@Param("type") String type,@Param("name") String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT c.cname,SUM(b.bpredict_money) as money FROM businessoppo b,customer c WHERE c.cid=b.cid AND c.cname=#{name} AND b.bid IN(SELECT bid FROM documentary WHERE ");

        if(type.equals("gdbz")){
            str.append(" YEARWEEK(DATE_FORMAT(documentary_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
            str.append(")");
        }

        if(type.equals("gdsz")){
            str.append(" YEARWEEK(DATE_FORMAT(documentary_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
            str.append(")");
        }

        if(type.equals("gdby")){
            str.append("  DATE_FORMAT(documentary_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("gdsy")){
            str.append(" DATE_FORMAT(documentary_time,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("gdbj")){
            str.append(" QUARTER(documentary_time)=QUARTER(NOW())");
            str.append(")");
        }

        if(type.equals("gdsj")){
            str.append(" QUARTER(documentary_time)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
            str.append(")");
        }

        if(type.equals("gdbn")){
            str.append(" YEAR(documentary_time)=YEAR(NOW())");
            str.append(")");
        }

        if(type.equals("gdsn")){
            str.append(" YEAR(documentary_time)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
            str.append(")");
        }
        return str.toString();
    }

    //跟单数 各种查以及客户 数量
    public String sumDocumentaryAndCustomerCounts(@Param("type") String type,@Param("name") String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT count(b.bpredict_money) FROM businessoppo b,customer c WHERE c.cid=b.cid AND c.cname=#{name} AND b.bid IN(SELECT bid FROM documentary WHERE ");

        if(type.equals("gdbz")){
            str.append(" YEARWEEK(DATE_FORMAT(documentary_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
            str.append(")");
        }

        if(type.equals("gdsz")){
            str.append(" YEARWEEK(DATE_FORMAT(documentary_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
            str.append(")");
        }

        if(type.equals("gdby")){
            str.append("  DATE_FORMAT(documentary_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("gdsy")){
            str.append(" DATE_FORMAT(documentary_time,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("gdbj")){
            str.append(" QUARTER(documentary_time)=QUARTER(NOW())");
            str.append(")");
        }

        if(type.equals("gdsj")){
            str.append(" QUARTER(documentary_time)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
            str.append(")");
        }

        if(type.equals("gdbn")){
            str.append(" YEAR(documentary_time)=YEAR(NOW())");
            str.append(")");
        }

        if(type.equals("gdsn")){
            str.append(" YEAR(documentary_time)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
            str.append(")");
        }
        return str.toString();
    }









    //合同数 各种查
    public String sumContract(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(contract_money) FROM contract WHERE");

        if(type.equals("htbz")){
            str.append(" YEARWEEK(DATE_FORMAT(star_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }

        if(type.equals("htsz")){
            str.append(" YEARWEEK(DATE_FORMAT(star_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
        }

        if(type.equals("htby")){
            str.append("  DATE_FORMAT(star_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }

        if(type.equals("htsy")){
            str.append(" DATE_FORMAT(star_time,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }

        if(type.equals("htbj")){
            str.append(" QUARTER(star_time)=QUARTER(NOW())");
        }

        if(type.equals("htsj")){
            str.append(" QUARTER(star_time)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }

        if(type.equals("htbn")){
            str.append(" YEAR(star_time)=YEAR(NOW())");
        }

        if(type.equals("htsn")){
            str.append(" YEAR(star_time)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
        }
        return str.toString();
    }

    //合同数 各种查客户
    public String sumContractAndCustomer(@Param("type") String type,@Param("name") String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT cu.cname,SUM(contract_money) as money FROM contract c,customer cu WHERE c.customer_id =cu.cid AND cu.cname=#{name} AND");

        if(type.equals("htbz")){
            str.append(" YEARWEEK(DATE_FORMAT(star_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }

        if(type.equals("htsz")){
            str.append(" YEARWEEK(DATE_FORMAT(star_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
        }

        if(type.equals("htby")){
            str.append("  DATE_FORMAT(star_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }

        if(type.equals("htsy")){
            str.append(" DATE_FORMAT(star_time,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }

        if(type.equals("htbj")){
            str.append(" QUARTER(star_time)=QUARTER(NOW())");
        }

        if(type.equals("htsj")){
            str.append(" QUARTER(star_time)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }

        if(type.equals("htbn")){
            str.append(" YEAR(star_time)=YEAR(NOW())");
        }

        if(type.equals("htsn")){
            str.append(" YEAR(star_time)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
        }
        return str.toString();
    }
    //合同数 各种查客户数量
    public String sumContractAndCustomerCounts(@Param("type") String type,@Param("name") String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT count(contract_money) FROM contract c,customer cu WHERE c.customer_id =cu.cid AND cu.cname=#{name} AND");

        if(type.equals("htbz")){
            str.append(" YEARWEEK(DATE_FORMAT(star_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }

        if(type.equals("htsz")){
            str.append(" YEARWEEK(DATE_FORMAT(star_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
        }

        if(type.equals("htby")){
            str.append("  DATE_FORMAT(star_time,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }

        if(type.equals("htsy")){
            str.append(" DATE_FORMAT(star_time,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }

        if(type.equals("htbj")){
            str.append(" QUARTER(star_time)=QUARTER(NOW())");
        }

        if(type.equals("htsj")){
            str.append(" QUARTER(star_time)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }

        if(type.equals("htbn")){
            str.append(" YEAR(star_time)=YEAR(NOW())");
        }

        if(type.equals("htsn")){
            str.append(" YEAR(star_time)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
        }
        return str.toString();
    }










    //成交数 各种查
    public String sumOkMoney(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(contract_money) FROM contract WHERE cid IN(SELECT cid FROM returnmoneydetails WHERE remain_money <1 and ");

        if(type.equals("cjbz")){
            str.append(" YEARWEEK(DATE_FORMAT(return_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
            str.append(")");
        }

        if(type.equals("cjsz")){
            str.append(" YEARWEEK(DATE_FORMAT(return_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
            str.append(")");
        }

        if(type.equals("cjby")){
            str.append("  DATE_FORMAT(return_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("cjsy")){
            str.append(" DATE_FORMAT(return_date,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("cjbj")){
            str.append(" QUARTER(return_date)=QUARTER(NOW())");
            str.append(")");
        }

        if(type.equals("cjsj")){
            str.append(" QUARTER(return_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
            str.append(")");
        }

        if(type.equals("cjbn")){
            str.append(" YEAR(return_date)=YEAR(NOW())");
            str.append(")");
        }

        if(type.equals("cjsn")){
            str.append(" YEAR(return_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
            str.append(")");
        }
        return str.toString();
    }

    //成交数 各种查 客户
    public String sumOkMoneyAndCustomer(@Param("type") String type,@Param("name") String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT cu.cname,SUM(contract_money) as money FROM contract c,customer cu WHERE c.remain_money <1 AND c.customer_id=cu.cid AND cu.cname=#{name} AND c.cid IN (SELECT cid FROM returnmoneydetails WHERE ");

        if(type.equals("cjbz")){
            str.append(" YEARWEEK(DATE_FORMAT(return_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
            str.append(")");
        }

        if(type.equals("cjsz")){
            str.append(" YEARWEEK(DATE_FORMAT(return_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
            str.append(")");
        }

        if(type.equals("cjby")){
            str.append("  DATE_FORMAT(return_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("cjsy")){
            str.append(" DATE_FORMAT(return_date,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("cjbj")){
            str.append(" QUARTER(return_date)=QUARTER(NOW())");
            str.append(")");
        }

        if(type.equals("cjsj")){
            str.append(" QUARTER(return_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
            str.append(")");
        }

        if(type.equals("cjbn")){
            str.append(" YEAR(return_date)=YEAR(NOW())");
            str.append(")");
        }

        if(type.equals("cjsn")){
            str.append(" YEAR(return_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
            str.append(")");
        }
        return str.toString();
    }

    //成交数 各种查 客户数量
    public String sumOkMoneyAndCustomerCounts(@Param("type") String type,@Param("name") String name){
        StringBuffer str = new StringBuffer();
        str.append("SELECT count(c.contract_money) FROM contract c,customer cu WHERE c.remain_money <1 AND c.customer_id=cu.cid AND cu.cname=#{name} AND c.cid IN (SELECT cid FROM returnmoneydetails WHERE ");

        if(type.equals("cjbz")){
            str.append(" YEARWEEK(DATE_FORMAT(return_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
            str.append(")");
        }

        if(type.equals("cjsz")){
            str.append(" YEARWEEK(DATE_FORMAT(return_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
            str.append(")");
        }

        if(type.equals("cjby")){
            str.append("  DATE_FORMAT(return_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("cjsy")){
            str.append(" DATE_FORMAT(return_date,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
            str.append(")");
        }

        if(type.equals("cjbj")){
            str.append(" QUARTER(return_date)=QUARTER(NOW())");
            str.append(")");
        }

        if(type.equals("cjsj")){
            str.append(" QUARTER(return_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
            str.append(")");
        }

        if(type.equals("cjbn")){
            str.append(" YEAR(return_date)=YEAR(NOW())");
            str.append(")");
        }

        if(type.equals("cjsn")){
            str.append(" YEAR(return_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))");
            str.append(")");
        }
        return str.toString();
    }




}
