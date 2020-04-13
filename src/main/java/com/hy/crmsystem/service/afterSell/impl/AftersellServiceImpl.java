package com.hy.crmsystem.service.afterSell.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.afterSell.*;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.documentary.Theme;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.afterSell.AftersellMapper;
import com.hy.crmsystem.service.afterSell.IAftersellService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class AftersellServiceImpl extends ServiceImpl<AftersellMapper, Aftersell> implements IAftersellService {
    @Autowired
    private AftersellMapper aftersellMapper;

    /*查询全部售后信息*/
    @Override
    public IPage<AftersellBo> selectAftersellBo(@Param("ip") Page ip, @Param("aftersellBo") AftersellBo aftersellBo,@Param("types")int types) {
        return aftersellMapper.selectAftersellBo(ip,aftersellBo,types);
    }

    /*查询主题*/
    @Override
    public List<ThemeBo> selectTheme() {
        return aftersellMapper.selectTheme();
    }

    @Override
    public List<User> selectUser() {
        return aftersellMapper.selectUser();
    }

    @Override
    public List<Contract> selectContract() {
        return aftersellMapper.selectContract();
    }

    @Override
    public List<Contract> selectContractByCustomerId(int customerId) {
        return aftersellMapper.selectContractByCustomerId(customerId);
    }

    @Override
    public Contract selectContractNumByCustomerId(int cid) {
        return aftersellMapper.selectContractNumByCustomerId(cid);
    }


    @Override
    public List<Customer> selectCustomer() {
        return aftersellMapper.selectCustomer();
    }

    @Override
    public List<Customer> selectCustomerById(int cid) {
        return aftersellMapper.selectCustomerById(cid);
    }

    @Override
    public void saveTheme(Theme theme) {
        aftersellMapper.insertTheme(theme);
    }

    @Override
    public String selectNumByCid(int cid) {
        return aftersellMapper.selectContractNum(cid);
    }

    @Override
    public String selectMaxId() {
        return aftersellMapper.selectMaxId();
    }

    @Override
    public void saveAfterSell(AfterSellBoTwo afterSellBoTwo) {
         aftersellMapper.savaAfterSell(afterSellBoTwo);
    }

    @Override
    public AfterSellThree selectAfterSell(String theme) {
        return aftersellMapper.selectOneAfterSell(theme);
    }

    @Override
    public String selectCount(String type) {
        QueryWrapper qr=new QueryWrapper();
        if(type.equals("1")){
            qr.eq("status","1");
        }else if(type.equals("2")){
            qr.eq("status","2");
        }else if(type.equals("3")){
            qr.eq("status","3");
        }
        Integer c=aftersellMapper.selectCount(qr);
        return String.valueOf(c);
    }

    @Override
    public Integer selectNewCount(String type) {
        return aftersellMapper.selectNewCount(type);
    }

    @Override
    public Integer selectThemeExist(String theme) {
        QueryWrapper qr=new QueryWrapper();
        qr.eq("theme",theme);
        return aftersellMapper.selectCount(qr);
    }


}
