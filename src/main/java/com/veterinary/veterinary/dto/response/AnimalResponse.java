package com.veterinary.veterinary.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalResponse {

    private Long id;
    private String name;
    private String species;
    private String breed;
    private String color;
    private LocalDate dateOfBirth;
    private Long customerId;
    private String customerName;
}
