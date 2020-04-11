package com.hy.crmsystem.entity.afterSell;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class AftersellBo implements Serializable {

    private String theme;

    private Integer status;

    @TableField("service_type")
    private String serviceType;

    private String starttime;

    @TableField("service_people")
    private String servicePeople;

    @TableField("service_score")
    private String serviceScore;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getServicePeople() {
        return servicePeople;
    }

    public void setServicePeople(String servicePeople) {
        this.servicePeople = servicePeople;
    }

    public String getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(String serviceScore) {
        this.serviceScore = serviceScore;
    }

    @Override
    public String toString() {
        return "AftersellBo{" +
                "theme='" + theme + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", starttime='" + starttime + '\'' +
                ", servicePeople='" + servicePeople + '\'' +
                ", serviceScore='" + serviceScore + '\'' +
                '}';
    }
}
