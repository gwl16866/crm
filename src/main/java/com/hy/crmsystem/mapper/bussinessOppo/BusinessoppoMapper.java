package com.hy.crmsystem.mapper.bussinessOppo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Mapper
public interface BusinessoppoMapper extends BaseMapper<Businessoppo> {
    @Select("select bname,status,bpredict_money,bprincipal,last_time from businessoppo")
    IPage<Businessoppo> queryAllList(@Param("page") Page<Businessoppo> page, @Param("businessoppo") Businessoppo businessoppo);

    @Select("select * from businessoppo where bid=#{value}")
    public Customer selectByName(String bid);

    @Select("SELECT c.cname,c.cindustry,c.ccity,c.caddress,c.csource FROM customer c,businessoppo b WHERE c.cid=b.cid GROUP BY b.cid=#{value}")
    public Businessoppo selectBusinessoppo(String bid);
}
