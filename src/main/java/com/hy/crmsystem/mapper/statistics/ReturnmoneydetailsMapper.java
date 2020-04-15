package com.hy.crmsystem.mapper.statistics;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.statistics.Returnmoneydetails;
import com.hy.crmsystem.entity.statistics.TableStatistics;
import com.hy.crmsystem.mapper.afterSell.StatisticsProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

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
public interface ReturnmoneydetailsMapper extends BaseMapper<Returnmoneydetails> {

    @SelectProvider(type = StatisticsProvider.class,method = "sumWeek")
    public BigDecimal sumWeek(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumWeekAndCustomer")
    public TableStatistics sumWeekAndCustomer(@Param("type") String type,@Param("name")String name);

    @SelectProvider(type = StatisticsProvider.class,method = "sumWeekAndCustomerCounts")
    public Integer sumWeekAndCustomerCounts(@Param("type") String type,@Param("name")String name);




    @SelectProvider(type = StatisticsProvider.class,method = "sumMonth")
    public BigDecimal sumMonth(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumMonthAndCustomer")
    public TableStatistics sumMonthAndCustomer(@Param("type") String type,@Param("name")String name);

    @SelectProvider(type = StatisticsProvider.class,method = "sumMonthAndCustomerCounts")
    public Integer sumMonthAndCustomerCounts(@Param("type") String type,@Param("name")String name);



    @SelectProvider(type = StatisticsProvider.class,method = "sumQuarter")
    public BigDecimal sumQuarter(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumQuarterAndCustomer")
    public TableStatistics sumQuarterAndCustomer(@Param("type") String type,@Param("name")String name);

    @SelectProvider(type = StatisticsProvider.class,method = "sumQuarterAndCustomerCounts")
    public Integer sumQuarterAndCustomerCounts(@Param("type") String type,@Param("name")String name);






    @SelectProvider(type = StatisticsProvider.class,method = "sumYear")
    public BigDecimal sumYear(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumYearAndCustomer")
    public TableStatistics sumYearAndCustomer(@Param("type") String type,@Param("name")String name);

    @SelectProvider(type = StatisticsProvider.class,method = "sumYearAndCustomerCounts")
    public Integer sumYearAndCustomerCounts(@Param("type") String type,@Param("name")String name);









    @SelectProvider(type = StatisticsProvider.class,method = "sumDocumentary")
    public BigDecimal sumDocumentary(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumDocumentaryAndCustomer")
    public TableStatistics sumDocumentaryAndCustomer(@Param("type") String type,@Param("name") String name);

    @SelectProvider(type = StatisticsProvider.class,method = "sumDocumentaryAndCustomerCounts")
    public Integer sumDocumentaryAndCustomerCounts(@Param("type") String type,@Param("name") String name);





    @SelectProvider(type = StatisticsProvider.class,method = "sumContract")
    public BigDecimal sumContract(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumContractAndCustomer")
    public TableStatistics sumContractAndCustomer(@Param("type") String type,@Param("name") String name);

    @SelectProvider(type = StatisticsProvider.class,method = "sumContractAndCustomerCounts")
    public Integer sumContractAndCustomerCounts(@Param("type") String type,@Param("name") String name);







    @SelectProvider(type = StatisticsProvider.class,method = "sumOkMoney")
    public BigDecimal sumOkMoney(@Param("type") String type);

    @SelectProvider(type = StatisticsProvider.class,method = "sumOkMoneyAndCustomer")
    public TableStatistics sumOkMoneyAndCustomer(@Param("type") String type,@Param("name") String name);

    @SelectProvider(type = StatisticsProvider.class,method = "sumOkMoneyAndCustomerCounts")
    public Integer sumOkMoneyAndCustomerCounts(@Param("type") String type,@Param("name") String name);



    @Select("select * from customer")
    public List<Customer> selectCustomer();
}
