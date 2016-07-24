package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Consume;
import com.jikexueyuan.caiwen.repositry.ConsumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiwen on 2016/7/24.
 */
@Service
public class ConsumeService {

    private ConsumeRepository consumeRepository;

    public ConsumeRepository getConsumeRepository() {
        return consumeRepository;
    }

    @Autowired
    public void setConsumeRepository(ConsumeRepository consumeRepository) {
        this.consumeRepository = consumeRepository;
    }

    public Consume add(Consume consume) {
        return consumeRepository.save(consume);
    }

    public List<Consume> findAll() {
        return consumeRepository.findAll();
    }
}
