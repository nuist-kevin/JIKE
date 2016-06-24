package com.jikexueyuan.caiwen.command;

import com.jikexueyuan.caiwen.domain.Account;

/**
 * Description:
 * 账户操作类，封装了操作的账户，操作类型和金额
 */
public class AccountCommand {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Account account;
	private String operation;
	double mount;
	public AccountCommand(int id, Account account, String operation, int mount) {
		this.id = id;
		this.account = account;
		this.operation = operation;
		this.mount = mount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getMount() {
		return mount;
	}
	public void setMount(double mount) {
		this.mount = mount;
	}
	
}
