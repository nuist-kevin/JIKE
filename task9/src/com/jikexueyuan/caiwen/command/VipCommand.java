package com.jikexueyuan.caiwen.command;

/**
 * Created by caiwen on 2016/7/24.
 */
//@Embeddable
public class VipCommand {
    private Integer vipId;
    private String name;

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
