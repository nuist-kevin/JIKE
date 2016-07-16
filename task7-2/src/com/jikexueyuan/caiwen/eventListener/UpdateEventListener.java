package com.jikexueyuan.caiwen.eventListener;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.event.internal.DefaultUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import com.jikexueyuan.caiwen.domain.BaseDomain;

public class UpdateEventListener extends DefaultUpdateEventListener {

	private static final long serialVersionUID = -3756700083453060172L;

	@Override
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event) {
		System.out.println("hibernate监听器生效，修改时记录修改时间");
		((BaseDomain)event.getEntity()).setUpdateTime(new Date());
		return super.performSaveOrUpdate(event);
	}
	
	

	
	
	
	
}
