package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.controller;

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
    public ResponseEntity<List<RecyclingTips>> getAllRecyclingTips() {
        List<RecyclingTips> tips = recyclingTipsService.findAll();
        return ResponseEntity.ok(tips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTips> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTips tip = recyclingTipsService.findById(id);
        return ResponseEntity.ok(tip);
    }

    @PostMapping("/{id}")
    public ResponseEntity<RecyclingTips> createRecyclingTip(@PathVariable Long id,@Valid @RequestBody RecyclingTips tip) {
        RecyclingTips createdTip = recyclingTipsService.save(id, tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTips> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTips tip) {
        RecyclingTips updatedTip = recyclingTipsService.update(id, tip);
        return ResponseEntity.ok(updatedTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
