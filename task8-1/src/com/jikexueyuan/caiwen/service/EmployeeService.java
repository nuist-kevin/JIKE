package com.jikexueyuan.caiwen.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jikexueyuan.caiwen.domain.Employee;
import com.jikexueyuan.caiwen.inter.IOutputHelper;

public class EmployeeService {
	
	private IOutputHelper iOutputHelper;

	/**
	 * 属性注入必须提供无参数的构造函数
	 */
	public EmployeeService() {}
	
	// 供构造器注入使用
	public EmployeeService(IOutputHelper iOutputHelper) {
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

		IOutputHelper iOutputHelper1 = (IOutputHelper) applicationContext.getBean("jout");
		iOutputHelper1.print(new Employee("caiwen", 20, "男"));
		System.out.println();
		IOutputHelper iOutputHelper2 = (IOutputHelper) applicationContext.getBean("xout");
		iOutputHelper2.print(new Employee("caiwen", 20, "男"));
		System.out.println();

/*		//两个不同的service实例，分别注入不同的outputHelper属性
		EmployeeService employeeService1 = (EmployeeService) applicationContext.getBean("empPrinter1");
		EmployeeService employeeService2 = (EmployeeService) applicationContext.getBean("empPrinter2");
		
		//分别用两个service输出员工信息
		employeeService1.getiOutputHelper().print(new Employee("caiwen",25, "男"));
		System.out.println();
		employeeService2.getiOutputHelper().print(new Employee("caiwen",27, "男"));
*/
	}
}
