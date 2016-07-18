package com.jikexueyuan.caiwen.bean;

import com.jikexueyuan.caiwen.domain.Employee;
import com.jikexueyuan.caiwen.inter.IOutputHelper;
import com.thoughtworks.xstream.XStream;

public class XmlOutputHelper implements IOutputHelper{
	@Override
	public void print(Employee employee) {
		System.out.println(new XStream().toXML(employee));
	}

}
