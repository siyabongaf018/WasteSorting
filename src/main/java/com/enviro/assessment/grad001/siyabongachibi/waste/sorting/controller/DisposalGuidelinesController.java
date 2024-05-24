package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.controller;

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
    public ResponseEntity<List<DisposalGuidelines>> getAllDisposalGuidelines() {
        List<DisposalGuidelines> guidelines = disposalGuidelinesService.findAll();
        return ResponseEntity.ok(guidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> getDisposalGuidelineById(@PathVariable Long id) {
        DisposalGuidelines guideline = disposalGuidelinesService.findById(id);
        return ResponseEntity.ok(guideline);
    }

    @PostMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines guideline) {
        DisposalGuidelines createdGuideline = disposalGuidelinesService.save(id,guideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines guideline) {
        DisposalGuidelines updatedGuideline = disposalGuidelinesService.update(id, guideline);
        return ResponseEntity.ok(updatedGuideline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelinesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
