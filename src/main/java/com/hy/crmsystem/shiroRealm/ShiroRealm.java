package com.hy.crmsystem.shiroRealm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.service.systemManager.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService UserService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
 /*       // 先拿到用户名
       String userName = (String) principalCollection.getPrimaryPrincipal();

       // 根据用户名查询 角色 和 权限

        // 用户角色
        HashSet<String> userRoleList = iInforService.selectRoleByUid(userName);

        // 用户权限
        HashSet<String> userHandList = iInforService.selectHandNameByName(userName);

        // 角色权限
        HashSet<String> userRoleHandList = iInforService.selectRoleHandNameByName(userName);

        Iterator roleHand=userRoleHandList.iterator();
        while (roleHand.hasNext()){
           userHandList.add((String) roleHand.next());
        }

        Iterator it=userHandList.iterator();
        while (it.hasNext()){
            System.out.println("全部权限"+it.next());
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userRoleList);
        authorizationInfo.addStringPermissions(userHandList);
        return authorizationInfo;*/
        return null;
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
        User user=UserService.getOne(queryWrapper);

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
