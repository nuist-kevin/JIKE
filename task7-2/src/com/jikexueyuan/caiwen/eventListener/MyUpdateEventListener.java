package com.jikexueyuan.caiwen.eventListener;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.event.internal.DefaultUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import com.jikexueyuan.caiwen.domain.BaseDomain;

public class MyUpdateEventListener extends DefaultUpdateEventListener {

	private static final long serialVersionUID = -3756700083453060172L;

	@Override
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event) {
		// TODO Auto-generated method stub
		System.out.println("监听器生效");
		((BaseDomain)event.getEntity()).setUpdateTime(new Date());
		return super.performSaveOrUpdate(event);
	}
	
	

	
	
	
	
}
