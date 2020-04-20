package com.hy.crmsystem.controller.systemManager;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.entity.systemManager.*;
import com.hy.crmsystem.service.systemManager.impl.UserServiceImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
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
        System.out.println("+++++++++++++++++++++++++++++++++++" + user.getPassword());
        if (user.getPassword() == null || user.getPassword().equals("")) {
            System.out.println("++++++++++++++++++++++++++++++++++++++==========" + user.getPassword());
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
        List<Role> RoleList = userService.queryAllRole(role);
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

        if (size1 != 0 && size2 != 0) {
            return "2";
        } else {
            userService.deleteRole(rid);
            return "1";
        }
    }

    @RequestMapping("/setRole.do")
    public String setRole(Model model, Integer uid) {
        //所有角色
        List<Role> RoleList = userService.queryAllRole(new Role());
        //拥有角色
        List<Role> HaveRoleList = userService.queryHaveRole(uid);
        model.addAttribute("allRoles", RoleList);
        model.addAttribute("some", HaveRoleList);
        return "/projectPage/systemManager/setRole";
    }

    @ResponseBody
    @RequestMapping("/updateRoleUid.do")
    public String updateRoleUid() {
        System.out.println();
        return "null";
    }

}
