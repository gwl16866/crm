package com.hy.crmsystem.controller.contract;

import com.hy.crmsystem.entity.systemManager.Forum;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.systemManager.LoginMapper;
import com.hy.crmsystem.service.contract.impl.ForumServiceImpl;
import com.hy.crmsystem.service.systemManager.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ForumDao {

    @Autowired
    ForumServiceImpl forumService;
    @Autowired
    LoginMapper loginMapper;

    @Autowired
    IUserService userService;

    public String selectForum(Forum forum, Integer condition , List<User> userList) {
        StringBuffer sql = new StringBuffer("select u.user_name,a.*,b.bname from article a,businessoppo b,user u where a.uid=u.uid and b.bid=a.of_bid and 1=1 ");
        if (condition != null && condition == 1 && forum.getKeyword() !=null && forum.getKeyword() != "") {
            sql.append("and a.title like '%" + forum.getKeyword() + "%'");
        }
        if (condition != null && condition == 2 && forum.getKeyword() !=null && forum.getKeyword() != "") {
            Integer[] arr=new Integer[userList.size()];
              int i=0;
                for (User user:userList){
                    arr[i]=user.getUid();
                    i++;
                }
                StringBuffer str=new StringBuffer("(");
                for(int j:arr){
                    str.append(j);
                    str.append(",");
                }
                str.deleteCharAt( str.lastIndexOf(","));
                str.append(")");

            sql.append(" and a.uid in " +str );
        }
        return sql.toString();
    }
}
