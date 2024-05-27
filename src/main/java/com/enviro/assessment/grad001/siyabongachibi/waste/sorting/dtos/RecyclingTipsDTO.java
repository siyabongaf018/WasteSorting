package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecyclingTipsDTO {
    private Long id;
    private String tip;
    private Long wasteCategoryId;
    private String wasteCategoryName;
}
