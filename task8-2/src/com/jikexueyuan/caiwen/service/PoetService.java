package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.dao.PoetDao;
import com.jikexueyuan.caiwen.domain.Poet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by caiwen on 2016/7/18.
 */
public class PoetService {

    @Autowired
    private PoetDao poetDao;

    public Poet get(Integer id) {
        return (Poet)poetDao.get(id);
    }


}
