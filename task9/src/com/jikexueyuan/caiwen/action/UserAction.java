package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.command.UserCommand;
import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.service.impl.jpa.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by caiwen on 2016/7/21.
 */
public class UserAction extends ActionSupport {

    private UserCommand userCommand;
    private User user;
    private UserService userService;

    public UserCommand getUserCommand() {
        return userCommand;
    }

    public void setUserCommand(UserCommand userCommand) {
        this.userCommand = userCommand;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {
        //首先校验用户名密码，成功才能登录
        if (userService.validateUser(userCommand)) {
            //密码校验通过，检查是否有权限
            user = userService.getByUsername(userCommand.getUsername());
            if (userService.isAuthorised(user)) {
                if (userService.isAdmin(user)) {
                    //如果是管理员进入系统维护页面
                    //TODO 编写维护页
                    return "maintain";
                } else {
                    //非管理员进入帮助页面
                    //TODO 编写帮助页
                    return SUCCESS;
                }
            } else {
                //无权限返回
                //TODO 无权限提示
                return ERROR;
            }
        } else {
            //密码不匹配返回
            //TODO 密码不匹配提示
            return ERROR;
        }
    }
}
