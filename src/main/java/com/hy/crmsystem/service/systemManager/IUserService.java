package com.hy.crmsystem.service.systemManager;

import com.hy.crmsystem.entity.systemManager.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public interface IUserService extends IService<User> {

    public Integer selectUserCounts();
    public Integer selectBussCounts();
    public Integer selectContractCounts();
    public String selectRetrurnMoney();

    public ArrayList<String> selectMoneyByMonth();
    public ArrayList<String> selectSumUsers();
    public ArrayList<String> selectSumCustomer();
    public ArrayList<String> selectBussinessCounts();
    public ArrayList<String> selectContractCountsByMonth();
    public Integer selectCustomerCounts();
    public List<Dept> queryDept();
    public List<Role> queryAllRole(Role role);
    public List<Integer> queryHaveRole(Integer uid);
    public Role queryRoleById(Integer rid);
    public void updateRole(Role role);
    public void deleteRole(Integer rid);
    public Integer selectCountUserRole(Integer rid);
    public Integer selectCountRolePermission(Integer rid);
    public void addRole(String name);
    public void updateRoleIdByUid(String rid[],Integer uid);
    public void updateUserHandByUid(String pid[],Integer uid);
    public void updateRoleHandByRid(String pid[],Integer rid);
    public void deleteUserRoleByUid(Integer uid);
    public void deleteUserPermissionByUid(Integer uid);
    public void deleteRolePermissionByRid(Integer rid);
    public List<Permission> queryFirstPermission();
    public List<Integer> userHaveHand(Integer uid);
    public List<Integer> roleHaveHand(Integer rid);

    public List<Permission> secondThirdHand(Integer parentId);
    public List<Permission> recursionHands(List<Permission> list);

    public HashSet<String> selectRoleByUid(Integer uid);
    public HashSet<String> selectHandNameByUid(Integer uid);
    public HashSet<String> selectRoleHandNameByUid(Integer uid);
    public String[] selectThirdPerms(String[] pids);



    public List<Dept> select();
    public String selectname(String username);
    public void add(User user);
}
