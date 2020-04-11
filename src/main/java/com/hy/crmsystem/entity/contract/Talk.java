package com.hy.crmsystem.entity.contract;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *回复
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;

    //回复ID
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    //帖子id
    private Integer id;

    //评论人
    private String  sid;

    //被评论人
    private String bsid;

    private String text;

    private Date stime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        return "Talk{" +
        "tid=" + tid +
        ", sid=" + sid +
        ", bsid=" + bsid +
        ", text=" + text +
        ", stime=" + stime +
        "}";
    }
}
