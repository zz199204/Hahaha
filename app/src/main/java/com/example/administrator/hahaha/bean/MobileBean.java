package com.example.administrator.hahaha.bean;

/**
 * Created by Administrator on 2017/4/15.
 */

public class MobileBean {


    /**
     * id : 1
     * name : 苹果
     * pid : 0
     * type : 1
     */

    private int id;
    private String name;
    private String pid;
    private String category;
    private String type;

    @Override
    public String toString() {
        return "MobileBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
