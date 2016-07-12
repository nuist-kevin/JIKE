package com.jikexueyuan.caiwen.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseDomain {

	private Date addTime;
	private Date updateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="add_time")
	public Date getAddTime() {
		return addTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
