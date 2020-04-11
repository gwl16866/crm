package com.hy.crmsystem.entity.afterSell;

import java.util.List;

public class JsonData {
    private String msg;
    private Integer count;
    private List<AftersellBo> data;
    private Integer code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<AftersellBo> getData() {
        return data;
    }

    public void setData(List<AftersellBo> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
