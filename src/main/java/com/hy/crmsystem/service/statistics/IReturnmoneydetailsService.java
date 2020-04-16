package com.hy.crmsystem.service.statistics;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.entity.contract.Returnmoneydetails;
import com.hy.crmsystem.entity.statistics.AllWeekStatistics;

import java.math.BigDecimal;
import java.util.List;

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

    public BigDecimal sumDocumentary(String type);

    public BigDecimal sumContract(String type);

    public BigDecimal sumOkMoney(String type);

    public List<AllWeekStatistics> sumAll(String type);

    public String decimalFormatString(BigDecimal decimalParam);


}
