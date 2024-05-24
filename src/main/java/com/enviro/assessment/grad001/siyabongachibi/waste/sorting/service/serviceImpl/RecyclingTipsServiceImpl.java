package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.serviceImpl;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.RecyclingTips;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.RecyclingTipsService;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.WasteCategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecyclingTipsServiceImpl implements RecyclingTipsService {
    private RecyclingTipsRepository recyclingTipsRepository;
    private WasteCategoryRepository wasteCategoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(WasteCategoryService.class);


    @Override
    public List<RecyclingTips> findAll() {
        logger.info("Retrieving all Recycling Tips");
        return recyclingTipsRepository.findAll();
    }

    @Override
    public RecyclingTips findById(Long id) {
        logger.info("Retrieving RecyclingTips with id {}", id);
        return recyclingTipsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip with id " + id + " not found"));
    }

    @Override
    public RecyclingTips save(Long categoryId, RecyclingTips tip) {
        logger.info("Saving new RecyclingTips with name {}", tip.getTip());
        WasteCategory wasteCategory = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory with id " + categoryId + " not found"));
        tip.setWasteCategory(wasteCategory);
        return recyclingTipsRepository.save(tip);
    }

    @Override
    public RecyclingTips update(Long id, RecyclingTips tip) {
        logger.info("Updating RecyclingTips with id {}", id);
        RecyclingTips existingTip = findById(id);
        existingTip.setTip(tip.getTip());
        return recyclingTipsRepository.save(existingTip);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting RecyclingTips with id {}", id);
        RecyclingTips tip = findById(id);
        recyclingTipsRepository.delete(tip);
    }
}
