package com.hy.crmsystem.entity.systemManager;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    private Integer rid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Userrole{" +
        "uid=" + uid +
        ", rid=" + rid +
        "}";
    }
}
