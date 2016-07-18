package com.jikexueyuan.caiwen.bean;

import org.springframework.stereotype.Component;

import com.jikexueyuan.caiwen.domain.Employee;
import com.jikexueyuan.caiwen.inter.IOutputHelper;
import com.thoughtworks.xstream.XStream;

@Component("xout")

public class XmlOutputHelper implements IOutputHelper{
	@Override
	public void print(Employee employee) {
		XStream xStream = new XStream();
		xStream.alias("employee", Employee.class);
		System.out.println(xStream.toXML(employee));
	}

}
