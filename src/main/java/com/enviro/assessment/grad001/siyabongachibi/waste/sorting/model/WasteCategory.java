package com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DisposalGuidelines> disposalGuidelines;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RecyclingTips> recyclingTips;

}

