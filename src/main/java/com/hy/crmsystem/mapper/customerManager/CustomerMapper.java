package com.hy.crmsystem.mapper.customerManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("SELECT c.cname,c.bussiness_count,b.bpredict_money,c.contract_count,c1.contract_money,r.return_money,c.caftersale_count,a.service_score FROM customer c,businessoppo b,aftersell a,contract c1,returnmoneydetails r WHERE c.cid=b.cid AND c.cid=c1.customer_id AND c.cid=a.customer_id AND a.cid=c1.cid AND c1.cid=r.cid;")
    public List<Kehuiganlizonghe> queryAll();

    //    联合查询
  /*  @SelectProvider(type = SqlProvider.class,method = "select_emp_like")
    List<Kehuiganlizonghe> queryAlls( @Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe);*/

    //    分页联合查询

    @SelectProvider(type = SqlProvider.class,method = "select_emp_like")
    IPage<Kehuiganlizonghe> queryAllList(@Param("page") Page<Kehuiganlizonghe> page, @Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe);

    @Insert("insert into customer(cname,cspell,cclass,csource,cindustry,curl,cnation,ccity,caddress,cpostalcode,cfax,clinkman,cdept,cjob,cofficeno,cphonrno,cemail,clegal_person,ccapital,cexplain) values (#{cname},#{cspell},#{cclass},#{csource},#{cindustry},#{curl},#{cnation},#{ccity},#{caddress},#{cpostalcode},#{cfax},#{clinkman},#{cdept},#{cjob},#{cofficeno},#{cphonrno},#{cemail},#{clegalPerson},#{ccapital},#{cexplain})")
    public void insert_Customer(Customer customer);

    @Select("select * from customer where cname=#{cname}")
    public Customer selectByName(String cname);

    @Select("select * from moneyinfor m,customer c where c.mid=m.mid")
    public List<Moneyinfor> selectMoneyinfor();
}
