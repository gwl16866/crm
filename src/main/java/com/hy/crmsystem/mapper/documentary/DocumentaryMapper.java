package com.hy.crmsystem.mapper.documentary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.documentary.Documentary;

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
public interface DocumentaryMapper extends BaseMapper<Documentary> {

    @SelectProvider(type = SqlProvider3.class,method = "select_documentary_like")
    IPage<Documentary> queryAll(@Param("page") Page<Documentary> page, @Param("documentary") Documentary documentary);

    @SelectProvider(type = SqlProvider3.class,method = "select_documentary_like")
    public List<Documentary> listQueryAll(@Param("documentary") Documentary documentary);
    /*查询主题*/
    @Select("SELECT bid,bname FROM businessoppo")
    public List<Businessoppo> selectBname();
    @Select("SELECT documentary_time,documentary_class,documentary_people,detail,file FROM documentary where theme=#{theme}")
    public List<Documentary> selectTheme(String theme);

    //根据商机查询跟单
    @Select("select * from documentary where bid=#{bid}")
    public List<Documentary> selectDocByBus(Integer bid);

    //添加跟单时修改最后时间
    @Update("update businessoppo set last_time=now() where bid=#{bid}")
    public void updateBusTime(Integer bid);


    @Insert("insert into documentary(bid,documentary_time,documentary_class,documentary_people,detail,file,uid,theme) values (#{theme},#{documentaryTime},#{documentaryClass},#{documentaryPeople},#{detail},#{file},#{uid},#{theme})")
    public void insert_documentary(Documentary documentary);


}
