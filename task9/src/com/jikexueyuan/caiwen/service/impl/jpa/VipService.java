package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Vip;
import com.jikexueyuan.caiwen.repositry.VipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiwen on 2016/7/24.
 */
@Service
public class VipService {

    private VipRepository vipRepository;

    public VipRepository getVipRepository() {
        return vipRepository;
    }

    @Autowired
    public void setVipRepository(VipRepository vipRepository) {
        this.vipRepository = vipRepository;
    }

    public Vip add(Vip vip) {
        return vipRepository.save(vip);
    }


    public List<Vip> findAll() {
        return vipRepository.findAll();
    }

    public Vip get(Integer id) {
        return vipRepository.findOne(id);
    }

    public Vip update(Vip vip) {
        return vipRepository.save(vip);
    }

    public void delete(Integer id) {
        vipRepository.delete(id);
    }
}
