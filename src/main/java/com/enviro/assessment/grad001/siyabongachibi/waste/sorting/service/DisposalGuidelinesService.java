package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos.DisposalGuidelinesDTO;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.DisposalGuidelines;

import java.util.List;

public interface DisposalGuidelinesService {
    public List<DisposalGuidelinesDTO> findAll();
    public DisposalGuidelinesDTO findById(Long id);
    public DisposalGuidelinesDTO save(Long categoryId, DisposalGuidelinesDTO guideline);
    public DisposalGuidelinesDTO update(Long id, DisposalGuidelinesDTO guideline);
    public void delete(Long id);
    public List<DisposalGuidelinesDTO> findDisposalGuidelinesByWasteCategoryId(Long categoryId);
}
