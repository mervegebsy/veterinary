package com.veterinary.veterinary.service;

import com.veterinary.veterinary.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor save(Doctor doctor);
    Doctor update(Long id, Doctor doctor);
    void delete(Long id);
    Optional<Doctor> findById(Long id);
    Doctor getById(Long id);
    List<Doctor> findAll();
    List<Doctor> findByName(String name);
}
