package com.hy.crmsystem.entity.customerManager;

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
public class AftersellShu implements Serializable {



    private String theme;

    @TableField("service_type")
    private String serviceType;

    private Date starttime;



    @TableField("service_people")
    private String servicePeople;

    @TableField("service_score")
    private Integer serviceScore;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getServicePeople() {
        return servicePeople;
    }

    public void setServicePeople(String servicePeople) {
        this.servicePeople = servicePeople;
    }

    public Integer getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }
}
