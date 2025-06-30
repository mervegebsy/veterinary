package com.veterinary.veterinary.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalVaccineResponse {
    private Long id;
    private LocalDate applicationDate;
    private AnimalResponse animal;
    private VaccineResponse vaccine;
}
