package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.command.UserCommand;
import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 119139322924645585L;

    private UserCommand userCommand;
	private User user;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCommand getUserCommand() {
		return userCommand;
	}

	public void setUserCommand(UserCommand userCommand) {
		this.userCommand = userCommand;
	}

	private UserService userService = new UserService();

	@Override
	public String execute() throws Exception {
		setUser(userService.getUserByUsername(getUserCommand().getUsername()));
		if (getUser() == null || !getUser().getPassword().equals(getUserCommand().getPassword())) {
			addFieldError("username", "用户名或密码错误");
			return INPUT;
		} else {
			ActionContext context = ActionContext.getContext();
			context.getSession().put("userId",getUser().getId());
			context.getSession().put("userName",getUser().getUsername());
			if ("admin".equals(getUserCommand().getUsername())) {
				context.getSession().put("loginRole","admin");
				return "list";
		} else {
				context.getSession().put("loginRole","normal");
				return SUCCESS;
		}}
	}

	public String register() throws Exception {
		Integer id = userService.create(getUser());
		setUser(userService.get(id));
		ActionContext context = ActionContext.getContext();
		context.getSession().put("userId",getUser().getId());
		context.getSession().put("userName",getUser().getUsername());
		context.getSession().put("loginRole","normal");
		return SUCCESS;
	}

	public String logout() throws Exception {
		ActionContext context = ActionContext.getContext();
		context.getSession().remove("userId");
		context.getSession().remove("userName");
		context.getSession().remove("loginRole");
		return SUCCESS;
	}

}
