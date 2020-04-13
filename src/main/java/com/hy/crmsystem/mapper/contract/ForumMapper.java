package com.hy.crmsystem.mapper.contract;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.controller.contract.ForumDao;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.contract.Article;
import com.hy.crmsystem.entity.contract.Talk;
import com.hy.crmsystem.entity.systemManager.Forum;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ForumMapper extends BaseMapper<Article> {

    //查询所有商机
    @SelectProvider(type = ForumDao.class, method = "selectForum")
    public List<Article> selectForum(Article article,@Param("modules") String modules,@Param("keyword")String keyword);

    //查询回复时间
    @Select("select max(t.stime),count(t.id) counts,a.id from article a ,talk t where a.id=t.id group by a.id having a.id=#{value}")
    public List<Article> selectTalkTime(Article article);

    //添加帖子查询所属商机
    @Select("select * from businessoppo")
    public List<Businessoppo> selectBussiness();

    //添加帖子
    @Insert("insert into article(uid,title,article_text,file,click_count,of_bid,send_time) values(#{uid},#{title},#{articleText},#{fileName},0,#{ofBid},now())")
    public void addForum(Article article);

    //帖子详情——查询所有回复
    @Select("select a.*,t.* from article a left join talk t on a.id=t.id where a.id=#{id}")
    public List<Forum> selectTalk(int id);

    @Select("select * from user where uid=#{uid}")
     public User selectUserName(Integer uid);

    @Select("select a.*,u.user_name from article a,user u where a.uid=u.uid and a.id=#{id}")
    public Article selectOneForum(Integer id);

    //查询回复数
    @Select("select count(id) from talk where id=#{id}")
    public Integer selectCountReply(Integer id);

    //添加回复
    @Insert("insert into talk(id,sid,bsid,text,stime) values(#{id},#{sid},#{bsid},#{text},now())")
    public void addReply(Talk talk);

    //添加回复时修改回复时间
    @Update("update article set reply_time=now() where id=#{id}")
    public void updateReplyTime(Integer id);

    //删除帖子
    @Delete("delete from article where id=#{id}")
    public void deleteReply(Integer id);

    //回复 回复
    @Insert("")
    public void replyReply(Talk talk);
}
