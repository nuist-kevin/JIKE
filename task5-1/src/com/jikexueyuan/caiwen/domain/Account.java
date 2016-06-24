package com.jikexueyuan.caiwen.domain;

public class Account {
	private String accountNo;
	private double balance;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//加同步锁的取钱操作
	public synchronized void draw(double mount) {
		if (balance >= mount) {
			balance -= mount;
			System.out.println(Thread.currentThread().getName() + "_取钱" + mount + "成功，现在余额为 " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "_取钱" + mount + "失败，余额仅有" + balance);
		}

	}
	//加同步锁的存钱操作
	public synchronized void deposit(double mount) {
		System.out.println();
		balance += mount;
		System.out.println(Thread.currentThread().getName() + "_存钱"+ mount + "成功，现在余额为：" + balance);

	}
}
