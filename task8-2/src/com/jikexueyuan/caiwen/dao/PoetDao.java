package com.jikexueyuan.caiwen.dao;

import com.jikexueyuan.caiwen.domain.Poetry;

import java.util.List;

/**
 * Created by caiwen on 2016/7/18.
 */
public interface PoetDao extends BaseDao {
    public List<Poetry> getPoetriesByPoetName(String name);
}
