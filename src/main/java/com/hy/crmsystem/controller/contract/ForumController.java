package com.hy.crmsystem.controller.contract;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.contract.Article;
import com.hy.crmsystem.entity.contract.Talk;
import com.hy.crmsystem.entity.contract.Upload;
import com.hy.crmsystem.entity.systemManager.Forum;
import com.hy.crmsystem.entity.systemManager.LayuiData;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.service.contract.impl.ForumServiceImpl;
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

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumServiceImpl forumService;

    //主页面——查询所有
    @RequestMapping("/selectForum.do")
    @ResponseBody
    public LayuiData selectForum(Article article,String modules,String keyword) {
        List<Article> list = forumService.selectForum(article,modules,keyword);
        for (Article a:list){
            a.setCount(forumService.selectCountReply(a.getId()));
        }
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(list.size());
        layuiData.setMsg("");
        layuiData.setData(list);

        return layuiData;
    }

    //添加页面——添加帖子
    @ResponseBody
    @RequestMapping("/addForum.do")
    public String addForum(Article article) {
            forumService.addForum(article);

        return "1";
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

    //添加页面——查询商机
    @ResponseBody
    @RequestMapping("/selectBussiness.do")
    public List<Businessoppo> selectBussiness() {
        return forumService.selectBussiness();
    }

    //帖子详情——查询所有回复
    @RequestMapping("/selectTalk.do")
    public String selectTalk(int id, Model model) {
        List<Forum> list = forumService.selectTalk(id);
        Article oneForum = forumService.selectOneForum(id);
        Integer counts = forumService.selectCountReply(id);
        model.addAttribute("of", oneForum);
        model.addAttribute("list", list);
        model.addAttribute("counts",counts);
        return "projectPage/systemManager/forumDetails";
    }

    //查询名字
    @ResponseBody
    @RequestMapping("/selectUserName.do")
    public User selectUserName(Integer uid) {
        return forumService.selectUserName(uid);
    }

    //添加回复
    @ResponseBody
    @RequestMapping("/addReply.do")
    public String addReply(Talk talk,Integer id) {
        try {
            forumService.addReply(talk);
            forumService.updateReplyTime(id);
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }

    //删除帖子
    @RequestMapping("/deleteReply.do")
    public String deleteReply(Integer id){
            forumService.deleteReply(id);
        return "/projectPage/systemManager/forum";
    }

    //回复 回复
    @ResponseBody
    @RequestMapping("/replyReply.do")
    public String replyReply(Talk talk) {
        try {
            forumService.replyReply(talk);
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }
}