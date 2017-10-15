package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Goods;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author caiwen
 */
public interface GoodsRepository extends JpaRepository<Goods, Integer>,
    JpaSpecificationExecutor<Goods> {

}
