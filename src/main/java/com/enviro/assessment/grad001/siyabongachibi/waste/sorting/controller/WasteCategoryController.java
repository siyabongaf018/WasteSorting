package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.controller;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> categories = wasteCategoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        WasteCategory category = wasteCategoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory category) {
        System.out.println(category);
        WasteCategory createdCategory = wasteCategoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        WasteCategory updatedCategory = wasteCategoryService.update(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}