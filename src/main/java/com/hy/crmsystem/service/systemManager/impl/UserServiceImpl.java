package com.hy.crmsystem.service.systemManager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.entity.systemManager.UserDept;
import com.hy.crmsystem.mapper.systemManager.UserMapper;
import com.hy.crmsystem.service.systemManager.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDept> selectAllUser(UserDept user) {
        return userMapper.selectAllUser(user);
    }

    public User selectDengLuRen(Object name) {
        return userMapper.selectDengLuRen(name);
    }

    public User selectUserByUid(Integer uid) {
        return userMapper.selectUserByUid(uid);
    }

    public void updateUser(User user) {
         userMapper.updateUser(user);
    }

    public void deleteUser(Integer uid){
        userMapper.deleteUser(uid);
    }

}
