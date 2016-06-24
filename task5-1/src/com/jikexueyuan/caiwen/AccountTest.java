package com.jikexueyuan.caiwen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.jikexueyuan.caiwen.command.AccountCommand;
import com.jikexueyuan.caiwen.consumer.Consumer;
import com.jikexueyuan.caiwen.domain.Account;
import com.jikexueyuan.caiwen.producer.Producer;

public class AccountTest {
	public static void main(String[] args) {
		// �½�һ���˻������100
		Account account = new Account();
		account.setBalance(100);

		// ����һ����СΪ5���̶߳���
		BlockingQueue<AccountCommand> accountCommands = new LinkedBlockingQueue<>(5);
		// ����һ����СΪ10���̳߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		// �����������ߣ��ȴ�����
		threadPool.submit(new Consumer("������", accountCommands));

		// ѭ�������������߳�
		for (int i = 0; i <= 1000; i++) {
			if (i % 3 == 0) {
				threadPool.submit(new Producer("������-" + i, new AccountCommand(i, account, "-", 10), accountCommands));
			} else {
				threadPool.submit(new Producer("������-" + i, new AccountCommand(i, account, "+", 10), accountCommands));
			}
		}
	}
}
