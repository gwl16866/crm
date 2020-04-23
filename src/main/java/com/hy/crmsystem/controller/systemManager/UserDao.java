package com.hy.crmsystem.controller.systemManager;

import com.hy.crmsystem.entity.systemManager.Role;
import com.hy.crmsystem.entity.systemManager.UserDept;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

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

    public String updateRoleIdByUid(@Param("rids") String[] rids, @Param("uid") Integer uid) {
        StringBuffer sql = new StringBuffer("insert into userrole (uid,rid) values");
        for(int i=0;i<rids.length;i++){
            sql.append("(");
            sql.append(uid+",");
            sql.append(rids[i]+")");
            if(i<rids.length-1){
                sql.append(",");
            }
        }
        return sql.toString();
    }

    public String updateUserHandByUid(@Param("pids") String[] pids, @Param("uid") Integer uid) {
        StringBuffer sql = new StringBuffer("insert into userhand (uid,pid) values");
        for(int i=0;i<pids.length;i++){
            sql.append("(");
            sql.append(uid+",");
            sql.append(pids[i]+")");
            if(i<pids.length-1){
                sql.append(",");
            }
        }
        return sql.toString();
    }

    public String updateRoleHandByRid(@Param("pids") String[] pids, @Param("rid") Integer rid) {
        StringBuffer sql = new StringBuffer("insert into rolepermission (rid,pid) values");
        for(int i=0;i<pids.length;i++){
            sql.append("(");
            sql.append(rid+",");
            sql.append(pids[i]+")");
            if(i<pids.length-1){
                sql.append(",");
            }
        }
        return sql.toString();
    }


    public String selectThirdPerms(@Param("pids") String[] pids) {


        StringBuffer sql = new StringBuffer("SELECT pid FROM permission WHERE parent_id IN (SELECT pid FROM permission WHERE pid IN ");
        sql.append("(");
        for(int i=0;i<pids.length;i++){
            sql.append(pids[i]);
            if(i<pids.length-1){
                sql.append(",");
            }
        }
        sql.append(") AND parent_id IS NOT NULL)");
        return sql.toString();
    }





}
