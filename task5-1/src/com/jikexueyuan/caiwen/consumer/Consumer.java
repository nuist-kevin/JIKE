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
		//һ��������һֱ����ȥ�̶߳��л�ȡ�˻�������Ϣ
		while (true) {
			try {
				//ȥ�̶߳��л�ȡ�˻�������Ϣ��ȡ������ȡ�����������߳�
				AccountCommand accountCommand = drawQueue.take();
				System.out.println("�������ţ�" + accountCommand.getId() + "��" + this.getName() + "������"
						+ accountCommand.getOperation() + accountCommand.getMount());
				//����ǲ�����-����ȡǮ�������Ǯ
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
