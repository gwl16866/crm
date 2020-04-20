package com.hy.crmsystem.controller.systemManager;

import com.hy.crmsystem.entity.systemManager.Role;
import com.hy.crmsystem.entity.systemManager.UserDept;
import com.mysql.jdbc.StringUtils;

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


    public String selectAllRole(Role role) {
        StringBuffer sql = new StringBuffer("select * from role where 1=1 ");
        if ( !StringUtils.isNullOrEmpty(role.getRoleName())) {
            sql.append(" and role_name like '%" + role.getRoleName() + "%'");
        }
        return sql.toString();
    }



}
