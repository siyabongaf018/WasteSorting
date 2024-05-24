package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.RecyclingTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTips, Long> {
}
