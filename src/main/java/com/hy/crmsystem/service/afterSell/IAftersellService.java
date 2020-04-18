package com.hy.crmsystem.service.afterSell;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.entity.afterSell.*;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.documentary.Theme;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public interface IAftersellService extends IService<Aftersell> {

    public IPage<AftersellBo> selectAftersellBo(@Param("ip") Page ip, @Param("aftersellBo") AftersellBo aftersellBo,@Param("types") int types);

    public List<ThemeBo> selectTheme();

    public List<User> selectUser();

    public List<Contract> selectContract();

    public List<Contract> selectContractByCustomerId(int customerId);

    public Contract selectContractNumByCustomerId(int cid);


    public List<Customer> selectCustomer();

    public List<Customer> selectCustomerById(int cid);

    public void saveTheme(Theme theme);

    public String selectNumByCid(int cid);

    public String selectMaxId();

    public void saveAfterSell(AfterSellBoTwo afterSellBoTwo);

    public AfterSellThree selectAfterSell(String theme);

    public String selectCount(String type);

    public Integer selectNewCount(String type);

    public Integer selectThemeExist(String theme);

    public void upDateStatus(String type,String aid);

}
