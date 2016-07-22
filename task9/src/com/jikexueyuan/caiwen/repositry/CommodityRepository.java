package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by caiwen on 2016/7/21.
 */
public interface CommodityRepository extends JpaRepository<Commodity,Integer> {
}
