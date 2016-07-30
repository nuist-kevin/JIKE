package com.jikexueyuan.caiwen.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vip implements Serializable{

    private Integer id;
    private String name;
    private Integer age;
    private String profession;
    private Date joinTime;
    @Id
    @Column(name = "VIPID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    @Temporal(value = TemporalType.DATE)
    @JSON(format = "yyyy-MM-dd")
    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
