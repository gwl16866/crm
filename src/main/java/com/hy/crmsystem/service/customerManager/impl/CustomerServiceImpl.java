package com.hy.crmsystem.service.customerManager.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import com.hy.crmsystem.mapper.customerManager.CustomerMapper;
import com.hy.crmsystem.mapper.customerManager.MoneyinforMapper;
import com.hy.crmsystem.service.customerManager.ICustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Service
@Transactional
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
    @Autowired
     private CustomerMapper customerMapper;
private MoneyinforMapper moneyinforMapper;
    @Override
    public void inser_Customer(Customer customer) {
        customerMapper.insert_Customer(customer);
    }

    @Override
    public List<Kehuiganlizonghe> queryAll() {
        List<Kehuiganlizonghe> list=customerMapper.queryAll();
        return list;
    }

    @Override
    public List<Kehuiganlizonghe> listQueryAll(@Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe) {
        return customerMapper.listQueryAll(kehuiganlizonghe);
    }

    @Override
    public IPage<Kehuiganlizonghe> pages(@Param("page") Integer page, @Param("limit") Integer limit, @Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe, @Param("session") HttpSession session) {

//                    分页
       /* if (dqy == null) {
            dqy = 1;
        }*/
            Page<Kehuiganlizonghe> accountsPage = new Page<>(page, limit);
           /* session.setAttribute("arraylist",customerMapper.queryAlls(kehuiganlizonghe));*/
            return customerMapper.queryAllList(accountsPage,kehuiganlizonghe);

    }

    @Override
    public Customer selectByName(String cid) {
    return customerMapper.selectByName(cid);
    }

    @Override
    public Moneyinfor selectMoneyinfor(String cid) {
        return customerMapper.selectMoneyinfor(cid);
    }

   /* @Override
    public void update(Customer customer) {
        customerMapper.updateById(customer);
    }

    @Override
    public void update1(Moneyinfor moneyinfor) {
        moneyinforMapper.update(moneyinfor,);
    }*/

   //查询客户
    public Customer selectMaxCustomer(){
       return customerMapper.selectMaxCustomer();
    }

}
