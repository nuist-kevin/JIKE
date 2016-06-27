package com.jikexueyuan.caiwen.domain;

public class Poetry {
	private int id;
	private String title;
	private Poet poet; 
	private String content;
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
	
	
}
