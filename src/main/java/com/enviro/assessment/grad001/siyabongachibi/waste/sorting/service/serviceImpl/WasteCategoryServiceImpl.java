package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.serviceImpl;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.DuplicateResourceException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.DisposalGuidelinesRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.WasteCategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@AllArgsConstructor
public class WasteCategoryServiceImpl implements WasteCategoryService {

    private WasteCategoryRepository wasteCategoryRepository;
    private DisposalGuidelinesRepository disposalGuidelinesRepository;
    private static final Logger logger = LoggerFactory.getLogger(WasteCategoryService.class);


    @Override
    public List<WasteCategory> findAll() {
        logger.info("Retrieving all waste categories");
        return wasteCategoryRepository.findAll();
    }

    @Override

    public WasteCategory findById(Long id) {
        logger.info("Retrieving waste category with id {}", id);
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory with id " + id + " not found"));
    }

    @Override
    public WasteCategory save(WasteCategory category) {
        logger.info("Saving new waste category with name {}", category.getName());
        // Check if a WasteCategory with the same name already exists
        if (wasteCategoryRepository.existsByName(category.getName())) {
            throw new DuplicateResourceException("WasteCategory with name " + category.getName() + " already exists");
        }
        // If no duplicate is found, save the category
        return wasteCategoryRepository.save(category);
    }

    @Override
    public WasteCategory update(Long id, WasteCategory category) {
        logger.info("Updating waste category with id {}", id);
        WasteCategory existingCategory = findById(id);

        // Check if the name of the category being updated is different from the existing one
        // and if a category with the same name already exists
        if (!existingCategory.getName().equals(category.getName()) && wasteCategoryRepository.existsByName(category.getName())) {
            throw new DuplicateResourceException("WasteCategory with name " + category.getName() + " already exists");
        }

        // Update the name and description of the existing category
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return wasteCategoryRepository.save(existingCategory);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting waste category with id {}", id);
        wasteCategoryRepository.deleteById(id);
    }
}
