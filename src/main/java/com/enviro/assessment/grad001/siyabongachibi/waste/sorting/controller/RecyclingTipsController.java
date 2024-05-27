package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.controller;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos.DisposalGuidelinesDTO;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos.RecyclingTipsDTO;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.RecyclingTips;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.RecyclingTipsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
@AllArgsConstructor
public class RecyclingTipsController {

    private final RecyclingTipsService recyclingTipsService;

    @GetMapping
    public ResponseEntity<List<RecyclingTipsDTO>> getAllRecyclingTips() {
        List<RecyclingTipsDTO> tips = recyclingTipsService.findAll();
        return ResponseEntity.ok(tips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipsDTO> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTipsDTO tip = recyclingTipsService.findById(id);
        return ResponseEntity.ok(tip);
    }

    @PostMapping("/{id}")
    public ResponseEntity<RecyclingTipsDTO> createRecyclingTip(@PathVariable Long id,@Valid @RequestBody RecyclingTipsDTO tip) {
        RecyclingTipsDTO createdTip = recyclingTipsService.save(id, tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTipsDTO> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTipsDTO tip) {
        RecyclingTipsDTO updatedTip = recyclingTipsService.update(id, tip);
        return ResponseEntity.ok(updatedTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recycling-tips/{id}")
    public ResponseEntity<List<RecyclingTipsDTO>> getAllRecyclingTipsByCategoryId(@PathVariable Long id) {
        List<RecyclingTipsDTO> guidelines = recyclingTipsService.findRecyclingTipsByWasteCategoryId(id);
        return ResponseEntity.ok(guidelines);
    }
}
