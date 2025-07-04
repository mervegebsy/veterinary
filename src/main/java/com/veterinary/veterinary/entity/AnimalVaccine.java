package com.veterinary.veterinary.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "animal_vaccines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnimalVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonIgnoreProperties({"animalVaccines", "customer"})
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccine_id", nullable = false)
    @JsonIgnoreProperties("animalVaccines")
    private Vaccine vaccine;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;
}
