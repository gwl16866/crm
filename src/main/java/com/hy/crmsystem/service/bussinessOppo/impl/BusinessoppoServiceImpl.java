package com.hy.crmsystem.service.bussinessOppo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.bussinessOppo.ForumLunTan;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.bussinessOppo.BusinessoppoMapper;
import com.hy.crmsystem.service.bussinessOppo.IBusinessoppoService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
public class BusinessoppoServiceImpl extends ServiceImpl<BusinessoppoMapper, Businessoppo> implements IBusinessoppoService {
    @Autowired
    private BusinessoppoMapper businessoppoMapper;
    @Override
    public IPage<Businessoppo> pages(@Param("page")Integer page, @Param("limit")Integer limit, @Param("businessoppo") Businessoppo businessoppo, @Param("session")HttpSession session) {
        Page<Businessoppo> accountsPage = new Page<>(page, limit);
        return businessoppoMapper.queryAllList(accountsPage,businessoppo);
    }

  /*  @Override
    public List<Businessoppo> listQueryAll(@Param("businessoppo") Businessoppo businessoppo) {
        return businessoppoMapper.listQueryAll(businessoppo);
    }*/

    @Override
    public  Businessoppo selectByName(String bid) {
        return businessoppoMapper.selectByName(bid);
    }

    @Override
    public Customer selectBusinessoppo(String bid) {
        return businessoppoMapper.selectBusinessoppo(bid);
    }

    @Override
    public String selectCount(String type) {
        QueryWrapper qr=new QueryWrapper();
        if(type.equals("9")){
            qr.eq("status","1");
        }else if(type.equals("10")){
            qr.eq("status","2");
        }else if(type.equals("11")){
            qr.eq("status","3");
        }
        Integer c=businessoppoMapper.selectCount(qr);
        return String.valueOf(c);
    }

/*    @Override
    public Integer selectNewCount(String type) {
        return businessoppoMapper.selectNewCount(type);
    }*/

    @Override
    public List<String> selectById2(String bid) {
        return businessoppoMapper.selectById2(bid);
    }
    @Override
    public List<ForumLunTan> select1(@Param("id")String[] id) {
        return businessoppoMapper.select1(id);
    }

    @Override
    public List<User> selectUser() {
        return businessoppoMapper.selectUser();
    }

     @Override
    //查询客户
    public Customer selectCustomer(String cname) {
        return businessoppoMapper.selectCustomer(cname);
    }
    @Override
    //查询客户
    public Customer selectMaxCustomer(){
        return businessoppoMapper.selectMaxCustomer();
    }

}
