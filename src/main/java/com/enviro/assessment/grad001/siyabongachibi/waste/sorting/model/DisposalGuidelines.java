package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisposalGuidelines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String guideline;

    @ManyToOne
    @JoinColumn(name = "waste_category_id")
    private WasteCategory wasteCategory;

}
