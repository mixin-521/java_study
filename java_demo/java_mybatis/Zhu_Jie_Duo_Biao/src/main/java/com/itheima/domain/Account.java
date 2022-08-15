package com.itheima.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer aid;
    private Integer uid;
    private Double money;
    //多对一(mybatis中称之为一对一) 的映射: 一个账号只能属于一个用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
