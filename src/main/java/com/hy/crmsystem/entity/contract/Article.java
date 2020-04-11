package com.hy.crmsystem.entity.contract;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Article implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    private Integer count;

    @TableField("article_tag")
    private String articleTag;

    @TableField("of_bid")
    private Integer ofBid;

    private String title;

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

    private Date stime;

    @TableField("reply_time")
    private Date replyTime;

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
        return "Article{" +
                "uid=" + uid +
                ", articleTag='" + articleTag + '\'' +
                ", ofBid=" + ofBid +
                ", title='" + title + '\'' +
                ", articleText='" + articleText + '\'' +
                ", sendTime=" + sendTime +
                ", fileName='" + fileName + '\'' +
                ", clickCount=" + clickCount +
                '}';
    }
}
