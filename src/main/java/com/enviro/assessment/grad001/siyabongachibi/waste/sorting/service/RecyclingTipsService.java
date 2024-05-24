package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.RecyclingTips;

import java.util.List;

public interface RecyclingTipsService {
    public List<RecyclingTips> findAll() ;
    public RecyclingTips findById(Long id) ;
    public RecyclingTips save(Long categoryId, RecyclingTips tip) ;
    public RecyclingTips update(Long id, RecyclingTips tip);
    public void delete(Long id) ;
}
