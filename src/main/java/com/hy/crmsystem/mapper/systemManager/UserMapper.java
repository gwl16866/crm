package com.hy.crmsystem.mapper.systemManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.entity.systemManager.DeskPojo;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user values(#{username},#{password},#{age},#{sex})")
    public void Add(User user);

    @Select("select uid from user where user_name=#{name}")
    public User selectDengLuRen(Object name);


    @Select("SELECT SUM(return_money) val,DATE_FORMAT(return_date,'%m') month FROM returnmoneydetails GROUP BY DATE_FORMAT(return_date,'%Y%m')ORDER BY DATE_FORMAT(return_date,'%Y%m')")
    public ArrayList<DeskPojo> seleMoneyByMonth();

    @Select("SELECT COUNT(*) val,DATE_FORMAT(create_date,'%m') month FROM USER GROUP BY DATE_FORMAT(create_date,'%Y%m')ORDER BY DATE_FORMAT(create_date,'%Y%m')")
    public ArrayList<DeskPojo> selectSumUsers();

    @Select("SELECT COUNT(*)val,DATE_FORMAT(insert_date,'%m') month FROM customer GROUP BY DATE_FORMAT(insert_date,'%Y%m') ORDER BY DATE_FORMAT(insert_date,'%Y%m')")
    public ArrayList<DeskPojo> selectSumCustomer();


    @Select("SELECT COUNT(*)val,DATE_FORMAT(insert_date,'%m') month FROM businessoppo GROUP BY DATE_FORMAT(insert_date,'%Y%m') ORDER BY DATE_FORMAT(insert_date,'%Y%m')")
    public ArrayList<DeskPojo> selectBussinessCounts();

    @Select("SELECT COUNT(*)val,DATE_FORMAT(insert_time,'%m') MONTH FROM contract GROUP BY DATE_FORMAT(insert_time,'%Y%m') ORDER BY DATE_FORMAT(insert_time,'%Y%m')")
    public ArrayList<DeskPojo> selectContractCounts();
}
