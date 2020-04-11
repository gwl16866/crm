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
public class Rolepermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer rid;

    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Rolepermission{" +
        "rid=" + rid +
        ", pid=" + pid +
        "}";
    }
}
