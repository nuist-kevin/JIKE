package com.jikexueyuan.caiwen.bean;

import com.google.gson.Gson;
import com.jikexueyuan.caiwen.domain.Employee;
import com.jikexueyuan.caiwen.inter.IOutputHelper;

public class JsonOutputHelper implements IOutputHelper{

	@Override
	public void print(Employee employee) {
		System.out.println(new Gson().toJson(employee));
	}

}
