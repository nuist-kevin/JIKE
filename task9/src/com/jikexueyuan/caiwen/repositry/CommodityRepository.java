package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigDecimal;

/**
 * Created by caiwen on 2016/7/21.
 */
public interface CommodityRepository extends JpaRepository<Commodity, Integer>, JpaSpecificationExecutor{

}
