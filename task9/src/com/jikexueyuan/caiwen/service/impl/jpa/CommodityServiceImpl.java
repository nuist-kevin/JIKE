package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Commodity;
import com.jikexueyuan.caiwen.repositry.CommodityRepository;
import com.jikexueyuan.caiwen.service.CommodityService;
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

@Service
public class CommodityServiceImpl implements CommodityService {

    private CommodityRepository commodityRepository;
    private final Integer RECORD_PER_PAGE = 5;

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

    /**
     * 动态查询方法
     *
     * @param id
     * @param name
     * @param lowPrice
     * @param upPrice
     * @param lowAgio
     * @param upAgio
     * @param page
     * @return org.springframework.data.domain.Page，返回指定页码的一页数据，包括数据List和总页数
     */
    public Page<Commodity> query(Integer id, String name, BigDecimal lowPrice,
                                 BigDecimal upPrice, BigDecimal lowAgio,
                                 BigDecimal upAgio, int page) {
        Pageable pageable = new PageRequest(page - 1, RECORD_PER_PAGE);
        Page<Commodity> commodityPage = commodityRepository.findAll(
                new Specification() {
                    @Override
                    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery,
                                                 CriteriaBuilder criteriaBuilder) {
                        Predicate predicate = criteriaBuilder.conjunction();
                        //如果查询条件中包含id，则增加id = ?过滤条件
                        if (id != null) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.equal(root.<Integer>get("id"), id));
                        }
                        //如果查询条件中包含name，则增加name like ?过滤条件
                        if (StringUtils.isNotEmpty(name)) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.like(
                                            root.<Integer>get("name"), "%" + name + "%"));
                        }
                        //如果查询条件中既包含价格上限也包含价格下限，则增加price between ? and ?过滤条件
                        if (lowPrice != null && upPrice != null) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.between(
                                            root.<BigDecimal>get("price"), lowPrice, upPrice));
                        }
                        //如果查询条件中仅包含价格下限，则增加price >= ? 过滤条件
                        if (lowPrice != null && upPrice == null) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.ge(
                                            root.<BigDecimal>get("price"), lowPrice));
                        }
                        //如果查询条件中仅包含价格上限，则增加price <= ? 过滤条件
                        if (lowPrice == null && upPrice != null) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.le(root.<BigDecimal>get("price"), upPrice));
                        }
                        //如果查询条件中既包含折扣上限也包含折扣下限，则增加agio between ? and ?过滤条件
                        if (lowAgio != null && upAgio != null) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.between(
                                            root.<BigDecimal>get("agio"), lowAgio, upAgio));
                        }
                        //如果查询条件中仅包含折扣下限，则增加agio >= ?过滤条件
                        if (lowAgio != null && upAgio == null) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.ge(root.<BigDecimal>get("agio"), lowAgio));
                        }
                        //如果查询条件中仅包含折扣上限，则增加agio <= ? 过滤条件
                        if (lowAgio == null && upAgio != null) {
                            predicate.getExpressions().add(
                                    criteriaBuilder.le(root.<BigDecimal>get("agio"), upAgio));
                        }
                        return predicate;
                    }
                }, pageable);
        return commodityPage;
    }
}
