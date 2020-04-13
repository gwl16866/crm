package com.hy.crmsystem.controller.contract;

import com.hy.crmsystem.entity.contract.Article;
import org.apache.ibatis.annotations.Param;

public class ForumDao {
    public String selectForum(Article article, @Param("modules")String modules, @Param("keyword")String keyword) {
        StringBuffer sql = new StringBuffer("select u.user_name,a.*,b.bname from article a,businessoppo b,user u where a.uid=u.uid and b.bid=a.of_bid and 1=1 ");
        if (null != modules && modules.equals("1")) {
            sql.append("and title like '%" + keyword + "%'");
        }
        if (null != modules && modules.equals("2")) {
            sql.append(" and u.user_name like '%" + keyword + "%'");
        }
        return sql.toString();
    }
}
