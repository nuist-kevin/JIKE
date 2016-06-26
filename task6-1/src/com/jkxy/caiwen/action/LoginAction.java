package com.jkxy.caiwen.action;

import com.jkxy.caiwen.model.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by caiwen on 2016/6/26.
 */
public class LoginAction extends ActionSupport {
    private User user ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        if (user == null) {
            return INPUT;
        }
        else if ("蔡文".equals(getUser().getUsername()) && "123456".equals(getUser().getPassword())) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
