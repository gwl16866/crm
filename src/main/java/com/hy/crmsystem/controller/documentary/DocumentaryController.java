package com.hy.crmsystem.controller.documentary;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.documentary.Documentary;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.service.documentary.IDocumentaryService;
import com.hy.crmsystem.service.documentary.impl.DocumentaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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



}
