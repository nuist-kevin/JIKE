package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.dao.PoetDao;
import com.jikexueyuan.caiwen.domain.Poet;
import com.jikexueyuan.caiwen.domain.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caiwen on 2016/7/18.
 */
@Service
public class PoetService {

    @Autowired
    private PoetDao poetDao;

    public Poet get(Integer id) {
        return (Poet)poetDao.get(id);
    }

    @Transactional(readOnly = true)
    public List<Poetry>  getPoetriesByPoetName(String name) {
        return poetDao.getPoetriesByPoetName(name);
    }

}
