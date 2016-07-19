package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.dao.PoetryDao;
import com.jikexueyuan.caiwen.domain.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caiwen on 2016/7/18.
 */
@Service
public class PoetryService {

    @Autowired
    private PoetryDao poetryDao;

    @Transactional(readOnly = true)
    public List<Poetry> getPoetriesByPoetName(String name) {
        return poetryDao.getPoetriesByPoetName(name);
    }

    @Transactional(readOnly = true)
    public List<Poetry> getPoetriesBytitle(String title) {
        return poetryDao.getPoetriesBytitle(title);
    }

    @Transactional(readOnly = true)
    public List<Poetry> getPoetriesByContent(String content) {
        return poetryDao.getPoetriesByContent(content);
    }
}
