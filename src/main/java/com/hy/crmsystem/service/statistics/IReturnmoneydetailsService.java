package com.hy.crmsystem.service.statistics;

import com.hy.crmsystem.entity.statistics.Returnmoneydetails;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public interface IReturnmoneydetailsService extends IService<Returnmoneydetails> {

    public BigDecimal sumWeek(String type);

    public BigDecimal sumMonth(String type);

    public BigDecimal sumQuarter(String type);

    public BigDecimal sumYear(String type);

}
