package com.hy.crmsystem.mapper.statistics;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.entity.statistics.Returnmoneydetails;
import com.hy.crmsystem.mapper.afterSell.StatisticsProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Mapper
public interface ReturnmoneydetailsMapper extends BaseMapper<Returnmoneydetails> {

    @SelectProvider(type = StatisticsProvider.class,method = "sumWeek")
    public BigDecimal sumWeek(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumMonth")
    public BigDecimal sumMonth(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumQuarter")
    public BigDecimal sumQuarter(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumYear")
    public BigDecimal sumYear(@Param("type") String type);


}
