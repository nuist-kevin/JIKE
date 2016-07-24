package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Commodity;
import com.jikexueyuan.caiwen.repositry.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiwen on 2016/7/24.
 */
@Service
public class CommodityService {

    private CommodityRepository commodityRepository;

    public CommodityRepository getCommodityRepository() {
        return commodityRepository;
    }

    @Autowired
    public void setCommodityRepository(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    public Commodity add(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }
}
