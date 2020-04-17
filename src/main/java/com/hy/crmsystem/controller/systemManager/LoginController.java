package com.hy.crmsystem.controller.systemManager;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.service.systemManager.IUserService;
import com.hy.crmsystem.service.systemManager.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
@Controller
public class LoginController {
    //日志
    Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private IUserService usersService;
    @Autowired
    private UserServiceImpl userServicel;

    //登陆页面
    @RequestMapping("/login.do")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();

//shiro框架进行登录验证
        try {
            subject.login(token);
            logger.info("登录成功");
        } catch (UnknownAccountException e) {
            model.addAttribute("message", "用户名不存在");
            return "page/error";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message", "密码错误");
            return "page/error";
        }
        return "index.html";
    }

    @RequestMapping("/register.do")
    public String register(@RequestParam("deptId")int deptId,@RequestParam("username") String username, @RequestParam("password") String psw, Model model, @RequestParam("age") int age, @RequestParam("sex") int sex){
        if("".equals(username) || null == username || "".equals(psw) || null == psw){
            model.addAttribute("message","账号或密码不能为空");
            return "error";
        }else{
            String user1= userServicel.selectname(username);
            if(user1!=null){
                model.addAttribute("mess","账号或密码不能重复");

                return "page/error";
            }else{
            //密码
            Object password=psw;
            //盐值
            Object salt= ByteSource.Util.bytes(username);
            Object simpleHash=new SimpleHash("MD5",password,salt,1024);
            User infor=new User();
            infor.setDeptId(deptId);
            infor.setUsername(username);
            infor.setPassword(String.valueOf(simpleHash));
            infor.setAge(age);
            infor.setSex(sex);
           userServicel.add(infor);
            /*if(a == true){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }*/
            return "page/login-1";
            }
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
    @RequestMapping("/selectDept.do")
    public String selectDept( Model model){
        model.addAttribute("dept",userServicel.select());
        return "page/zhuce";
    }






}
