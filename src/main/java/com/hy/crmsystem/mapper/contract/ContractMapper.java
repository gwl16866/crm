package com.hy.crmsystem.mapper.contract;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.controller.contract.ContractDao;
import com.hy.crmsystem.entity.contract.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

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

}
