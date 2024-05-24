package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    boolean existsByName(String name);
}
