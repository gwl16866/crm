package com.hy.crmsystem.entity.customerManager;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Moneyinfor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    private String mcarno;

    private String mname;

    private String mbank;

    /**
     * ˰
     */
    private String mdutyno;

    private String mphoneno;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
    public String getMcarno() {
        return mcarno;
    }

    public void setMcarno(String mcarno) {
        this.mcarno = mcarno;
    }
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
    public String getMbank() {
        return mbank;
    }

    public void setMbank(String mbank) {
        this.mbank = mbank;
    }
    public String getMdutyno() {
        return mdutyno;
    }

    public void setMdutyno(String mdutyno) {
        this.mdutyno = mdutyno;
    }
    public String getMphoneno() {
        return mphoneno;
    }

    public void setMphoneno(String mphoneno) {
        this.mphoneno = mphoneno;
    }

    @Override
    public String toString() {
        return "Moneyinfor{" +
        "mid=" + mid +
        ", mcarno=" + mcarno +
        ", mname=" + mname +
        ", mbank=" + mbank +
        ", mdutyno=" + mdutyno +
        ", mphoneno=" + mphoneno +
        "}";
    }
}
