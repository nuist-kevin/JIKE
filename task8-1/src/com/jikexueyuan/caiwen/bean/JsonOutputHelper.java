package com.jikexueyuan.caiwen.bean;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.jikexueyuan.caiwen.domain.Employee;
import com.jikexueyuan.caiwen.inter.IOutputHelper;

@Component("jout")
public class JsonOutputHelper implements IOutputHelper{

	@Override
	public void print(Employee employee) {
		System.out.println(new Gson().toJson(employee));
	}

}
