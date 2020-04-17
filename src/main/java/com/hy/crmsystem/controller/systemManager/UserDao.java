package com.hy.crmsystem.controller.systemManager;

import com.hy.crmsystem.entity.systemManager.UserDept;

public class UserDao {
    public String selectAllUser(UserDept user) {
        StringBuffer sql = new StringBuffer("select u.*,d.* from user u,dept d where u.dept_id=d.dept_id and u.status=1 and 1=1 ");
        if (user.getUsername() != null && user.getUsername() != " ") {
            sql.append(" and u.user_name like '%" + user.getUsername() + "%'");
        }
        if (user.getDeptId() != null && user.getDeptId() != 0) {
            sql.append(" and u.dept_id =" + user.getDeptId());
        }
        return sql.toString();
    }
}
