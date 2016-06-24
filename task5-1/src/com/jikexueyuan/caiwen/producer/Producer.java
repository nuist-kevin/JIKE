package com.jikexueyuan.caiwen.producer;

import java.util.concurrent.BlockingQueue;

import com.jikexueyuan.caiwen.command.AccountCommand;

public class Producer extends Thread {
	private AccountCommand accountCommand;
	private BlockingQueue<AccountCommand> drawQueue;
	
	public Producer(String name, AccountCommand accountCommand, BlockingQueue<AccountCommand> drawQueue) {
		super.setName(name);
		this.accountCommand = accountCommand;
		this.drawQueue = drawQueue;
	}

	@Override
	public void run() {
		try {
			//向线程队列中存入账户操作信息
			drawQueue.put(accountCommand);
			System.out.println("【操作号：" +accountCommand.getId() + "】" + this.getName() +"：要求" + accountCommand.getOperation() + accountCommand.getMount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
