package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.DisposalGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines,Long> {
}
