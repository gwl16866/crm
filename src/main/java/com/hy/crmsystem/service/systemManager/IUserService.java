package com.hy.crmsystem.service.systemManager;

import com.hy.crmsystem.entity.systemManager.Dept;
import com.hy.crmsystem.entity.systemManager.DeskMonth;
import com.hy.crmsystem.entity.systemManager.DeskPojo;
import com.hy.crmsystem.entity.systemManager.User;
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




}
