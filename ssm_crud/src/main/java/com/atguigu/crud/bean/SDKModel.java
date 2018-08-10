package com.atguigu.crud.bean;

public class SDKModel {


    private Integer id;

    private String name;
    private String version ;
    private String timeStamp;
    private Integer downCount;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public SDKModel(Integer id, String name, String version, String timeStamp, Integer downCount, String desc) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.timeStamp = timeStamp;
        this.downCount = downCount;
        this.desc = desc;
    }

}
