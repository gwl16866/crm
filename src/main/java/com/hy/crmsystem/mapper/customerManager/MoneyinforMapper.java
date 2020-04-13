package com.hy.crmsystem.mapper.customerManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoneyinforMapper extends BaseMapper<Moneyinfor> {

    @Insert("insert into moneyinfor(mcarno,mname,mbank,mdutyno,mphoneno)values(#{mcarno},#{mname},#{mbank},#{mdutyno},#{mphoneno})")
    int insert_Moneyinfor(Moneyinfor moneyinfor);



}
