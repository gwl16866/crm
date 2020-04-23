package com.hy.crmsystem.controller.afterSell;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.afterSell.AfterSellBoTwo;
import com.hy.crmsystem.entity.afterSell.AfterSellThree;
import com.hy.crmsystem.entity.afterSell.AftersellBo;
import com.hy.crmsystem.entity.afterSell.ThemeBo;
import com.hy.crmsystem.entity.contract.Contract;
import com.hy.crmsystem.entity.contract.Upload;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.documentary.Theme;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.service.afterSell.impl.AftersellServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Controller
@RequestMapping("/afterSell")
public class AftersellController {
    @Autowired
    private AftersellServiceImpl aftersellService;

    @ResponseBody
    @RequestMapping("afterSell.do")
    public LayuiData afterSell(AftersellBo aftersellBo,@RequestParam(value = "types" ,required = false,defaultValue = "0")int types,
                               @RequestParam(value = "page" ,required = true,defaultValue = "1") int page
                             , @RequestParam(value = "limit",required = true,defaultValue = "3") int pageSize){
        Page<AftersellBo> ip=new Page(page,pageSize);
        IPage<AftersellBo> empList=aftersellService.selectAftersellBo(ip,aftersellBo,types);

        LayuiData layUiData=new LayuiData();
        layUiData.setCount(Integer.parseInt(String.valueOf(empList.getTotal())));
        layUiData.setData(empList.getRecords());
     return layUiData;
    }

    /*查询主题*/
    @ResponseBody
    @RequestMapping("selectTheme.do")
    public List<ThemeBo> selectTheme(){
        return aftersellService.selectTheme();
    }

    /**
     * 查询user
     * @return
     */
    @ResponseBody
    @RequestMapping("selectUser.do")
    public List selectUser(){
        return aftersellService.selectUser();
    }

    /**
     * 查询合同
     * @return
     */
    @ResponseBody
    @RequestMapping("selectContract.do")
    public List selectContract(){
        return aftersellService.selectContract();
    }

    /**
     * 查询合同by id
     * @return
     */
    @ResponseBody
    @RequestMapping("selectContractByCustomerId.do")
    public List selectContractByCustomerId(int customerId){
        return aftersellService.selectContractByCustomerId(customerId);
    }


    @ResponseBody
    @RequestMapping("selectContractNumByCustomerId.do")
    public Contract selectContractNumByCustomerId(int cid){
        return aftersellService.selectContractNumByCustomerId(cid);
    }

    /**
     * 查询客户
     * @return
     */
    @ResponseBody
    @RequestMapping("selectCustomer.do")
    public List selectCustomer(){
        return aftersellService.selectCustomer();
    }

    /**
     * 查询客户byid
     * @return
     */
    @ResponseBody
    @RequestMapping("selectCustomerById.do")
    public List selectCustomerById(int cid){
        return aftersellService.selectCustomerById(cid);
    }


    /**
     * insert
     * @param afterSellBoTwo
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert.do")
    public String insert(AfterSellBoTwo afterSellBoTwo){
        System.out.println(afterSellBoTwo);
        String cid = afterSellBoTwo.getCid();
        //根据合同id查询num
        String num = aftersellService.selectNumByCid(Integer.valueOf(cid));
        //根据客户id查询姓名
        List<Customer> customer = aftersellService.selectCustomerById(afterSellBoTwo.getCustomerId());

        String themeName = customer.get(0).getCname()+num;

        Integer count = aftersellService.selectThemeExist(themeName);
        if(count == 0){
            Theme t=new Theme();
            t.setTheme(themeName);
            t.setCid(Integer.valueOf(afterSellBoTwo.getCid()));
            aftersellService.saveTheme(t);
        }
            afterSellBoTwo.setThemeNo(Integer.valueOf(aftersellService.selectMaxId()));
            System.out.println(afterSellBoTwo);
            aftersellService.saveAfterSell(afterSellBoTwo);

        return "0";
    }

    //添加页面——上传文件
    @ResponseBody
    @RequestMapping(value = "/uploadFile.do")
    public Upload uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        // 设置名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = file.getOriginalFilename();
        // 获取后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        try {
            //获取根路径
            String req = request.getSession().getServletContext().getRealPath("/");
            System.out.println("---"+req);
            // 开始上传
            file.transferTo(new File(req + "/imgs/" + picName + extName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Upload up = new Upload();
        up.setCode("0");
        up.setFilename(picName + extName);
        return up;
    }

    /**
     * 根据售后id查询
     */
    @RequestMapping("/selectOneAfterSell.do")
    public String selectOneAfterSell(Integer aid, Model model){
        AfterSellThree afterSellThree=aftersellService.selectAfterSell(aid);
        model.addAttribute("a",afterSellThree);
        System.out.println(afterSellThree);
        return "/projectPage/afterSell/showAfterSell";
    }

    /**
     * 查询未处理条数
     */

    @ResponseBody
    @RequestMapping("/selectCount.do")
    public String selectCount(String type){
        return   aftersellService.selectCount(type);
    }

    @ResponseBody
    @RequestMapping("/selectNewCount.do")
    public Integer selectNewCount(String type){
        return  aftersellService.selectNewCount(type);
    }


    @RequestMapping("/updateStatus.do")
    @ResponseBody
    public String updateStatus(String type,String aid){
        try {
            aftersellService.upDateStatus(type,aid);

        }catch (Exception e){
            return "1";
        }
        return "0";
    }



}
