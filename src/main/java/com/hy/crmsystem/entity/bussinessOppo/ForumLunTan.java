package com.hy.crmsystem.entity.bussinessOppo;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

public class ForumLunTan implements Serializable {

    private static final long serialVersionUID = 1L;
    //帖子id
    private Integer id;
    private Integer uid;
    private Integer ofBid;
    private String title;
    private Date stime;
@TableField("article_text")
    private String articleText;
@TableField("send_time")
    private Date sendTime;
@TableField("file_name")
    private String fileName;
  @TableField("click_count")
    private int clickCount;
   @TableField("user_name")
    private String username;

    private String bname;

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
        return "ForumLunTan{" +
                "id=" + id +
                ", uid=" + uid +
                ", ofBid=" + ofBid +
                ", title='" + title + '\'' +
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
