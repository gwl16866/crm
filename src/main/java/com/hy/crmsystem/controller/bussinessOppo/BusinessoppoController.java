package com.hy.crmsystem.controller.bussinessOppo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.bussinessOppo.ForumLunTan;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.bussinessOppo.BusinessoppoMapper;
import com.hy.crmsystem.service.bussinessOppo.IBusinessoppoService;
import com.hy.crmsystem.service.customerManager.ICustomerService;
import com.hy.crmsystem.service.systemManager.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.certpath.CertId;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/bussinessOppo")
public class BusinessoppoController {
    @Autowired
    private IBusinessoppoService businessoppoService;
    @Autowired
    private BusinessoppoMapper businessoppoMapper;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private ICustomerService customerService;

    //全部商机
    @RequestMapping(value = "/queryAll.do")
    @ResponseBody
    public LayuiData query(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit, Businessoppo businessoppo, HttpSession session) {

        IPage list1 = businessoppoService.pages(page, limit, businessoppo, session);


        LayuiData layUiData = new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list1.getTotal())));
        layUiData.setData(list1.getRecords());

        /*List<Businessoppo> list = businessoppoService.listQueryAll(businessoppo);
        session.setAttribute("list", list);*/
        return layUiData;
    }

    //我的商机
    @RequestMapping("/selectMyBus.do")
    public String selectMyBus(Model model) {
        //查询登录人
        Object name = SecurityUtils.getSubject().getPrincipal();
        User u = userService.selectDengLuRen(name);
        model.addAttribute("uid", u.getUid());
        return "projectPage/bussinessOppo/myBussinessOppo";
    }

    //查询客户
    @ResponseBody
    @RequestMapping("/selectCustomer.do")
    public Customer selectCustomer(String cname) {
        return businessoppoService.selectCustomer(cname);
    }


    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert_emp(Customer customer, Businessoppo businessoppo) {
        String i = "0";
        Customer cus = businessoppoService.selectCustomer(customer.getCname());
        if(cus==null){
            customer.setCname(customer.getCname());
            customer.setCindustry(customer.getCindustry());
            customer.setCcity(customer.getCcity());
            customer.setCaddress(customer.getCaddress());
            customer.setCsource(customer.getCsource());
            customerService.save(customer);
        }
        Customer c = businessoppoService.selectMaxCustomer();
        businessoppo.setCid(c.getCid());
        businessoppoMapper.insert(businessoppo);
        return i;
    }

    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectEmpById.do")
    public String selectEmpById(Integer bid, Model model) {
        model.addAttribute("bus", businessoppoService.selectByName(String.valueOf(bid)));
        model.addAttribute("cust", businessoppoService.selectBusinessoppo(String.valueOf(bid)));
        return "projectPage/documentary/toUpdateDocumentary";
    }
    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectEmpById1.do")
    public String selectEmpById1(Integer bid, Model model) {
        model.addAttribute("bus", businessoppoService.selectByName(String.valueOf(bid)));
        model.addAttribute("cust", businessoppoService.selectBusinessoppo(String.valueOf(bid)));
        return "projectPage/bussinessOppo/toUpdate";
    }

    @ResponseBody
    @RequestMapping("/update.do")
    public String update(Businessoppo businessoppo,Customer customer) {
        businessoppoService.updateById(businessoppo);
        customerService.updateById(customer);
        return "0";
    }

    @ResponseBody
    @RequestMapping("/selectCount.do")
    public String selectCount(String type) {
        return businessoppoService.selectCount(type);
    }

   /* @ResponseBody
    @RequestMapping("/selectNewCount.do")
    public Integer selectNewCount(String type) {
        return businessoppoService.selectNewCount(type);
    }
*/
   //根据 id 查信息进行展示 以 修改
   @RequestMapping("/selectById2.do")
   public String selectById2(String bid,Model model){
       List<String> list1=businessoppoService.selectById2(bid);
       model.addAttribute("list1",list1);
       return "/projectPage/bussinessOppo/forumLunTan";
   }

    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/select1.do")
    @ResponseBody
    public LayuiData select1(String[] id,Model model){
        List<ForumLunTan> list=businessoppoService.select1(id);
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list.size())));
        layUiData.setData(list);
        return layUiData;
    }

    @ResponseBody
    @RequestMapping("selectUser.do")
    public List selectUser(){
        return businessoppoService.selectUser();
    }











}
