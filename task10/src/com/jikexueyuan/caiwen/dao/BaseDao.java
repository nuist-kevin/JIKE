package com.jikexueyuan.caiwen.dao;

import java.util.List;

public interface BaseDao<T, PK> {
    T findOne(PK pk);

    PK save(T model);

    void delete(PK pk);

    List<T> findAll();

    Integer totalCount();

}
