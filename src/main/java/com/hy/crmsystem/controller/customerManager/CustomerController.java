package com.hy.crmsystem.controller.customerManager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.customerManager.LayUiData;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import com.hy.crmsystem.mapper.customerManager.MoneyinforMapper;
import com.hy.crmsystem.service.customerManager.ICustomerService;
import com.hy.crmsystem.service.customerManager.IMoneyinforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Controller
@RequestMapping("/customerManager")
public class CustomerController {
    @Autowired
private ICustomerService customerService;
    @Autowired
private IMoneyinforService moneyinforService;
    @Autowired
private MoneyinforMapper moneyinforMapper;

    @RequestMapping(value = "/queryAll.do")
    @ResponseBody
    public LayUiData query(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit" ,defaultValue = "3")Integer limit, Kehuiganlizonghe kehuiganlizonghe, HttpSession session){

        IPage list1=customerService.pages(page,limit,kehuiganlizonghe,session);
      /*  List<Kehuiganlizonghe> list=customerService.queryAll();*/
       /* session.setAttribute("list",list);*/
        LayUiData layUiData=new LayUiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list1.getTotal())));
        layUiData.setData(list1.getRecords());
        return layUiData;

    }
    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert_emp(Customer customer, Moneyinfor moneyinfor){
        String i="0";
             Integer mid=moneyinforMapper.insert(moneyinfor);
             customer.setMid(mid);
            customerService.save(customer);
            System.out.println(moneyinfor.getMbank()+moneyinfor.getMcarno()+moneyinfor.getMdutyno()+moneyinfor.getMname()+moneyinfor.getMphoneno());


        return i;



    }
    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectEmpById.do")
    public String selectEmpById(String cname,Model model){
        model.addAttribute("cust",customerService.selectByName(cname));
        model.addAttribute("money",customerService.selectMoneyinfor());
        return "/page/table/toUpdate";
    }
    //修改
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(Customer customer, Moneyinfor moneyinfor){
        String i="0";
        try{
            customerService.update(customer);
            customerService.update1(moneyinfor);
        }catch (Exception e){
            i="1";
        }
        return i;
    }
}
