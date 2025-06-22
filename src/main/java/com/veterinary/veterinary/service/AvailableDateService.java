package com.veterinary.veterinary.service;

import com.veterinary.veterinary.entity.AvailableDate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailableDateService {
    AvailableDate save(AvailableDate availableDate);
    AvailableDate update(Long id, AvailableDate availableDate);
    void delete(Long id);
    Optional<AvailableDate> findById(Long id);
    List<AvailableDate> findAll();
    AvailableDate getById(Long id);
    List<AvailableDate> findByDoctorId(Long doctorId);
    boolean existsByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate);
}
