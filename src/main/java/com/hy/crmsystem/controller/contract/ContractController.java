package com.hy.crmsystem.controller.contract;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.service.contract.impl.ContractServiceImpl;
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
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    ContractServiceImpl contractService;

    //主页面——查询所有合同
    @RequestMapping("/selectAllCont.do")
    @ResponseBody
    public LayuiData selectAllCont(Contract contract, Integer condition, @RequestParam(value = "page", required = true, defaultValue = "1") int page, @RequestParam(value = "limit", required = true, defaultValue = "3") int pageSize) {
        //分页
        Page pageHelper = PageHelper.startPage(page, pageSize, true);
        List<Contract> list = contractService.selectAllCont(contract, condition);

        for (Contract c : list) {
            c.setReturnMoney(contractService.selectReturnMoney(c.getCid()));
        }
        System.out.println();
        LayuiData layuiData = new LayuiData();
        layuiData.setCount(list.size());
        layuiData.setData(list);

        return layuiData;
    }

    //查询客户
    @ResponseBody
    @RequestMapping("/selectCustomer.do")
    public Customer selectCustomer(String cname) {
        return contractService.selectCustomer(cname);
    }

    //添加合同
    @ResponseBody
    @RequestMapping("/addContract.do")
    public String addContract(Contract contract, Customer customer) {

        //判断是否存在
        Customer cus = contractService.selectCustomer(customer.getCname());
        if (cus == null) {
            // contractService.save(customer);
        }
        //添加合同
        contractService.save(contract);
        return "1";
    }

    //合同详情
    @RequestMapping("/contractDetails.do")
    public String contractDetails(String contractNum, Model model) {
       Contract contractList= contractService.contractDetails(contractNum);
       model.addAttribute("c",contractList);
        return "projectPage/contract/contractDetails";
    }

}
