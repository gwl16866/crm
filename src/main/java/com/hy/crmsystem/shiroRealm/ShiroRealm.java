package com.hy.crmsystem.shiroRealm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.systemManager.UserMapper;
import com.hy.crmsystem.service.systemManager.IUserService;
import com.hy.crmsystem.service.systemManager.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Iterator;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 先拿到用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User u = userService.selectDengLuRen(userName);
        Integer uid = u.getUid();

       // 根据用户uid查询 角色 和 权限

        // 用户角色
        HashSet<String> userRoleList = userService.selectRoleByUid(uid);

        // 用户权限
        HashSet<String> userHandList = userService.selectHandNameByUid(uid);

        // 角色权限
        HashSet<String> userRoleHandList = userService.selectRoleHandNameByUid(uid);

        //把角色权限放入用户权限
        Iterator roleHand=userRoleHandList.iterator();
        while (roleHand.hasNext()){
           userHandList.add((String) roleHand.next());
        }

        Iterator it=userHandList.iterator();
        while (it.hasNext()){
            System.out.println("全部权限---------------"+it.next());
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userRoleList);
        authorizationInfo.addStringPermissions(userHandList);
        return authorizationInfo;
    }



    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

       UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        // 根据用户名查询数据库
       QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_name",username);
        queryWrapper.eq("status",1);
        User user=userService.getOne(queryWrapper);

        if(user == null){
            throw new UnknownAccountException("此用户不存在");
        }
        // 变成盐
        ByteSource salt=ByteSource.Util.bytes(user.getUsername());
        // 加盐
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),salt,getName());
        // 返回校验
        return authenticationInfo;
    }


}
