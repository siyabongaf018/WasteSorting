package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.serviceImpl;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos.DisposalGuidelinesDTO;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.DisposalGuidelines;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.DisposalGuidelinesRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.DisposalGuidelinesService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DisposalGuidelinesServiceImpl implements DisposalGuidelinesService {
    private final DisposalGuidelinesRepository disposalGuidelinesRepository;
    private final WasteCategoryRepository wasteCategoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(DisposalGuidelinesServiceImpl.class);

    @Override
    public List<DisposalGuidelinesDTO> findAll() {
        logger.info("Retrieving all Disposal Guidelines");
        List<DisposalGuidelines> guidelines = disposalGuidelinesRepository.findAll();
        return guidelines.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DisposalGuidelinesDTO findById(Long id) {
        logger.info("Retrieving Disposal Guidelines with id {}", id);
        DisposalGuidelines guideline = disposalGuidelinesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline with id " + id + " not found"));
        return mapToDTO(guideline);
    }

    @Override
    public DisposalGuidelinesDTO save(Long categoryId, DisposalGuidelinesDTO guidelineDTO) {
        logger.info("Saving new Disposal Guidelines with guideline {}", guidelineDTO.getGuideline());
        WasteCategory wasteCategory = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory with id " + categoryId + " not found"));
        DisposalGuidelines guideline = mapToEntity(guidelineDTO);
        guideline.setWasteCategory(wasteCategory);
        guideline = disposalGuidelinesRepository.save(guideline);
        return mapToDTO(guideline);
    }

    @Override
    public DisposalGuidelinesDTO update(Long id, DisposalGuidelinesDTO guidelineDTO) {
        logger.info("Updating Disposal Guidelines with id {}", id);
        DisposalGuidelines existingGuideline = disposalGuidelinesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline with id " + id + " not found"));
        existingGuideline.setGuideline(guidelineDTO.getGuideline());
        return mapToDTO(disposalGuidelinesRepository.save(existingGuideline));
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting Disposal Guidelines with id {}", id);
        DisposalGuidelines guideline = disposalGuidelinesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline with id " + id + " not found"));
        disposalGuidelinesRepository.delete(guideline);
    }

    @Override
    public List<DisposalGuidelinesDTO> findDisposalGuidelinesByWasteCategoryId(Long categoryId) {
        logger.info("Retrieving Disposal Guidelines by WasteCategory id {}", categoryId);
        List<DisposalGuidelines> guidelines = disposalGuidelinesRepository.findByWasteCategoryId(categoryId);
        return guidelines.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private DisposalGuidelinesDTO mapToDTO(DisposalGuidelines guideline) {
        DisposalGuidelinesDTO dto = new DisposalGuidelinesDTO();
        dto.setId(guideline.getId());
        dto.setGuideline(guideline.getGuideline());
        dto.setWasteCategoryId(guideline.getWasteCategory().getId());
        dto.setWasteCategoryName(guideline.getWasteCategory().getName());
        return dto;
    }

    private DisposalGuidelines mapToEntity(DisposalGuidelinesDTO dto) {
        DisposalGuidelines guideline = new DisposalGuidelines();
        guideline.setId(dto.getId());
        guideline.setGuideline(dto.getGuideline());
        return guideline;
    }
}
