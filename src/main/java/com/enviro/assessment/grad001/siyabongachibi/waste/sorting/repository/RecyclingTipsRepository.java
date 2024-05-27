package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.RecyclingTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTips, Long> {
    @Query("SELECT dg FROM RecyclingTips dg WHERE dg.wasteCategory.id = :categoryId")
    List<RecyclingTips> findByWasteCategoryId(Long categoryId);
}
