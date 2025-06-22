package com.veterinary.veterinary.service;

import com.veterinary.veterinary.entity.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine update(Long id, Vaccine vaccine);
    void delete(Long id);
    Vaccine getById(Long id);
    List<Vaccine> getAll();
    List<Vaccine> getByProtectionFinishDateBetween(LocalDate start, LocalDate end);
}
