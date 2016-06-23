package com.jikexueyuan.caiwen.consumer;

import java.util.concurrent.BlockingQueue;

import com.jikexueyuan.caiwen.command.AccountCommand;

public class Consumer extends Thread {
	
	private BlockingQueue<AccountCommand> drawQueue;

	public Consumer(String name, BlockingQueue<AccountCommand> drawQueue) {
		super.setName(name);;
		this.drawQueue = drawQueue;
	}


	@Override
	public void run() {
		try {
			AccountCommand accountCommand = drawQueue.take();
			System.out.println("¡¾²Ù×÷ºÅ£º" +accountCommand.getId() + "¡¿" + this.getName() + "£º²Ù×÷" +  accountCommand.getOperation()+ accountCommand.getMount());
			if ("-".equals(accountCommand.getOperation())) {
				accountCommand.getAccount().draw(accountCommand.getMount());
			} else {
				accountCommand.getAccount().deposit(accountCommand.getMount());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
