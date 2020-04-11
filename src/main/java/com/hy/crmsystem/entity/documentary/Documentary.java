package com.hy.crmsystem.entity.documentary;


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
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer did;

    private Integer cid;

    private Integer bid;

    @TableField("documentary_time")
    private Date documentaryTime;

    @TableField("documentary_class")
    private String documentaryClass;

    @TableField("documentary_people")
    private String documentaryPeople;

    private String detail;

    private String file;

    private Integer theme;

    private Integer status;

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

    @Override
    public String toString() {
        return "Documentary{" +
        "did=" + did +
        ", cid=" + cid +
        ", bid=" + bid +
        ", documentary_time=" + documentaryTime +
        ", documentary_class=" + documentaryClass +
        ", documentary_people=" + documentaryPeople +
        ", detail=" + detail +
        ", file=" + file +
        ", theme=" + theme +
        ", status=" + status +
        "}";
    }
}
