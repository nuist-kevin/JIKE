package com.jikexueyuan.caiwen.consumer;

import java.util.concurrent.BlockingQueue;

import com.jikexueyuan.caiwen.command.AccountCommand;

public class Consumer extends Thread {

	private BlockingQueue<AccountCommand> drawQueue;

	public Consumer(String name, BlockingQueue<AccountCommand> drawQueue) {
		super.setName(name);
		this.drawQueue = drawQueue;
	}

	@Override
	public void run() {
		//一旦启动就一直尝试去线程队列获取账户操作信息
		while (true) {
			try {
				//去线程队列获取账户操作信息，取到则处理，取不到则阻塞线程
				AccountCommand accountCommand = drawQueue.take();
				System.out.println("【操作号：" + accountCommand.getId() + "】" + this.getName() + "：操作"
						+ accountCommand.getOperation() + accountCommand.getMount());
				//如果是操作是-，则取钱，否则存钱
				if ("-".equals(accountCommand.getOperation())) {
					accountCommand.getAccount().draw(accountCommand.getMount());
				} else {
					accountCommand.getAccount().deposit(accountCommand.getMount());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
