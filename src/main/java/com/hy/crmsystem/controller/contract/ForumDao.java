package com.hy.crmsystem.controller.contract;

import com.hy.crmsystem.entity.contract.Article;

public class ForumDao {
    public String selectForum(Article article) {
        StringBuffer sql = new StringBuffer("select u.user_name,a.*,b.bname from article a,businessoppo b,user u where a.uid=u.uid and b.bid=a.of_bid and 1=1 ");
        if (article.getTitle() != null && article.getTitle() != "") {
            sql.append("and title like '%" + article.getTitle() + "%'");
        }
        if (article.getUid() != null) {
            sql.append(" and uid like '%" + article.getUid() + "%'");
        }
        return sql.toString();
    }
}
