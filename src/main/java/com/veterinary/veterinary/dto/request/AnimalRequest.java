package com.veterinary.veterinary.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalRequest {

    private String name;
    private String species;
    private String breed;
    private String color;
    private LocalDate dateOfBirth;
    private Long customerId;
}
