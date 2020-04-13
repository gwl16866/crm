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

    //查询本月
    public String sumMonth(@Param("type") String type){
        StringBuffer str = new StringBuffer();
        str.append("SELECT SUM(bpredict_money) FROM businessoppo WHERE 1=1 ");

        if(type.equals("by")){
            str.append(" AND  DATE_FORMAT(insert_date,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }

        if(type.equals("sy")){
            str.append(" AND DATE_FORMAT(insert_date,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
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



}
