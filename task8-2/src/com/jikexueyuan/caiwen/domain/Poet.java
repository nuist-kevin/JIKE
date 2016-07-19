package com.jikexueyuan.caiwen.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "POETS")
public class Poet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT")
	private Date createTime;

	@Column(name = "UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
