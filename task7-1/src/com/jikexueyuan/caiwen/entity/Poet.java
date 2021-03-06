package com.jikexueyuan.caiwen.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/***
	诗人实体类
 */
@Entity()
@Table(name="POETS")
public class Poet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	private Date createTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_AT")
	private Date updateTime;

	@OneToMany(mappedBy = "poet")
	private List<Poetry> poetries;

	public List<Poetry> getPoetries() {
		return poetries;
	}

	public void setPoetries(List<Poetry> poetries) {
		this.poetries = poetries;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
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
	
	
}
