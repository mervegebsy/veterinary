package com.veterinary.veterinary.repository;

import com.veterinary.veterinary.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    // isim bazlı doktor araması
    List<Doctor> findByNameContainingIgnoreCase(String name);
}
