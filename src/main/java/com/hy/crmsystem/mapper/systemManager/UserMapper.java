package com.hy.crmsystem.mapper.systemManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user values(#{username},#{password},#{age},#{sex})")
    public void Add(User user);

    @Select("select uid from user where user_name=#{name}")
    public User selectDengLuRen(Object name);
}
