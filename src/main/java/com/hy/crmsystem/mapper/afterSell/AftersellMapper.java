package com.hy.crmsystem.mapper.afterSell;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.afterSell.*;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.documentary.Theme;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.*;

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
public interface AftersellMapper extends BaseMapper<Aftersell> {

    /**
     * 查询售后 带条件
     * @param ip
     * @param aftersellBo
     * @return
     */
    @SelectProvider(type = SqlProvider.class,method = "selectAfterSellBo")
    public IPage<AftersellBo> selectAftersellBo(@Param("ip") Page<AftersellBo> ip, @Param("aftersellBo") AftersellBo aftersellBo,@Param("types")int types);

    /*查询主题*/
    @Select("select id,theme from theme")
    public List<ThemeBo> selectTheme();

    /*查询user*/
    @Select("select * from user")
    public List<User> selectUser();

    /*查询contract*/
    @Select("select * from contract")
    public List<Contract> selectContract();

    /*查询contract*/
    @Select("select * from contract where customer_id = #{id}")
    public List<Contract> selectContractByCustomerId(int id);



    /*查询customer*/
    @Select("select * from customer")
    public List<Customer> selectCustomer();

    /*查询customer by id*/
    @Select("select * from customer where cid=#{cid}")
    public List<Customer> selectCustomerById(int cid);


    /*插入 theme*/
    @Insert("insert into theme(theme,cid) values (#{theme},#{cid})")
    public void insertTheme(Theme theme);

    /**
     * 根据cid 查num编号
     */
    @Select("select contract_num from contract where cid=#{cid}")
    public String selectContractNum(int cid);

    /**
     * 根据合同id查 合同编号
     */
    @Select("select * from contract where cid=#{cid}")
    public Contract selectContractNumByCustomerId(int cid);

    @Select("select max(id) from theme")
    public String selectMaxId();

    @Insert("insert into aftersell(theme,customer_id,cid,contract_infor,linkman,officeno,phoneno,emails,service_type,service_style,starttime,endtime,service_text,customer_return,service_people,service_score,file) values" +
            "(#{themeNo},#{customerId},#{cid},#{contractInfor},#{linkman},#{officeno},#{phoneno},#{emails},#{serviceType},#{serviceStyle},#{starttime},#{endtime},#{serviceText},#{customerReturn},#{username},#{serviceScore},#{file})")
    public void savaAfterSell(AfterSellBoTwo afterSellBoTwo);



    @Select("SELECT ase.status,ase.aid,t.theme,c.cname,ct.contract_num,ct.contract_name,ase.contract_infor,ase.linkman,ase.officeno,ase.phoneno,ase.emails,ase.service_type,ase.service_style,ase.starttime,ase.endtime,ase.service_text,ase.customer_return,ase.service_people,ase.service_score,ase.file FROM theme t,aftersell ase,customer c,contract ct WHERE t.id=ase.theme AND c.cid = ase.customer_id AND ct.cid =ase.cid AND ase.aid =#{aid}")
    public AfterSellThree selectOneAfterSell(Integer aid);


    /**
     * 查询新增条数
     */
    @SelectProvider(type = SqlProvider.class,method = "selectNewCount")
    public Integer selectNewCount(@Param("type")String type);

    @Select("select count(*) from theme where theme=#{name}")
    public Integer selectThemeCountByTheme(String name);

    @Update("update aftersell set status =#{type} where aid=#{aid}")
    public void updateStatus(@Param("type") Integer type,@Param("aid") Integer aid);



}
