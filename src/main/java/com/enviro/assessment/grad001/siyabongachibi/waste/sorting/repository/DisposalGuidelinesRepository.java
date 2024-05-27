package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.DisposalGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines,Long> {
    @Query("SELECT dg FROM DisposalGuidelines dg WHERE dg.wasteCategory.id = :categoryId")
    List<DisposalGuidelines> findByWasteCategoryId(@Param("categoryId") Long categoryId);
}