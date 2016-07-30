package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommodityRepository extends JpaRepository<Commodity, Integer>,
        JpaSpecificationExecutor {
}
