package com.jikexueyuan.caiwen.action;

import java.util.List;

import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport {

	private List<User> users;
	private User user;
	private UserService userService = new UserService();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private static final long serialVersionUID = -77981250535684115L;

	public String add() throws Exception {
		userService.create(getUser());
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		userService.delete(getUser().getId());
		return SUCCESS;

	}

	public String view() throws Exception {
		setUser(userService.get(getUser().getId()));
		return SUCCESS;
	}
}
