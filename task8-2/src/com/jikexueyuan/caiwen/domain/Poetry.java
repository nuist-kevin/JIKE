package com.jikexueyuan.caiwen.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POETRIES")
public class Poetry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poet_id")
	private Poet poet;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT")
	private Date createTime;

	@Column(name = "UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Poet getPoet() {
		return poet;
	}
	public void setPoet(Poet poet) {
		this.poet = poet;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
