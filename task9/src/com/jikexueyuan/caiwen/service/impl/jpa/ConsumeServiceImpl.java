package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Consume;
import com.jikexueyuan.caiwen.repositry.ConsumeRepository;
import com.jikexueyuan.caiwen.service.ConsumeService;
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

/**
 * Created by caiwen on 2016/7/24.
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {

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

    public Page<Consume> query(Integer vipId, String name, Integer page) {
        Pageable pageable = new PageRequest(page-1, 5);
        Page<Consume> commodityPage = consumeRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                //如果查询条件中包含 vipId，则增加 vipId = ?过滤条件
                if(vipId != null) {
                    predicate.getExpressions().add(criteriaBuilder.equal(
                            root.get("vip").get("vipId"), vipId));
                }
                //如果查询条件中包含 name，则增加 name like ?过滤条件
                if (StringUtils.isNotEmpty(name)) {
                    predicate.getExpressions().add(criteriaBuilder.like(root.get("vip").get("name"), "%" + name + "%"));
                }
                return predicate;
            }
        }, pageable);
        return commodityPage;
    }
}
