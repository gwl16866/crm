package com.hy.crmsystem.service.systemManager;

import com.hy.crmsystem.entity.systemManager.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
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
    public List<Role> queryHaveRole(Integer uid);
    public Role queryRoleById(Integer rid);
    public void updateRole(Role role);
    public void deleteRole(Integer rid);
    public Integer selectCountUserRole(Integer rid);
    public Integer selectCountRolePermission(Integer rid);




}
