package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisposalGuidelinesDTO {
    private Long id;
    private String guideline;
    private Long wasteCategoryId;
    private String wasteCategoryName;
}