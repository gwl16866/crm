package com.hy.crmsystem.service.customerManager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import com.hy.crmsystem.mapper.customerManager.MoneyinforMapper;
import com.hy.crmsystem.service.customerManager.IMoneyinforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MoneyinforServiceImpl extends ServiceImpl<MoneyinforMapper, Moneyinfor> implements IMoneyinforService {
    @Autowired
private  MoneyinforMapper moneyinforMapper;
 /*   @Override
    public int inser_Moneyinfor(Moneyinfor moneyinfor) {
        moneyinforMapper.insert_Moneyinfor(moneyinfor);
    }*/
}
