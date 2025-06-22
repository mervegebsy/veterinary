package com.veterinary.veterinary.service;


import com.veterinary.veterinary.entity.AnimalVaccine;

import java.time.LocalDate;
import java.util.List;

public interface AnimalVaccineService {
    AnimalVaccine save(AnimalVaccine animalVaccine);
    AnimalVaccine update(Long id, AnimalVaccine animalVaccine);
    void delete(Long id);
    AnimalVaccine getById(Long id);
    List<AnimalVaccine> getAll();
    List<AnimalVaccine> getByAnimalId(Long animalId);
    List<AnimalVaccine> getByVaccineCodeAndActiveProtection(String vaccineCode, LocalDate date);
}
