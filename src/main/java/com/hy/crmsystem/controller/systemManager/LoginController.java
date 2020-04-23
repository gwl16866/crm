package com.hy.crmsystem.controller.systemManager;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.service.systemManager.IUserService;
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

    //登陆页面
    @RequestMapping("/login.do")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        System.out.println(username+password);
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
    public String register(Model model,User user){

            String user1= usersService.selectname(user.getUsername());
            if(user1!=null){
                model.addAttribute("mess","账号或密码不能重复");
                return "page/error";
            }else{
                //密码
                Object password=user.getPassword();
                //盐值
                Object salt= ByteSource.Util.bytes(user.getUsername());
                Object simpleHash=new SimpleHash("MD5",password,salt,1024);
                User infor=new User();
                infor.setDeptId(user.getDeptId());
                infor.setUsername(user.getUsername());
                infor.setPassword(String.valueOf(simpleHash));
                infor.setAge(user.getAge());
                infor.setSex(user.getSex());
                usersService.add(infor);
                return "page/login-1";
            }

    }
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "page/login-1";
    }
    @RequestMapping("/selectDept.do")
    public String selectDept(Model model){
        model.addAttribute("dept",usersService.select());
        return "page/zhuce";
    }

}
