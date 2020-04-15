package com.hy.crmsystem.service.systemManager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.systemManager.LoginMapper;
import com.hy.crmsystem.mapper.systemManager.UserMapper;
import com.hy.crmsystem.service.systemManager.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserMapper userMapper;

    public User selectDengLuRen(Object name){
        return userMapper.selectDengLuRen(name);
    }
}
