package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.domain.Commodity;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by caiwen on 2016/7/31.
 */
public interface CommodityService {
    Commodity add(Commodity commodity);
    List<Commodity> findAll();
    Long totalCount();
    Page<Commodity> query(Integer id, String name, BigDecimal lowPrice,
                          BigDecimal upPrice, BigDecimal lowAgio,
                          BigDecimal upAgio, int page);
}
