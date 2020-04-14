package com.hy.crmsystem.mapper.contract;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.controller.contract.ContractDao;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.contract.ContractCust;
import com.hy.crmsystem.entity.customerManager.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
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
public interface ContractMapper extends BaseMapper<Contract> {

    //查询所有合同
    @SelectProvider(type = ContractDao.class, method = "selectAllCont")
    public List<Contract> selectAllCont(Contract contract, Integer condition);

    //查询回款额
    @Select("select sum(return_money) returnMoney from returnmoneydetails where cid=#{cid}")
    public BigDecimal selectReturnMoney(Integer cid);

    //查询开票额
    @Select("select sum(ticket_money) openMoney from openpaper where contract_file=#{cid}")
    public BigDecimal selectOpenMoney(Integer cid);

    //查询客户
    @Select("select * from customer where cname=#{cname}")
    public Customer selectCustomer(String cname);

    //帖子详情
    @Select("select c.*,r.* from contract c,customer r where c.customer_id=r.cid and c.contract_num=#{contractNum}")
    public ContractCust contractDetails(String contractNum);

    @Update("update contract set residue_money=residue_money-#{returnMoney} where cid=#{cid}")
    public void updateResidueMoney(ContractCust contractCust);

}
