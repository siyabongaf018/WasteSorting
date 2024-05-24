package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.serviceImpl;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.DisposalGuidelines;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.DisposalGuidelinesRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.DisposalGuidelinesService;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.WasteCategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisposalGuidelinesServiceImpl implements DisposalGuidelinesService {
    private DisposalGuidelinesRepository disposalGuidelinesRepository;
    private WasteCategoryRepository wasteCategoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(WasteCategoryService.class);

    @Override
    public List<DisposalGuidelines> findAll() {
        logger.info("Retrieving all Disposal Guidelines");
        return disposalGuidelinesRepository.findAll();
    }

    @Override
    public DisposalGuidelines findById(Long id) {
        logger.info("Retrieving Disposal Guidelines with id {}", id);
        return disposalGuidelinesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline with id " + id + " not found"));
    }

    @Override
    public DisposalGuidelines save(Long categoryId, DisposalGuidelines guideline) {
        logger.info("Saving new Disposal Guidelines with guideline {}", guideline.getGuideline());
        WasteCategory wasteCategory = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory with id " + categoryId + " not found"));
        guideline.setWasteCategory(wasteCategory);
        return disposalGuidelinesRepository.save(guideline);
    }

    @Override
    public DisposalGuidelines update(Long id, DisposalGuidelines guideline) {
        logger.info("Updating Disposal Guidelines with id {}", id);
        DisposalGuidelines existingGuideline = findById(id);
        existingGuideline.setGuideline(guideline.getGuideline());
        return disposalGuidelinesRepository.save(existingGuideline);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting Disposal Guidelines with id {}", id);
        DisposalGuidelines guideline = findById(id);
        disposalGuidelinesRepository.delete(guideline);
    }
}
