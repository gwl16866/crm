package com.hy.crmsystem.controller.contract;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.contract.ContractCust;
import com.hy.crmsystem.entity.contract.Openpaper;
import com.hy.crmsystem.entity.contract.Returnmoneydetails;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.systemManager.Dept;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.service.contract.impl.ContractServiceImpl;
import com.hy.crmsystem.service.contract.impl.OpenpaperServiceImpl;
import com.hy.crmsystem.service.customerManager.impl.CustomerServiceImpl;
import com.hy.crmsystem.service.statistics.impl.ReturnmoneydetailsServiceImpl;
import com.hy.crmsystem.service.systemManager.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ReturnmoneydetailsServiceImpl returnmoneydetailsService;

    @Autowired
    OpenpaperServiceImpl openpaperService;
    @Autowired
    UserServiceImpl userService;

    //主页面——查询所有合同
    @RequestMapping("/selectAllCont.do")
    @ResponseBody
    public LayuiData selectAllCont(Contract contract, Integer condition, Model model, @RequestParam(value = "page", required = true, defaultValue = "1") int page, @RequestParam(value = "limit", required = true, defaultValue = "3") int pageSize) {
        //分页
        Page pageHelper = PageHelper.startPage(page, pageSize, true);
        List<Contract> list = contractService.selectAllCont(contract, condition);
        //查询汇款额，开票额
        for (Contract c : list) {
            c.setReturnMoney(contractService.selectReturnMoney(c.getCid()));
            c.setOpenMoney(contractService.selectOpenMoney(c.getCid()));
        }
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        layuiData.setCount((int) pageHelper.getTotal());
        layuiData.setData(list);

        return layuiData;
    }

    //主页面——查询我的合同
    @RequestMapping("/selectMyCont.do")
    public String selectMyCont(Model model) {
        //查询登录人
        Object name = SecurityUtils.getSubject().getPrincipal();
        User u = userService.selectDengLuRen(name);
        model.addAttribute("uid", u.getUid());
        return "projectPage/contract/myContract";
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
    public String addContract(Contract contract, Customer customer)  {
        //判断客户是否存在
        Customer cus = contractService.selectCustomer(customer.getCname());
        if (cus == null) {
            customerService.save(customer);
        }
        Customer c = customerService.selectMaxCustomer();
        contract.setCustomerId(c.getCid());
        //查询当前登录人ID
        Object name = SecurityUtils.getSubject().getPrincipal();
        User u = userService.selectDengLuRen(name);
        contract.setUid(u.getUid());
        //添加状态
        contract.setContractStatus(1);
        //添加合同
        contractService.save(contract);
        return "1";
    }

   //下载文件
    @ResponseBody
    @RequestMapping("/downloadFile.do")
   private String downloadFileByOutputStream(Contract contract, HttpServletResponse response, HttpServletRequest request)
            throws FileNotFoundException, IOException {
        //2.获取要下载的文件名
        String fileName = contract.getFile();
        //1.获取要下载的文件的绝对路径
        String realPath =request.getSession().getServletContext().getRealPath("/imgs/"+fileName);
        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.setCharacterEncoding("UTF-8"); //设置编码字符
        response.setContentType("application/octet-stream;charset=UTF-8"); //设置下载内容类型
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        //4.获取要下载的文件输入流
        InputStream in = new FileInputStream(realPath);
        int len = 0;
        //5.创建数据缓冲区
        byte[] buffer = new byte[1024];
        //6.通过response对象获取OutputStream流
        OutputStream out = response.getOutputStream();
        //7.将FileInputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
            out.write(buffer,0,len);
        }
        in.close();
        return "";
    }

    //合同详情
    @RequestMapping("/contractDetails.do")
    public String contractDetails(String contractNum, Model model) {
        ContractCust contractList = contractService.contractDetails(contractNum);
        List<Dept> depts = userService.queryDept();
        model.addAttribute("depts", depts);
        model.addAttribute("c", contractList);
        return "projectPage/contract/contractDetails";
    }

    //我的合同详情
    @RequestMapping("/myContractDetails.do")
    public String myContractDetails(String contractNum, Model model) {
        ContractCust contractList = contractService.contractDetails(contractNum);
        List<Dept> depts = userService.queryDept();
        model.addAttribute("depts", depts);
        model.addAttribute("c", contractList);
        return "projectPage/contract/myContractDetails";
    }

    //编辑合同
    @RequestMapping("/updateContract.do")
    public String updateContract(String contractNum, Model model) {
        ContractCust contractList = contractService.contractDetails(contractNum);
        List<Dept> depts = userService.queryDept();
        model.addAttribute("depts", depts);
        model.addAttribute("cont", contractList);
        return "projectPage/contract/updateContract";
    }

    //编辑我的合同
    @RequestMapping("/updateMyContract.do")
    public String updateMyContract(String contractNum, Model model) {
        ContractCust contractList = contractService.contractDetails(contractNum);
        List<Dept> depts = userService.queryDept();
        model.addAttribute("depts", depts);
        model.addAttribute("cont", contractList);
        return "projectPage/contract/updateMyContract";
    }

    //查询部门
    @ResponseBody
    @RequestMapping("/queryDept.do")
    public List<Dept> queryDept() {
        return userService.queryDept();
    }

    //修改合同
    @ResponseBody
    @RequestMapping("/subUpdateContract.do")
    public String subUpdateContract(Contract contract) {
        contractService.updateById(contract);
        return "1";
    }

    //汇款页
    @RequestMapping("/returnMoney.do")
    public String returnMoney(String contractNum, Model model) {
        //查合同id
        ContractCust contract = contractService.contractDetails(contractNum);
        model.addAttribute("cont", contract);
        // 查询对方单位
        Customer customer = customerService.selectByName(String.valueOf(contract.getCustomerId()));
        model.addAttribute("cust", customer);
        return "projectPage/contract/returnMoney";
    }

    //添加汇款
    @ResponseBody
    @RequestMapping("/addReturnMoney.do")
    public String addReturnMoney(Returnmoneydetails returnmoneydetails, ContractCust contractCust) {
        returnmoneydetailsService.save(returnmoneydetails);
        //修改合同未还钱数
        contractService.updateResidueMoney(contractCust);
        //查询合同未还款
        ContractCust cust = contractService.selectRemainMoney(contractCust.getCid());
        if (cust.getRemainMoney().intValue() <= 1) {
            contractService.updateContractStatus(contractCust.getCid());
        }
        return "1";
    }

    //合同编号唯一
    @ResponseBody
    @RequestMapping("/selectContractNum.do")
    public Integer selectContractNum(String contractNum) {

        Contract contract = contractService.selectContractNum(contractNum);
        if (null == contract) {
            return 2;
        } else {
            return 1;
        }
    }

    //开票
    @RequestMapping("/openPaper.do")
    public String openPaper(Model model, String contractNum) {
        //查合同id
        ContractCust contract = contractService.contractDetails(contractNum);
        model.addAttribute("cont", contract);
        // 查询对方单位
        Customer customer = customerService.selectByName(String.valueOf(contract.getCustomerId()));
        model.addAttribute("cust", customer);
        //查询登录人及部门
        Object name = SecurityUtils.getSubject().getPrincipal();
        User user = userService.selectDengLuRen(String.valueOf(name));
        model.addAttribute("user", user);
        model.addAttribute("name", name);
        return "projectPage/contract/openPaper";
    }

    //提交开票
    @ResponseBody
    @RequestMapping("/addOpenPaper.do")
    public String addOpenPaper(Openpaper openpaper) {
        openpaperService.save(openpaper);
        return "1";
    }

    //删除合同
    @ResponseBody
    @RequestMapping("/deleteContract.do")
    public String deleteContract(Integer cid) {
        contractService.deleteContract(cid);
        return "1";
    }
}
