package com.veterinary.veterinary.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalVaccineRequest {
    private LocalDate applicationDate;
    private Long animalId;
    private Long vaccineId;
}
