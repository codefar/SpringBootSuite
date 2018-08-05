package com.greenleaf.ntsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayWelfareJpaDao extends JpaRepository<DayWelfareEntity, Long> {
}