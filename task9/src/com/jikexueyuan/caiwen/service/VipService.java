package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.domain.Vip;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * Created by caiwen on 2016/7/31.
 */
public interface VipService {
    Vip add(Vip vip);
    Vip get(Integer id);
    Vip update(Vip vip);
    void delete(Integer id);
    public Page<Vip> query(Integer id, String name, Integer fromAge, Integer toAge, String profession, Date fromDate,
                           Date toDate, Integer page);
}
