package com.jikexueyuan.caiwen.entity;

/**
 * Created by Wayne on 2016/11/12.
 */
public enum Auth {
    ADMIN("ADMIN"), NORMAL("NORMAL");
    private final String name;
    private Auth(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
