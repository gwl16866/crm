package com.hy.crmsystem.mapper.documentary;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.documentary.Documentary;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlProvider3 {


    public String select_documentary_like(@Param("documentary") Documentary documentary) {

        StringBuffer buffer = new StringBuffer("SELECT d.bid,d.did,d.documentary_time,d.theme,d.documentary_people,d.detail,d.FILE,u.* FROM documentary d,user u where d.uid=u.uid and 1=1 ");
   if (!StringUtils.isNullOrEmpty(documentary.getDocumentaryPeople())) {
            buffer.append(" and documentary_people like '%" + documentary.getDocumentaryPeople() + "%'");
        }
        return buffer.toString();
    }
}
