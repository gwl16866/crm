package com.hy.crmsystem.mapper.customerManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.afterSell.Aftersell;
import com.hy.crmsystem.entity.afterSell.AftersellBo;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.contract.ContractCust;
import com.hy.crmsystem.entity.customerManager.AftersellShu;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import com.hy.crmsystem.entity.systemManager.Dept;
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
    @Select("SELECT cname,cb.cob as bussinessCount,cb.bpr as bpredictMoney,cc.cou as contractCount,cc.mon as contractMoney,cr.su as returnMoney, ca.un as caftersaleCount,ca.ag as serviceScore FROM customer c LEFT JOIN (SELECT  c.cid,COUNT(b.cid) cob,b.bpredict_money bpr FROM customer c LEFT JOIN businessoppo b ON c.cid=b.cid GROUP BY b.cid) cb ON c.cid=cb.cid LEFT JOIN (SELECT c.cid,COUNT(c1.customer_id) cou,c1.contract_money mon  FROM customer c LEFT JOIN contract c1 ON c.cid=c1.customer_id GROUP BY c1.customer_id ) cc ON c.cid=cc.cid LEFT JOIN (SELECT c1.cid,SUM(r.return_money) su FROM contract c1 LEFT JOIN returnmoneydetails r ON c1.cid=r.cid GROUP BY r.cid) cr ON c.cid=cr.cid LEFT JOIN (SELECT  c.cid,COUNT(a.customer_id) un,AVG(a.service_score) ag FROM customer c LEFT JOIN aftersell a ON c.cid=a.customer_id GROUP BY a.customer_id) ca ON c.cid=ca.cid\n;")
    public List<Kehuiganlizonghe> queryAll();

    //    联合查询
  /*  @SelectProvider(type = SqlProvider.class,method = "select_emp_like")
    List<Kehuiganlizonghe> queryAlls( @Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe);*/

    //    分页联合查询

    @SelectProvider(type = SqlProvider1.class,method = "select_emp_like")
    IPage<Kehuiganlizonghe> queryAllList(@Param("page") Page<Kehuiganlizonghe> page, @Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe);


    @SelectProvider(type = SqlProvider1.class,method = "select_emp_like")
        public List<Kehuiganlizonghe> listQueryAll(@Param("kehuiganlizonghe") Kehuiganlizonghe kehuiganlizonghe);




    @Insert("insert into customer(cname,cspell,cclass,csource,cindustry,curl,cnation,ccity,caddress,cpostalcode,cfax,clinkman,cdept,cjob,cofficeno,cphonrno,cemail,clegal_person,ccapital,cexplain) values (#{cname},#{cspell},#{cclass},#{csource},#{cindustry},#{curl},#{cnation},#{ccity},#{caddress},#{cpostalcode},#{cfax},#{clinkman},#{cdept},#{cjob},#{cofficeno},#{cphonrno},#{cemail},#{clegalPerson},#{ccapital},#{cexplain})")
    public void insert_Customer(Customer customer);

    @Select("select * from customer where cid=#{value}")
    public Customer selectByName(String cid);

    @Select("select m.* from moneyinfor m,customer c where c.mid=m.mid and c.cid=#{value}")
    public Moneyinfor selectMoneyinfor(String cid);

    @Select("select max(cid) cid from customer")
    public Customer selectMaxCustomer();

    @Select("select bid from businessoppo where cid=#{value}")
    public List<String> select(String cid);

    @SelectProvider(type = SqlProvider1.class,method = "select1")
    public List<Businessoppo> select1(@Param("bid") String[] bid,@Param("businessoppo") Businessoppo businessoppo);

    @Select("select cid from contract where customer_id=#{value}")
    public List<String> selectBy(String cid);

    @SelectProvider(type = SqlProvider1.class,method = "select2")
    public List<Contract> select2(@Param("cid") String[] cid,@Param("contract") Contract contract);

    @Select("select aid from aftersell where customer_id=#{value}")
    public List<String> selectBy1(String cid);

    @SelectProvider(type = SqlProvider1.class,method = "select3")
    public List<AftersellShu> select3(@Param("aid") String[] aid,@Param("aftersellBo") AftersellBo aftersellBo);



}
