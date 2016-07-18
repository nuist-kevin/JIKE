package com.jikexueyuan.caiwen.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jikexueyuan.caiwen.domain.Employee;
import com.jikexueyuan.caiwen.inter.IOutputHelper;

public class EmployeePrinter {
	private IOutputHelper iOutputHelper;

	/**
	 * 属性注入必须提供无参数的构造函数
	 */
	public EmployeePrinter() {
	}
	
	// 供构造器注入使用
	public EmployeePrinter(IOutputHelper iOutputHelper) {
		super();
		this.iOutputHelper = iOutputHelper;
	}

	public IOutputHelper getiOutputHelper() {
		return iOutputHelper;
	}

	public void setiOutputHelper(IOutputHelper iOutputHelper) {
		this.iOutputHelper = iOutputHelper;
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		//两个输出器，分别注入不同的outputHelper
		EmployeePrinter employeePrinter1 = (EmployeePrinter) applicationContext.getBean("empPrinter1");
		EmployeePrinter employeePrinter2 = (EmployeePrinter) applicationContext.getBean("empPrinter2");
		
		//分别用两个输出器输出员工信息
		employeePrinter1.getiOutputHelper().print(new Employee("caiwen",33, "男"));
		System.out.println();
		employeePrinter2.getiOutputHelper().print(new Employee("caiwen",33, "男"));

	}
}
