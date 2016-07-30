package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.domain.Consume;
import org.springframework.data.domain.Page;

/**
 * Created by caiwen on 2016/7/31.
 */
public interface ConsumeService {
    Consume add(Consume consume);
    Page<Consume> query(Integer vipId, String name, Integer page);

}
