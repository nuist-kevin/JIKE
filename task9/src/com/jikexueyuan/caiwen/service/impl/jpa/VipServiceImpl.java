package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.domain.Vip;
import com.jikexueyuan.caiwen.repositry.VipRepository;
import com.jikexueyuan.caiwen.service.VipService;
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
import java.util.Date;

/**
 * Created by caiwen on 2016/7/24.
 */
@Service
public class VipServiceImpl implements VipService {

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

    public Vip get(Integer id) {
        return vipRepository.findOne(id);
    }

    public Vip update(Vip vip) {
        return vipRepository.save(vip);
    }

    public void delete(Integer id) {
        vipRepository.delete(id);
    }

    public Page<Vip> query(Integer id, String name, Integer fromAge, Integer toAge, String profession, Date fromDate,
                           Date toDate, Integer page) {
        Pageable pageable = new PageRequest(page - 1, 5);
        Page<Vip> vipPage = getVipRepository().findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                //如果查询条件中包含id，则增加 id = ?过滤条件
                if (id != null) {
                    predicate.getExpressions().add(criteriaBuilder.equal(root.<Integer>get("id"), id));
                }
                //如果查询条件中包含name，则增加 name like ?过滤条件
                if (StringUtils.isNotEmpty(name)) {
                    predicate.getExpressions().add(criteriaBuilder.like(root.<String>get("name"), "%" + name + "%"));
                }

                //如果查询条件中既包含年龄上限也包含年龄下限，则增加 age between ? and ?过滤条件
                if (fromAge != null && toAge != null) {
                    predicate.getExpressions().add(criteriaBuilder.between(root.<Integer>get("age"), fromAge, toAge));
                }
                //如果查询条件中仅包含年龄下限，则增加 age >= ?过滤条件
                if (fromAge != null && toAge == null) {
                    predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.<Integer>get("age"), fromAge));
                }
                //如果查询条件中仅包含年龄上限，则增加 age <= ? 过滤条件
                if (fromAge == null && toAge != null) {
                    predicate.getExpressions().add(criteriaBuilder.lessThanOrEqualTo(root.<Integer>get("age"), toAge));
                }
                //如果查询条件中包含profession，则增加 profession like ?过滤条件
                if (StringUtils.isNotEmpty(profession)) {
                    predicate.getExpressions().add(criteriaBuilder.like(root.<String>get("profession"), "%" + profession + "%"));
                }
                //如果查询条件中既包含时间上限也包含时间下限，则增加 joinTime between ? and ?过滤条件
                if (fromDate != null && toDate != null) {
                    predicate.getExpressions().add(criteriaBuilder.between(root.<Date>get("joinTime"), fromDate, toDate));
                }
                //如果查询条件中仅包含时间下限，则增加 joinTime >= ?过滤条件
                if (fromDate != null && toDate == null) {
                    predicate.getExpressions().add(criteriaBuilder.greaterThanOrEqualTo(root.<Date>get("joinTime"), fromDate));
                }
                //如果查询条件中仅包含时间上限，则增加 joinTime <= ? 过滤条件
                if (fromDate == null && toDate != null) {
                    predicate.getExpressions().add(criteriaBuilder.lessThanOrEqualTo(root.<Date>get("joinTime"), toDate));
                }
                return predicate;
            }
        }, pageable);
        return vipPage;
    }
}
