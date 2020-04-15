package com.hy.crmsystem.mapper.documentary;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.documentary.Documentary;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider3 {


    public String select_documentary_like(@Param("documentary") Documentary documentary) {

        StringBuffer buffer = new StringBuffer("SELECT documentary_time,theme,documentary_people,detail,FILE FROM documentary where 1=1 ");
   if (!StringUtils.isNullOrEmpty(documentary.getDocumentaryPeople())) {
            buffer.append(" and documentary_people like '%" + documentary.getDocumentaryPeople() + "%'");
        }
        return buffer.toString();
    }
}
