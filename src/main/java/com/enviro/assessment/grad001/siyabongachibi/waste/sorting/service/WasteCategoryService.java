package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.DuplicateResourceException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.WasteCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WasteCategoryService {
    public List<WasteCategory> findAll();
    public WasteCategory findById(Long id);
    public WasteCategory save(WasteCategory category);
    public WasteCategory update(Long id, WasteCategory category);
    public void delete(Long id);
}

