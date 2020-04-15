package com.hy.crmsystem.entity.statistics;

import java.math.BigDecimal;

public class TableStatistics {

    private String cname;
    private BigDecimal money;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
