package com.hy.crmsystem.entity.systemManager;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    //帖子id
    private Integer id;

    private Integer uid;

    @TableField("article_tag")
    private String articleTag;

    @TableField("of_bid")
    private Integer ofBid;

    private String title;

    private Integer counts;

    //回复ID
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    //评论人
    private String sid;

    //被评论人
    private String bsid;

    private String text;

    private Date stime;

    @TableField("article_text")
    private String articleText;

    @TableField("send_time")
    private Date sendTime;

    @TableField("file")
    private String fileName;

    @TableField("click_count")
    private int clickCount;

    @TableField("user_name")
    private String username;

    private String bname;

    @TableField("reply_time")
    private Date replyTime;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getBsid() {
        return bsid;
    }

    public void setBsid(String bsid) {
        this.bsid = bsid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }

    public Integer getOfBid() {
        return ofBid;
    }

    public void setOfBid(Integer ofBid) {
        this.ofBid = ofBid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", uid=" + uid +
                ", articleTag='" + articleTag + '\'' +
                ", ofBid=" + ofBid +
                ", title='" + title + '\'' +
                ", counts=" + counts +
                ", tid=" + tid +
                ", sid='" + sid + '\'' +
                ", bsid='" + bsid + '\'' +
                ", text='" + text + '\'' +
                ", stime=" + stime +
                ", articleText='" + articleText + '\'' +
                ", sendTime=" + sendTime +
                ", fileName='" + fileName + '\'' +
                ", clickCount=" + clickCount +
                ", username='" + username + '\'' +
                ", bname='" + bname + '\'' +
                ", replyTime=" + replyTime +
                ", count=" + count +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
