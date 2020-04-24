package com.hy.crmsystem.mapper.systemManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.controller.systemManager.UserDao;
import com.hy.crmsystem.entity.systemManager.*;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user(dept_id,user_name,password,age,sex) values(#{deptId},#{username},#{password},#{age},#{sex})")
    public void Add(User user);

    @Select("select * from user where user_name=#{name}")
    public User selectDengLuRen(Object name);

    @Select("SELECT user_name FROM user where user_name=#{username}")
    public String selectname(String username);

    //查询所有
    @SelectProvider(type = UserDao.class, method = "selectAllUser")
    public List<UserDept> selectAllUser(UserDept user);

    @Select("select * from user where  uid=#{uid}")
    public User selectUserByUid(Integer uid);

    @Update("update user set status=2 where uid=#{uid}")
    public void deleteUser(Integer uid);

    //不修改密码
    @Update("update user set dept_id=#{deptId},age=#{age},sex=#{sex} where uid=#{uid}")
    public void NoupdateUserPassword(User user);

    @Update("update user set password=#{password},dept_id=#{deptId},age=#{age},sex=#{sex} where uid=#{uid}")
    public void updateUser(User user);

    @Select("SELECT SUM(return_money) val,DATE_FORMAT(return_date,'%m') month FROM returnmoneydetails GROUP BY DATE_FORMAT(return_date,'%Y%m')ORDER BY DATE_FORMAT(return_date,'%Y%m')")
    public ArrayList<DeskPojo> seleMoneyByMonth();

    @Select("SELECT COUNT(*) val,DATE_FORMAT(create_date,'%m') month FROM USER GROUP BY DATE_FORMAT(create_date,'%Y%m')ORDER BY DATE_FORMAT(create_date,'%Y%m')")
    public ArrayList<DeskPojo> selectSumUsers();

    @Select("SELECT COUNT(*)val,DATE_FORMAT(insert_date,'%m') month FROM customer GROUP BY DATE_FORMAT(insert_date,'%Y%m') ORDER BY DATE_FORMAT(insert_date,'%Y%m')")
    public ArrayList<DeskPojo> selectSumCustomer();

    @Select("SELECT COUNT(*)val,DATE_FORMAT(insert_date,'%m') month FROM businessoppo GROUP BY DATE_FORMAT(insert_date,'%Y%m') ORDER BY DATE_FORMAT(insert_date,'%Y%m')")
    public ArrayList<DeskPojo> selectBussinessCounts();

    @Select("SELECT COUNT(*)val,DATE_FORMAT(insert_time,'%m') MONTH FROM contract GROUP BY DATE_FORMAT(insert_time,'%Y%m') ORDER BY DATE_FORMAT(insert_time,'%Y%m')")
    public ArrayList<DeskPojo> selectContractCounts();

    @Select("select * from dept")
    public List<Dept> queryDept();

    @SelectProvider(type = UserDao.class, method = "selectAllRole")
    public List<Role> queryAllRole(Role role);

    @Select("SELECT r.rid AS rid,r.role_name AS roleName FROM role r,userrole ur,USER u WHERE r.rid=ur.rid AND u.uid=ur.uid AND u.uid=#{uid}")
    public List<Integer> queryHaveRole(Integer uid);

    @Select("select * from role where rid =#{rid}")
    public Role queryRoleById(Integer rid);

    @Update("update role set role_name=#{roleName} where rid =#{rid}")
    public void updateRoleById(Role role);

    @Update("delete from role where rid =#{rid}")
    public void deleteRoleById(Integer rid);

    @Select("select count(*) from userrole where rid =#{rid}")
    public Integer selectCountUserRole(Integer rid);

    @Select("select count(*) from rolepermission where rid =#{rid}")
    public Integer selectCountRolePermission(Integer rid);

    @Insert("insert into role(role_name) values(#{name})")
    public void addRole(String name);

    @UpdateProvider(type = UserDao.class,method = "updateRoleIdByUid")
    public void updateRoleIdByUid(@Param("rids") String[] rids,@Param("uid") Integer uid);

    @UpdateProvider(type = UserDao.class,method = "updateUserHandByUid")
    public void updateUserHandByUid(@Param("pids") String[] pids,@Param("uid") Integer uid);

    @UpdateProvider(type = UserDao.class,method = "updateRoleHandByRid")
    public void updateRoleHandByRid(@Param("pids") String[] pids,@Param("rid") Integer rid);


    @Delete("delete from userrole where uid=#{uid}")
    public void deleteUserRoleByUid(Integer uid);

    @Delete("delete from userhand where uid=#{uid}")
    public void deleteUserPermissionByUid(Integer uid);

    @Delete("delete from rolepermission where rid=#{rid}")
    public void deleteRolePermissionByRid(Integer rid);


    /**
     * //查询一级权限
     * @return
     */
    @Select("select pid,permission_name as permissionName from permission where parent_id is null")
    public List<Permission> queryFirstPermission();

    /**
     * uid 查询用户权限
     */
    @Select("select pid from userhand where uid =#{uid}")
    public List<Integer> userHaveHand(Integer uid);

    /**
     * rid 查询角色权限
     */
    @Select("select pid from rolepermission where rid =#{rid}")
    public List<Integer> roleHaveHand(Integer rid);

    @Select(" select * from permission where parent_id=#{parentId}")
    public List<Permission> secondThirdHand(Integer parentId);

    @Select("SELECT role_name FROM role r,userrole ur,USER u WHERE u.uid = ur.uid AND r.rid = ur.rid AND u.uid = #{uid}")
    public HashSet<String> selectRoleByUid(Integer uid);

    @Select("SELECT p.url FROM permission p,userhand uh,USER u WHERE p.pid = uh.pid AND uh.uid = u.uid AND u.uid = #{uid}")
    public HashSet<String> selectHandNameByUid(Integer uid);

    // 角色权限
    @Select("SELECT h.url FROM permission h,role r,rolepermission rh,USER u,userrole ur WHERE h.pid=rh.pid AND r.rid=rh.rid AND u.uid = ur.uid AND ur.rid=r.rid AND u.uid = #{uid}")
    public HashSet<String> selectRoleHandNameByName(Integer uid);

    @SelectProvider(type = UserDao.class, method = "selectThirdPerms")
    public String[] selectThirdPerms(@Param("pids") String[] pids);

}
