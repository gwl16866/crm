package com.hy.crmsystem.service.contract.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.contract.Article;
import com.hy.crmsystem.entity.contract.Talk;
import com.hy.crmsystem.entity.systemManager.Forum;
import com.hy.crmsystem.entity.systemManager.User;
import com.hy.crmsystem.mapper.contract.ForumMapper;
import com.hy.crmsystem.mapper.systemManager.LoginMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Article> {

    @Autowired
    private ForumMapper forumMapper;
    @Autowired
    private LoginMapper loginMapper;

    //查询所有帖子
    public List<Article> selectForum(Article article,String modules,String keyword) {
        return forumMapper.selectForum(article,modules,keyword);
    }

    //添加帖子——所属商机
    public List<Businessoppo> selectBussiness() {
        return forumMapper.selectBussiness();
    }

    //添加帖子
    public void addForum(Article article) {
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        User u = loginMapper.selectUser(name);
        article.setUid(u.getUid());
        forumMapper.addForum(article);
    }

    //帖子详情——查询所有回复
    public List<Forum> selectTalk(int id) {
        return forumMapper.selectTalk(id);
    }

    //根据用户ID查名字
    public User selectUserName(Integer uid) {
        return forumMapper.selectUserName(uid);
    }

    public Article selectOneForum(Integer id){
        return forumMapper.selectOneForum(id);
    }

    //查询回复数
    public Integer selectCountReply(Integer id){
        return forumMapper.selectCountReply(id);
    }

    //添加回复
    public void addReply(Talk talk) {
        //获取当前登录人姓名
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        talk.setSid(name);
        forumMapper.addReply(talk);
    }

    //删除帖子
    public void deleteReply(Integer id) {
        forumMapper.deleteReply(id);
    }

    //回复 回复
    public void replyReply(Talk talk){
        forumMapper.replyReply(talk);
    }

    //添加回复时修改回复时间
    public void updateReplyTime(Integer id){
        forumMapper.updateReplyTime(id);
    };
}
