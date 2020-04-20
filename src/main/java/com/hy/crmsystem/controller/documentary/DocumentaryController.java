package com.hy.crmsystem.controller.documentary;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.entity.afterSell.ThemeBo;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.documentary.Documentary;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.documentary.DocumentaryMapper;
import com.hy.crmsystem.service.documentary.IDocumentaryService;
import com.hy.crmsystem.service.documentary.impl.DocumentaryServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/documentary")
public class DocumentaryController {
    @Autowired
    private IDocumentaryService documentaryService;
    @Autowired
    private DocumentaryMapper documentaryMapper;


    @RequestMapping(value = "/queryAll.do")
    @ResponseBody
    public LayuiData queryAll(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit" ,defaultValue = "3")Integer limit, Documentary documentary, HttpSession session){

        IPage list1=documentaryService.pages(page,limit,documentary,session);
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(Integer.parseInt(String.valueOf(list1.getTotal())));
        layUiData.setData(list1.getRecords());

       List<Documentary> list=documentaryService.listQueryAll(documentary);
        session.setAttribute("list",list);
        return layUiData;
    }
/*    @RequestMapping("/add.do")
        public String add( Model model,HttpSession session){
            String user = (String) SecurityUtils.getSubject().getPrincipal();
             session.setAttribute("user",user);
          return "/projectPage/documentary/addDocumentary";
        }*/

    /*查询主题*/
    @RequestMapping("/selectBname.do")
    @ResponseBody
    public List<Businessoppo> selectBname(){
        return documentaryService.selectBname();
    }
    /*查询主题*/
    @RequestMapping("/selectTheme.do")
    @ResponseBody
    public LayuiData selectTheme(Documentary documentary,String theme){
        List<Documentary> list=  documentaryService.selectTheme(theme);
        LayuiData layUiData=new LayuiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(list.size());
        layUiData.setData(list);
        return layUiData;
    }
    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert_emp(Documentary documentary){
        String i="0";
        documentaryMapper.insert(documentary);
        return i;

    }

}
