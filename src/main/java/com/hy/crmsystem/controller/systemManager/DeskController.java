package com.hy.crmsystem.controller.systemManager;

import com.hy.crmsystem.entity.systemManager.DeskPojo;
import com.hy.crmsystem.entity.systemManager.FourNum;
import com.hy.crmsystem.entity.systemManager.FourObject;
import com.hy.crmsystem.service.systemManager.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/desk")
@Controller
public class DeskController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/selectUserCounts.do")
    public String selectUserCounts() {
        return  userService.selectUserCounts().toString();
    }

    @ResponseBody
    @RequestMapping("/selectBussCounts.do")
    public String selectBussCounts() {
        return  userService.selectBussCounts().toString();
    }

    @ResponseBody
    @RequestMapping("/selectContractCounts.do")
    public String selectContractCounts() {
        return  userService.selectContractCounts().toString();
    }

    @ResponseBody
    @RequestMapping("/selectReturnMoney.do")
    public String selectReturnMoney() {
        return  userService.selectRetrurnMoney();
    }

    @ResponseBody
    @RequestMapping("/selectFour.do")
    public FourObject selectFour() {

        //userService.selectSumUsers();
        //userService.selectSumCustomer();
        FourObject fo = new FourObject();

        fo.setMoney(userService.selectMoneyByMonth());
        fo.setUsers(userService.selectSumUsers());
        fo.setCustomers(userService.selectSumCustomer());
        fo.setBussiness(userService.selectBussinessCounts());
        fo.setContracts(userService.selectContractCountsByMonth());

        return fo;
    }

    @ResponseBody
    @RequestMapping("/selectFourNum.do")
    public FourNum selectFourNum() {
        FourNum fn = new FourNum();
        fn.setBussiness(String.valueOf(userService.selectBussCounts()));
        fn.setContracts(String.valueOf(userService.selectContractCounts()));
        fn.setCustomers(String.valueOf(userService.selectCustomerCounts()));
        fn.setUsers(String.valueOf(userService.selectUserCounts()));

        return fn;
    }





}
