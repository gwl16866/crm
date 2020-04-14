package com.hy.crmsystem.service.customerManager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public interface ICustomerService extends IService<Customer> {
    public void inser_Customer(Customer customer);
public List<Kehuiganlizonghe> queryAll();
public List<Kehuiganlizonghe> listQueryAll(@Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe);
    IPage<Kehuiganlizonghe> pages(@Param("page") Integer page, @Param("limit") Integer limit, @Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe, @Param("session") HttpSession session);

    public Customer selectByName(String cid);

    public Moneyinfor selectMoneyinfor(String cid);

}
