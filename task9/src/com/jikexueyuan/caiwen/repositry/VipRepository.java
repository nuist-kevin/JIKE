package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VipRepository extends JpaRepository<Vip,Integer>, JpaSpecificationExecutor {
}
