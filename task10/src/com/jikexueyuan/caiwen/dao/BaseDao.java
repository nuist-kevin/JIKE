package com.jikexueyuan.caiwen.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {
    public T findOne(PK pk);

    public PK save(T model);

    public void delete(PK pk);

    public List<T> findAll();

    public Long totalCount();

    public List<T> findByPage(int pageSize, int startIndex);
}
