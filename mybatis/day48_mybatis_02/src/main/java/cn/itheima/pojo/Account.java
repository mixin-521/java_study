package cn.itheima.pojo;

/**
 * 包名:com.itheima.pojo
 * 作者:Leevi
 * 日期2019-11-11  08:49
 */
public class Account {
    private Integer aid;
    private Double money;
    private Integer uid;

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", money=" + money +
                ", uid=" + uid +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
