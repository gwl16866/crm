package com.hy.crmsystem.mapper.afterSell;

import com.hy.crmsystem.entity.afterSell.AftersellBo;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider {



    /*
    * 查询售后bo
    * */
    public String selectAfterSellBo(@Param("aftersellBo") AftersellBo aftersellBo,@Param("types") int types){
        StringBuffer buffer = new StringBuffer("SELECT t.theme,ase.service_type,ase.starttime,ase.service_people,ase.service_score  FROM theme t,aftersell ase WHERE t.id=ase.theme");
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
        }else if(null != aftersellBo.getStatus() && 0 != aftersellBo.getStatus()){
            buffer.append(" and ase.status = " +aftersellBo.getStatus() + "");
        }



        return buffer.toString();
    }





}
