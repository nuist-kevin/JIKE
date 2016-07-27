package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Commodity;
import com.jikexueyuan.caiwen.repositry.CommodityRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
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

    public Page<Commodity> query(Integer id, String name, BigDecimal lowPrice, BigDecimal upPrice, BigDecimal lowAgio, BigDecimal upAgio, int page) {
        Pageable pageable = new PageRequest(page, 5);
        Page<Commodity> commodityPage = commodityRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(id != null) {
                    predicate.getExpressions().add(criteriaBuilder.equal(root.<Integer>get("id"), id));
                }
                if (StringUtils.isNotEmpty(name)) {
                    predicate.getExpressions().add(criteriaBuilder.like(root.<Integer>get("name"), name));
                }
                if (lowPrice != null && upPrice != null) {
                    predicate.getExpressions().add(criteriaBuilder.between(root.<BigDecimal>get("price"),lowPrice, upPrice));
                }
                if (lowAgio != null && upAgio != null) {
                    predicate.getExpressions().add(criteriaBuilder.between(root.<BigDecimal>get("price"),lowAgio, upAgio));
                }
                return predicate;
            }
        }, pageable);
        return commodityPage;
    }
}
