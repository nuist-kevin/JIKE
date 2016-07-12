package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 119139322924645585L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private UserService userService = new UserService();

	@Override
	public String execute() throws Exception {
		User user = userService.getUserByUsername(username);
		if (user == null || !password.equals(user.getPassword())) {
			return ERROR;
		} else if ("admin".equals(username)) {
			return "list";
		} else {
			return SUCCESS;
		}
	}

}
