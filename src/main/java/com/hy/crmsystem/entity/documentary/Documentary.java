package com.hy.crmsystem.entity.documentary;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer did;

    private Integer cid;

    private Integer bid;

    @TableField("documentary_time")
    private java.sql.Date documentaryTime;

    @TableField("documentary_class")
    private String documentaryClass;

    @TableField("documentary_people")
    private String documentaryPeople;

    private String detail;

    private String file;

    private Integer theme;

    private Integer status;

    @TableField("user_name")
    private String username;

    private Integer uid;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDocumentaryTime() {
        return documentaryTime;
    }

    public void setDocumentaryTime(Date documentaryTime) {
        this.documentaryTime = documentaryTime;
    }

    public String getDocumentaryClass() {
        return documentaryClass;
    }

    public void setDocumentaryClass(String documentaryClass) {
        this.documentaryClass = documentaryClass;
    }

    public String getDocumentaryPeople() {
        return documentaryPeople;
    }

    public void setDocumentaryPeople(String documentaryPeople) {
        this.documentaryPeople = documentaryPeople;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Documentary{" +
                "id=" + id +
                ", did=" + did +
                ", cid=" + cid +
                ", bid=" + bid +
                ", documentaryTime=" + documentaryTime +
                ", documentaryClass='" + documentaryClass + '\'' +
                ", documentaryPeople='" + documentaryPeople + '\'' +
                ", detail='" + detail + '\'' +
                ", file='" + file + '\'' +
                ", theme=" + theme +
                ", status=" + status +
                ", username='" + username + '\'' +
                ", uid=" + uid +
                '}';
    }
}
