package com.jikexueyuan.caiwen.dao;

import java.util.List;

public interface BaseDao<T> {
	public T get(Integer id);
	
	public Integer save(T model);
	
	public void delete(Integer id);
	
	public void update(T model);
	
	public List<T> findAll();
	
	public Long totalCount();

    public List<T> findByPage(int pageSize, int startIndex);
}
