package com.hy.crmsystem.controller.systemManager;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.entity.systemManager.Dept;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.entity.systemManager.UserDept;
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
        System.out.println(user);
        Object salt = ByteSource.Util.bytes(user.getUsername());
        Object simpleHash = new SimpleHash("MD5", user.getPassword(), salt, 1024);
        user.setPassword(String.valueOf(simpleHash));
        userService.updateUser(user);
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





}
