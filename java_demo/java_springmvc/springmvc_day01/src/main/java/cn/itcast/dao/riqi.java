package cn.itcast.dao;

import java.io.Serializable;
import java.util.Date;

public class riqi implements Serializable {
    private String name;
    private Integer age;
    private Date date;

    @Override
    public String toString() {
        return "riqi{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
