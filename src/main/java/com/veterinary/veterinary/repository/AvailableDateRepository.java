package com.veterinary.veterinary.repository;

import com.veterinary.veterinary.entity.AvailableDate;
import com.veterinary.veterinary.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {

    // Doktorun belirli bir tarihte müsait olup olmadığını kontrol eder
    Optional<AvailableDate> findByDoctorAndAvailableDate(Doctor doctor, LocalDate availableDate);

    // Doktorun tüm müsait günlerini getirir
    List<AvailableDate> findByDoctor(Doctor doctor);

    // ID üzerinden doktorun tüm günlerini getirir (DTO veya ID ile çalışma durumlarında)
    List<AvailableDate> findByDoctorId(Long doctorId);

    // Doktorun belirtilen tarihte çalışıp çalışmadığını kontrol eder
    boolean existsByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate);

}

