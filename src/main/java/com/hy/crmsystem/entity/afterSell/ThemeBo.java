package com.hy.crmsystem.entity.afterSell;

import java.io.Serializable;

public class ThemeBo implements Serializable {

    private Integer id;

    private String theme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
