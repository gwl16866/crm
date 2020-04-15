package com.hy.crmsystem.service.statistics.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.contract.Returnmoneydetails;
import com.hy.crmsystem.mapper.statistics.ReturnmoneydetailsMapper;
import com.hy.crmsystem.service.statistics.IReturnmoneydetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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
public class ReturnmoneydetailsServiceImpl extends ServiceImpl<ReturnmoneydetailsMapper,Returnmoneydetails> implements IReturnmoneydetailsService {

    @Autowired
    private ReturnmoneydetailsMapper returnmoneydetailsMapper;
    @Override
    public BigDecimal sumWeek(String type) {
        return returnmoneydetailsMapper.sumWeek(type);
    }

    @Override
    public BigDecimal sumMonth(String type) {
        return returnmoneydetailsMapper.sumMonth(type);
    }

    @Override
    public BigDecimal sumQuarter(String type) {
        return returnmoneydetailsMapper.sumQuarter(type);
    }

    @Override
    public BigDecimal sumYear(String type) {
        return returnmoneydetailsMapper.sumYear(type);
    }
}
