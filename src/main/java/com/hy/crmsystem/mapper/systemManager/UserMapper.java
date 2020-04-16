package com.hy.crmsystem.mapper.systemManager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.controller.systemManager.UserDao;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.entity.systemManager.UserDept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * Mapper 接口
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

    @SelectProvider(type = UserDao.class, method = "selectAllUser")
    public List<UserDept> selectAllUser(UserDept user);

    @Select("select u.*,d.* from user u,dept d where u.dept_id=d.dept_id and uid=#{uid}")
    public User selectUserByUid(Integer uid);

    @Update("update user set password=#{password} where uid=#{uid}")
    public void updateUser(User user);

    @Update("update user set status=2 where uid=#{uid}")
    public void deleteUser(Integer uid);
}
