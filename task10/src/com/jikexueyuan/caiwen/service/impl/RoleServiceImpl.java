package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.RoleDao;
import com.jikexueyuan.caiwen.entity.Role;
import com.jikexueyuan.caiwen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caiwen on 2016/8/20.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.findOne(id);
    }
}
