package com.hy.crmsystem.service.contract.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.mapper.contract.ContractMapper;
import com.hy.crmsystem.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Service
@Transactional
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    @Autowired
    ContractMapper contractMapper;

    //查询所有合同
    public List<Contract> selectAllCont(Contract contract, Integer condition) {
        return contractMapper.selectAllCont(contract, condition);
    }

    //查询汇款额
    public BigDecimal selectReturnMoney(Integer cid) {
       return contractMapper.selectReturnMoney(cid);
    }

    //查询客户
    public Customer selectCustomer(String cname){
        return contractMapper.selectCustomer(cname);
    }

    //帖子详情
    public Contract contractDetails(String contractNum){
        return contractMapper.contractDetails(contractNum);
    }


    //添加合同
   /* public void addContract(Contract contract){
        contractMapper.addContract(contract);
    }*/

}
