package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.serviceImpl;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos.RecyclingTipsDTO;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.RecyclingTips;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.RecyclingTipsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecyclingTipsServiceImpl implements RecyclingTipsService {
    private final RecyclingTipsRepository recyclingTipsRepository;
    private final WasteCategoryRepository wasteCategoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(RecyclingTipsServiceImpl.class);

    @Override
    public List<RecyclingTipsDTO> findAll() {
        logger.info("Retrieving all Recycling Tips");
        List<RecyclingTips> tips = recyclingTipsRepository.findAll();
        return tips.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecyclingTipsDTO findById(Long id) {
        logger.info("Retrieving RecyclingTips with id {}", id);
        RecyclingTips tip = recyclingTipsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip with id " + id + " not found"));
        return mapToDTO(tip);
    }

    @Override
    public RecyclingTipsDTO save(Long categoryId, RecyclingTipsDTO tipDTO) {
        logger.info("Saving new RecyclingTips with name {}", tipDTO.getTip());
        WasteCategory wasteCategory = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory with id " + categoryId + " not found"));
        RecyclingTips tip = mapToEntity(tipDTO);
        tip.setWasteCategory(wasteCategory);
        tip = recyclingTipsRepository.save(tip);
        return mapToDTO(tip);
    }

    @Override
    public RecyclingTipsDTO update(Long id, RecyclingTipsDTO tipDTO) {
        logger.info("Updating RecyclingTips with id {}", id);
        RecyclingTips existingTip = recyclingTipsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip with id " + id + " not found"));
        existingTip.setTip(tipDTO.getTip());
        return mapToDTO(recyclingTipsRepository.save(existingTip));
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting RecyclingTips with id {}", id);
        RecyclingTips tip = recyclingTipsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip with id " + id + " not found"));
        recyclingTipsRepository.delete(tip);
    }

    @Override
    public List<RecyclingTipsDTO> findRecyclingTipsByWasteCategoryId(Long categoryId) {
        logger.info("Retrieving Recycling Tips by WasteCategory id {}", categoryId);
        List<RecyclingTips> tips = recyclingTipsRepository.findByWasteCategoryId(categoryId);
        return tips.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private RecyclingTipsDTO mapToDTO(RecyclingTips tip) {
        RecyclingTipsDTO dto = new RecyclingTipsDTO();
        dto.setId(tip.getId());
        dto.setTip(tip.getTip());
        dto.setWasteCategoryId(tip.getWasteCategory().getId());
        dto.setWasteCategoryName(tip.getWasteCategory().getName());
        return dto;
    }

    private RecyclingTips mapToEntity(RecyclingTipsDTO dto) {
        RecyclingTips tip = new RecyclingTips();
        tip.setId(dto.getId());
        tip.setTip(dto.getTip());
        return tip;
    }
}
