package com.jikexueyuan.caiwen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.jikexueyuan.caiwen.command.AccountCommand;
import com.jikexueyuan.caiwen.consumer.Consumer;
import com.jikexueyuan.caiwen.domain.Account;
import com.jikexueyuan.caiwen.producer.Producer;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(100);
		
		BlockingQueue<AccountCommand> accountCommands = new LinkedBlockingQueue<>(2);
		
		for (int i = 0; i < 100; i++) {
			if (i%3 == 0) {
				new Producer("生产者-" + i, new AccountCommand(i, account, "-", 100 ), accountCommands).start();
			} else {
				new Producer("生产者-" + i, new AccountCommand(i, account, "+", 30 ), accountCommands).start();
			}
			
			new Consumer("消费者-" + i, accountCommands).start();
		}
	}
}
