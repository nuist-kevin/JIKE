package com.jikexueyuan.caiwen.interceptor.hibernate;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class MyInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 3898550577222844966L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		System.out.println("我的拦截器生效了");
		for (int i = 0; i < propertyNames.length; i++) {
			if("addTime".equals(propertyNames[i])) {
				state[i] = new Date();
			}
			if("updateTime".equals(propertyNames[i])) {
				state[i] = new Date();
			}
		}
		return true;
	}
	
	
}
