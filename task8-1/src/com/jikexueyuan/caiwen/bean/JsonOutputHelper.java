package com.jikexueyuan.caiwen.bean;

import com.jikexueyuan.caiwen.domain.Employee;
import com.jikexueyuan.caiwen.inter.IOutputHelper;

public class JsonOutputHelper implements IOutputHelper{

	@Override
	public void print(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Json helper");
	}

}
