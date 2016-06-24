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
		// 新建一个账户，余额100
		Account account = new Account();
		account.setBalance(100);

		// 创建一个大小为5的线程队列
		BlockingQueue<AccountCommand> accountCommands = new LinkedBlockingQueue<>(5);
		// 创建一个大小为10的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		// 先启动消费者，等待消费
		threadPool.submit(new Consumer("消费者", accountCommands));

		// 循环创建生产者线程
		for (int i = 0; i <= 1000; i++) {
			if (i % 3 == 0) {
				threadPool.submit(new Producer("生产者-" + i, new AccountCommand(i, account, "-", 10), accountCommands));
			} else {
				threadPool.submit(new Producer("生产者-" + i, new AccountCommand(i, account, "+", 10), accountCommands));
			}
		}
	}
}
