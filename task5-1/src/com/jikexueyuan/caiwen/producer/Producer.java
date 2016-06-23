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
			drawQueue.put(accountCommand);
			System.out.println("¡¾²Ù×÷ºÅ£º" +accountCommand.getId() + "¡¿" + this.getName() +"£ºÒªÇó" + accountCommand.getOperation() + accountCommand.getMount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
