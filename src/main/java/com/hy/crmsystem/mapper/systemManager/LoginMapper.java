package com.hy.crmsystem.mapper.systemManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper extends BaseMapper<User> {
    @Select("select * from user where user_name=#{value}")
    public User selectUser(String username);



}
