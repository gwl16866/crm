package com.hy.crmsystem.mapper.afterSell;

import com.hy.crmsystem.entity.afterSell.AftersellBo;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider {



    /*
    * 查询售后bo
    * */
    public String selectAfterSellBo(@Param("aftersellBo") AftersellBo aftersellBo,@Param("types") int types){
        StringBuffer buffer = new StringBuffer("SELECT ase.aid,t.theme,ase.service_type,ase.starttime,ase.service_people,ase.service_score  FROM theme t,aftersell ase WHERE t.id=ase.theme");
        if (types == 1 && !StringUtils.isNullOrEmpty(aftersellBo.getTheme())) {
            buffer.append(" and t.id = " + aftersellBo.getTheme() + "");
        }else if (types == 2 && !StringUtils.isNullOrEmpty(aftersellBo.getServiceType())) {
            buffer.append(" and ase.service_type = '" +aftersellBo.getServiceType() + "'");
        }else if (types == 3 && !StringUtils.isNullOrEmpty(aftersellBo.getStarttime())) {
            buffer.append(" and ase.starttime = '" +aftersellBo.getStarttime() + "'");
        }else if (types == 4 && !StringUtils.isNullOrEmpty(aftersellBo.getServicePeople())) {
            buffer.append(" and ase.service_people like '%" +aftersellBo.getServicePeople() + "%'");
        }else if (types == 5 && !StringUtils.isNullOrEmpty(aftersellBo.getServiceScore())) {
            buffer.append(" and ase.service_score = '" +aftersellBo.getServiceScore() + "'");
        }else if(null != aftersellBo.getStatus() && aftersellBo.getStatus() <= 3){
            System.out.println("========="+aftersellBo.getStatus());
            buffer.append(" and ase.status = " +aftersellBo.getStatus() + "");
        }else if(null != aftersellBo.getStatus() && aftersellBo.getStatus() == 11){
            //11代表本周
            buffer.append(" and YEARWEEK( DATE_FORMAT(starttime,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }else if(null != aftersellBo.getStatus() && aftersellBo.getStatus() == 12){
            //12代表上周
            buffer.append(" and YEARWEEK(DATE_FORMAT(starttime,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");

        }else if(null != aftersellBo.getStatus() && aftersellBo.getStatus() == 13){
            //13代表本月
            buffer.append(" AND  DATE_FORMAT(starttime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }else if(null != aftersellBo.getStatus() && aftersellBo.getStatus() == 14){
            //14代表上月
            buffer.append(" AND DATE_FORMAT(starttime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }else if(null != aftersellBo.getStatus() && aftersellBo.getStatus() == 15){
            //15本季度
            buffer.append(" AND QUARTER(starttime)=QUARTER(NOW())");
        }else if(null != aftersellBo.getStatus() && aftersellBo.getStatus() == 16){
            //16代表上季度
            buffer.append(" AND QUARTER(starttime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }

        return buffer.toString();
    }

    /*
     * 查询新增条数
     * */
    public String selectNewCount(@Param("type") String type){
        StringBuffer buffer = new StringBuffer("select count(*) from aftersell where 1=1");
        if (type.equals("12")) {
            //12代表上周
            buffer.append(" AND YEARWEEK(DATE_FORMAT(starttime,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1");
        }else if(type.equals("11")){
            //11代表本周
            buffer.append(" and YEARWEEK( DATE_FORMAT(starttime,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)");
        }else if(type.equals("13")){
            //13代表本月
            buffer.append(" AND  DATE_FORMAT(starttime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }else if(type.equals("14")){
            //14代表上月
            buffer.append(" AND DATE_FORMAT(starttime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }else if(type.equals("15")){
            //15代表本季度
            buffer.append(" AND QUARTER(starttime)=QUARTER(NOW())");
        }else if(type.equals("16")){
            //16代表上季度
            buffer.append(" AND QUARTER(starttime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");

        }

        return buffer.toString();
    }



}
