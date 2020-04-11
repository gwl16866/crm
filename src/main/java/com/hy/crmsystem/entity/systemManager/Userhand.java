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
public class Userhand implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    private Integer pid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Userhand{" +
        "uid=" + uid +
        ", pid=" + pid +
        "}";
    }
}
