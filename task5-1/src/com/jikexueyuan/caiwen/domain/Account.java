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

	//��ͬ������ȡǮ����
	public synchronized void draw(double mount) {
		if (balance >= mount) {
			balance -= mount;
			System.out.println(Thread.currentThread().getName() + "_ȡǮ" + mount + "�ɹ����������Ϊ " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "_ȡǮ" + mount + "ʧ�ܣ�������" + balance);
		}

	}
	//��ͬ�����Ĵ�Ǯ����
	public synchronized void deposit(double mount) {
		System.out.println();
		balance += mount;
		System.out.println(Thread.currentThread().getName() + "_��Ǯ"+ mount + "�ɹ����������Ϊ��" + balance);

	}
}
