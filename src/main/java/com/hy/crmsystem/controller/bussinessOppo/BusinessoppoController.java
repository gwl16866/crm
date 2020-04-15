package com.hy.crmsystem.controller.bussinessOppo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.customerManager.Moneyinfor;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.mapper.bussinessOppo.BusinessoppoMapper;
import com.hy.crmsystem.mapper.customerManager.CustomerMapper;
import com.hy.crmsystem.service.bussinessOppo.IBusinessoppoService;
import com.hy.crmsystem.service.customerManager.ICustomerService;
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
@RequestMapping("/bussinessOppo")
public class BusinessoppoController {
    @Autowired
private IBusinessoppoService businessoppoService;
 @Autowired
    private BusinessoppoMapper businessoppoMapper;

    @Autowired
    private  ICustomerService customerService;

    @RequestMapping(value = "/queryAll.do")
    @ResponseBody
    public LayuiData query(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit" ,defaultValue = "3")Integer limit, Businessoppo businessoppo, HttpSession session){

        IPage list1=businessoppoService.pages(page,limit,businessoppo,session);
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list1.getTotal())));
        layUiData.setData(list1.getRecords());

        List<Businessoppo> list=businessoppoService.listQueryAll(businessoppo);
        session.setAttribute("list",list);
        return layUiData;
    }
    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert_emp(Customer customer, Businessoppo businessoppo){
        System.out.println(customer);
        System.out.println(businessoppo.getBname()+businessoppo.getBemail()+businessoppo.getBjob()+businessoppo.getBattention()+businessoppo.getBlinkman()+businessoppo.getBofDept()+businessoppo.getBphoneno()+businessoppo.getBpredictMoney());
        String i="0";
        Integer bid=businessoppoMapper.insert(businessoppo);
        customer.setCid(bid);
        customerService.save(customer);
        return i;

    }
    //根据 id 查信息进行展示 以 修改
    @RequestMapping("/selectEmpById.do")
    public String selectEmpById(Integer bid, Model model){
        System.out.println(bid);
        model.addAttribute("bus",businessoppoService.selectByName(String.valueOf(bid)));
        model.addAttribute("cust",businessoppoService.selectBusinessoppo(String.valueOf(bid)));
        return "/projectPage/bussinessOppo/toUpdate";
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public String update(Customer customer, Businessoppo businessoppo){
        String i="0";
        /*try{*/
            businessoppoService.updateById(businessoppo);
            customerService.saveOrUpdate(customer);
       /* }catch (Exception e){
            i="1";
        }*/

        return i;
    }

}
