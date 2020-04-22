package com.hy.crmsystem.controller.customerManager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.entity.afterSell.Aftersell;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.customerManager.AftersellShu;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.systemManager.LayuiData;
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
import java.util.List;

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
    public LayuiData query(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit" ,defaultValue = "3")Integer limit, Kehuiganlizonghe kehuiganlizonghe, HttpSession session){

        IPage<Kehuiganlizonghe> list1=customerService.pages(page,limit,kehuiganlizonghe,session);
      /*  List<Kehuiganlizonghe> list=customerService.queryAll();*/
       /* session.setAttribute("list",list);*/
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list1.getTotal())));
        layUiData.setData(list1.getRecords());
        List<Kehuiganlizonghe> list=customerService.listQueryAll(kehuiganlizonghe);
        session.setAttribute("list",list);
        return layUiData;

    }
    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert_emp(Customer customer, Moneyinfor moneyinfor){
        String i="0";
             Integer mid=moneyinforMapper.insert(moneyinfor);
             customer.setMid(mid);
            customerService.save(customer);
        return i;

    }
    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectEmpById.do")
    public String selectEmpById(String cid,Model model){
        model.addAttribute("cust",customerService.selectByName(cid));
        model.addAttribute("money",customerService.selectMoneyinfor(cid));

        return "/page/table/toUpdate";
    }
    //修改
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(Customer customer, Moneyinfor moneyinfor){
        String i="0";
        try{
            moneyinforMapper.updateById(moneyinfor);
            /* moneyinforService.saveOrUpdate(moneyinfor);*/
            customerService.saveOrUpdate(customer);
        }catch (Exception e){
            i="1";
        }

        return i;
    }
    @ResponseBody
    @RequestMapping("/selectCount.do")
    public String selectCount(String type){
        return   customerService.selectCount(type);
    }

    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectById.do")
    public String selectById(String cid,Model model){
        List<String> list=customerService.select(cid);
      model.addAttribute("cus",list);
        return "/projectPage/customerManager/myBussinessOpposhu";
    }


    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/select1.do")
    @ResponseBody
    public LayuiData select1(String[] bid,Model model){
       List<Businessoppo> list=customerService.select1(bid);
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list.size())));
        layUiData.setData(list);
        return layUiData;
    }

    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectById1.do")
    public String selectById1(String cid,Model model){
        List<String> list1=customerService.selectBy(cid);
        model.addAttribute("list1",list1);
        return "/projectPage/customerManager/myContractshu";
    }

    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/select2.do")
    @ResponseBody
    public LayuiData select2(String[] cid,Model model){
        List<Contract> list=customerService.select2(cid);
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list.size())));
        layUiData.setData(list);
        return layUiData;
    }
    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectById2.do")
    public String selectById2(String cid,Model model){
        List<String> list1=customerService.selectBy1(cid);
        model.addAttribute("list1",list1);
        return "/projectPage/customerManager/afterSellshu";
    }
    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/select3.do")
    @ResponseBody
    public LayuiData select3(String[] aid,Model model){
        List<AftersellShu> list=customerService.select3(aid);
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list.size())));
        layUiData.setData(list);
        return layUiData;
    }


}
