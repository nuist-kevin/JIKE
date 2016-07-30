package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.Consume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsumeRepository extends JpaRepository<Consume,Integer>, JpaSpecificationExecutor {
}
