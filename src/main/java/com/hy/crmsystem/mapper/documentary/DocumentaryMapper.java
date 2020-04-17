package com.hy.crmsystem.mapper.documentary;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.afterSell.ThemeBo;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.documentary.Documentary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mapper.bussinessOppo.SqlProvider2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

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

}
