package com.jikexueyuan.caiwen.action;

import java.util.List;

import com.jikexueyuan.caiwen.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private static final long serialVersionUID = -77981250535684115L;

	public String doAdd() throws Exception {
		// TODO Auto-generated method stub
		
		
		return SUCCESS;

	}
	
	public String doDelete() throws Exception {
		// TODO Auto-generated method stub
		
		
		return SUCCESS;

	}
}
