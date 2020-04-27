package com.hy.crmsystem.controller.systemManager;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.entity.systemManager.*;
import com.hy.crmsystem.flowable.Sysout;
import com.hy.crmsystem.service.systemManager.impl.UserServiceImpl;
import com.mysql.jdbc.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 *
 */
@Controller
@RequestMapping("/systemManager")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("/selectAllUser.do")
    public LayuiData selectAllUser(UserDept user, @RequestParam(value = "page", required = true, defaultValue = "1") int page, @RequestParam(value = "limit", required = true, defaultValue = "10") int pageSize) {
        //分页
        Page pageHelper = PageHelper.startPage(page, pageSize, true);
        List<UserDept> userList = userService.selectAllUser(user);

        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        layuiData.setCount((int) pageHelper.getTotal());
        layuiData.setData(userList);

        return layuiData;
    }

    @RequestMapping("/selectUserByUid.do")
    public String selectUserByUid(Integer uid, Model model) {
        User user = userService.selectUserByUid(uid);
        List<Dept> depts = userService.queryDept();
        model.addAttribute("user", user);
        model.addAttribute("depts", depts);
        return "/projectPage/systemManager/updateUser";
    }

    @ResponseBody
    @RequestMapping("/updateUser.do")
    public String updateUser(User user) {
        if (user.getPassword() == null || user.getPassword().equals("")) {
            userService.NoupdateUserPassword(user);
        } else {
            //密码加盐
            Object salt = ByteSource.Util.bytes(user.getUsername());
            Object simpleHash = new SimpleHash("MD5", user.getPassword(), salt, 1024);
            user.setPassword(String.valueOf(simpleHash));
            userService.updateUser(user);
        }
        return "1";
    }

    @ResponseBody
    @RequestMapping("/deleteUser.do")
    public String deleteUser(Integer uid) {
        userService.deleteUser(uid);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/queryDept.do")
    public List<Dept> queryDept() {
        return userService.queryDept();
    }


    @ResponseBody
    @RequestMapping("/queryAllRole.do")
    public LayuiData queryAllRole(Role role
             , @RequestParam(value = "page", required = true, defaultValue = "1") int page
            , @RequestParam(value = "limit", required = true, defaultValue = "5") int pageSize) {
       List<Role> RoleList =  userService.queryAllRole(role);
        Page pageHelper = PageHelper.startPage(page, pageSize, true);
        LayuiData layuiData = new LayuiData();
        layuiData.setMsg("");
        layuiData.setCode(0);
        layuiData.setCount(RoleList.size());
        layuiData.setData(RoleList);
        return layuiData;
    }

    @RequestMapping("/selectRoleByUid.do")
    public String selectRoleByUid(Integer rid, Model model) {
        Role role = userService.queryRoleById(rid);
        model.addAttribute("role", role);
        return "/projectPage/systemManager/updateRole";
    }

    @ResponseBody
    @RequestMapping("/updateRole.do")
    public String updateRole(Role role) {
        userService.updateRole(role);
        return "1";
    }



    @ResponseBody
    @RequestMapping("/deleteRole.do")
    public String deleteRole(Integer rid) {
        Integer size1 = userService.selectCountRolePermission(rid);
        Integer size2 = userService.selectCountUserRole(rid);

       if(size1 != 0 || size2 != 0){
           return "2";
       }else {
           userService.deleteRole(rid);
           return "1";
       }
    }

    @RequestMapping("/setRole.do")
    public String setRole(Model model,Integer uid) {
        //所有角色
        List<Role> RoleList =  userService.queryAllRole(new Role());
        //拥有角色
        List<Integer> HaveRoleList =  userService.queryHaveRole(uid);
        model.addAttribute("allRoles",RoleList);
        model.addAttribute("someRoles",HaveRoleList);
        model.addAttribute("uid",uid);
        return "/projectPage/systemManager/setRole";
    }


    //修改用户角色
    @ResponseBody
    @RequestMapping("/updateRoleUid.do")
    public String updateRoleUid(String[] rids,@RequestParam("uid") Integer uid) {
        if(rids != null && rids.length>=0){
            //先删除
            userService.deleteUserRoleByUid(uid);
            //再添加角色
            userService.updateRoleIdByUid(rids,uid);
            return "1";
        }else{
            //只删除
            userService.deleteUserRoleByUid(uid);
            return "1";
        }

    }

    //新增角色
    @ResponseBody
    @RequestMapping("/addRole.do")
    public String addRole(String roleName) {
        userService.addRole(roleName);
        return "1";
    }

    //给用户查询权限
    @RequestMapping("/setUserPerms.do")
    public String setUserPerms(Integer uid,Model model) {
        //装全部权限
        List<Permission> list = new ArrayList<>();
        //查询一级权限
        List<Permission> first = userService.queryFirstPermission();
        //根据uid查他的用户权限
        List<Integer> userHaveHand = userService.userHaveHand(uid);
        //递归查询 二三级 权限
        if(first.size()>0 && !first.isEmpty()){
          list =  userService.recursionHands(first);
        }


        model.addAttribute("allPermission",list);
        model.addAttribute("havePermission",userHaveHand);
        model.addAttribute("uid",uid);
        return "/projectPage/systemManager/setUserPermission";
    }

    //给用户设置新权限
    @ResponseBody
    @RequestMapping("/updatePermissionUid.do")
    public String updatePermissionUid(@RequestParam(value = "pids",required = false) String[] pids,@RequestParam("uid") Integer uid) {
        if(pids != null && pids.length>=0){
            //先删除
            userService.deleteUserPermissionByUid(uid);

            //再添加一二级权限
            userService.updateUserHandByUid(pids,uid);
            //查询三级权限
            String[] thirdPerms = userService.selectThirdPerms(pids);
            //再添加三级权限
            userService.updateUserHandByUid(thirdPerms,uid);
            return "1";
      }else{
            //只删除
            userService.deleteUserPermissionByUid(uid);
            return "1";
      }

    }

    //给角色设置新权限
    @ResponseBody
    @RequestMapping("/updatePermissionRid.do")
    public String updatePermissionRid(@RequestParam(value = "pids",required = false) String[] pids,@RequestParam("rid") Integer rid) {
        if(pids != null && pids.length>=0){
            //先删除
            userService.deleteRolePermissionByRid(rid);
            //再添加一二级权限
            userService.updateRoleHandByRid(pids,rid);
            //查询三级权限
            String[] thirdPerms = userService.selectThirdPerms(pids);
            //再添加三级权限
            userService.updateRoleHandByRid(thirdPerms,rid);
            return "1";
       }else{
            //只删除
            userService.deleteRolePermissionByRid(rid);
            return "1";
       }

    }






    //给角色查询权限
    @RequestMapping("/setRolePerms.do")
    public String setRolePerms(Integer rid,Model model) {
        //装全部权限
        List<Permission> list = new ArrayList<>();
        //查询一级权限
        List<Permission> first = userService.queryFirstPermission();
        //根据rid查他的角色权限
        List<Integer> roleHaveHand = userService.roleHaveHand(rid);
        //递归查询 二三级 权限
        if(first.size()>0 && !first.isEmpty()){
            list =  userService.recursionHands(first);
        }

        model.addAttribute("allPermission",list);
        model.addAttribute("roleHaveHand",roleHaveHand);
        model.addAttribute("rid",rid);
        return "/projectPage/systemManager/setRolePermission";
    }

    @ResponseBody
    @RequestMapping("/approve.do")
    public LayuiData approve(@RequestParam(value = "page", required = true, defaultValue = "1") int page
            , @RequestParam(value = "limit", required = true, defaultValue = "3") int pageSize){
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        Page pageHelper = PageHelper.startPage(page, pageSize, true);
        ProcessEngine processEngine = userService.initQuery();
        List<Approve> list = userService.queryWaitDo(processEngine,userName);
        LayuiData layuiData = new LayuiData();
        layuiData.setData(list);
        layuiData.setCount(list.size());
        layuiData.setCode(0);
        layuiData.setMsg("");
        return layuiData;
    }

    @ResponseBody
    @RequestMapping("/firstApprove.do")
    public String firstApprove(String taskId,String cid){
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        if(userName.equals("老二")){
            userService.CheckSecondApprove(taskId);
        }else if(userName.equals("老大")){
            userService.CheckThirdApprove(taskId);
            userService.updateContractByCid(cid);

        }else{
            userService.CheckFirstApprove(taskId);
        }

        return "1";
    }








}
