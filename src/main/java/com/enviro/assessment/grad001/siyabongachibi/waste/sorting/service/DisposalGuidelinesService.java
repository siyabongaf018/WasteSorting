package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.DisposalGuidelines;

import java.util.List;

public interface DisposalGuidelinesService {
    public List<DisposalGuidelines> findAll();
    public DisposalGuidelines findById(Long id);
    public DisposalGuidelines save(Long categoryId, DisposalGuidelines guideline);
    public DisposalGuidelines update(Long id, DisposalGuidelines guideline);
    public void delete(Long id);
}
