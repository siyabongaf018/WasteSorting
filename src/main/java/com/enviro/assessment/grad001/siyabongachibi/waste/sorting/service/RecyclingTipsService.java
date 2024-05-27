package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos.RecyclingTipsDTO;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.RecyclingTips;

import java.util.List;

public interface RecyclingTipsService {
    public List<RecyclingTipsDTO> findAll() ;
    public RecyclingTipsDTO findById(Long id) ;
    public RecyclingTipsDTO save(Long categoryId, RecyclingTipsDTO tip) ;
    public RecyclingTipsDTO update(Long id, RecyclingTipsDTO tip);
    public void delete(Long id);
    public List<RecyclingTipsDTO> findRecyclingTipsByWasteCategoryId(Long categoryId);
}
