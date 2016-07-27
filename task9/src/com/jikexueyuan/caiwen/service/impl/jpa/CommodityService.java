package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Commodity;
import com.jikexueyuan.caiwen.repositry.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Long totalCount() {
        return commodityRepository.count();
    }

    public List<Commodity> findByPage(int page) {
        Pageable pageable = new PageRequest(page, 10);
        Page<Commodity> commodityPage = commodityRepository.findAll(pageable);
        return commodityPage.getContent();
    }
    public Page<Commodity> listByPage(int page) {
        //每页5条数据
        Pageable pageable = new PageRequest(page, 5);
        return commodityRepository.findAll(pageable);
    }
}
