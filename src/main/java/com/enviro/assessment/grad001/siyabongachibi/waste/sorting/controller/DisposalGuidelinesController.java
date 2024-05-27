package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.controller;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos.DisposalGuidelinesDTO;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.DisposalGuidelines;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.DisposalGuidelinesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
@AllArgsConstructor
public class DisposalGuidelinesController {

    private final DisposalGuidelinesService disposalGuidelinesService;

    @GetMapping
    public ResponseEntity<List<DisposalGuidelinesDTO>> getAllDisposalGuidelines() {
        List<DisposalGuidelinesDTO> guidelines = disposalGuidelinesService.findAll();
        return ResponseEntity.ok(guidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelinesDTO> getDisposalGuidelineById(@PathVariable Long id) {
        DisposalGuidelinesDTO guideline = disposalGuidelinesService.findById(id);
        return ResponseEntity.ok(guideline);
    }

    @PostMapping("/{id}")
    public ResponseEntity<DisposalGuidelinesDTO> createDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelinesDTO guideline) {
        DisposalGuidelinesDTO createdGuideline = disposalGuidelinesService.save(id,guideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelinesDTO> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelinesDTO guideline) {
        DisposalGuidelinesDTO updatedGuideline = disposalGuidelinesService.update(id, guideline);
        return ResponseEntity.ok(updatedGuideline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelinesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disposal-guideline/{id}")
    public ResponseEntity<List<DisposalGuidelinesDTO>> getAllDisposalGuidelineByCategoryId(@PathVariable Long id) {
        List<DisposalGuidelinesDTO> guidelines = disposalGuidelinesService.findDisposalGuidelinesByWasteCategoryId(id);
        return ResponseEntity.ok(guidelines);
    }
}
