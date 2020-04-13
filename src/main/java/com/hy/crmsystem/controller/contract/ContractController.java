package com.hy.crmsystem.controller.contract;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.service.contract.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        List<Contract> list = contractService.selectAllCont(contract,condition);

        LayuiData layuiData = new LayuiData();
        layuiData.setCount(list.size());
        layuiData.setData(list);

        return layuiData;
    }
}
