package com.jikexueyuan.caiwen.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface BaseDao<T, PK> {
    Integer RECORD_PER_PAGE = 5;

    T findOne(PK pk);

    PK save(T model);

    void saveOrUpdate(T mode);

    void delete(PK pk);

    List<T> findAll();

    Integer totalCount();

    Integer totalPages(Integer recordPerPage);

    Map pagedQuery(Integer page, Integer recordPerPage);
}
