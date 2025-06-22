package com.veterinary.veterinary.repository;

import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.entity.Appointment;
import com.veterinary.veterinary.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    boolean existsByDoctorAndAppointmentDate(Doctor doctor, LocalDateTime appointmentDate);

    // 1. yol - Doctor entity ile
    List<Appointment> findByDoctorAndAppointmentDateBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);

    // 2. yol - Sadece doctorId ile (JPQL sorgu)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.appointmentDate BETWEEN :start AND :end")
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(@Param("doctorId") Long doctorId,
                                                              @Param("start") LocalDateTime start,
                                                              @Param("end") LocalDateTime end);

    List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animalId, LocalDateTime start, LocalDateTime end);
}

