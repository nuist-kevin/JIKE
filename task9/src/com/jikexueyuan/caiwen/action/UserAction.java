package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.command.UserCommand;
import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.service.impl.jpa.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by caiwen on 2016/7/21.
 */
public class UserAction extends ActionSupport {

    private UserCommand userCommand;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private User user;
    private List<User> users;

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
                ActionContext context = ActionContext.getContext();
                context.getSession().put("username", user.getUsername());
                if (userService.isAdmin(user)) {
                    //如果是管理员进入系统维护页面
                    context.getSession().put("loginRole","admin");
                    return "maintain";
                } else {
                    //非管理员进入帮助页面
                    context.getSession().put("loginRole","normal");
                    //TODO 编写帮助页
                    return SUCCESS;
                }
            } else {
                //无权限返回
                addFieldError("username", "暂无权限，请联系管理员");
                return ERROR;
            }
        } else {
            //密码不匹配返回
            addFieldError("username", "用户名或密码错误");
            return ERROR;
        }
    }

    public String help() throws  Exception {
        return SUCCESS;
    }
    public String view() throws  Exception {
        setUser(userService.getByUsername(username));
        return SUCCESS;
    }

    public String editView() throws  Exception {
        setUser(userService.getByUsername(username));
        return SUCCESS;
    }

    public String doEdit() throws  Exception {
        user.setUsername(username);
        userService.save(user);
        return SUCCESS;
    }

    public String list() throws  Exception {
        users = userService.findAll();
        return SUCCESS;
    }

    public String delete() throws  Exception {
        userService.delete(username);
        return SUCCESS;
    }

    public String addView() throws  Exception {
        return SUCCESS;
    }
    public String doAdd() throws  Exception {
        userService.save(user);
        return SUCCESS;
    }
}
