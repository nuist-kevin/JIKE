package com.jikexueyuan.caiwen.dao;

import java.util.List;

public interface BaseDao<T, PK> {
    public T findOne(PK pk);

    public PK save(T model);

    public void delete(PK pk);

    public List<T> findAll();

    public Integer totalCount();

    public List<T> findByPage(int pageSize, int startIndex);
}
