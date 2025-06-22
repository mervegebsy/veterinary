package com.veterinary.veterinary.service;

import com.veterinary.veterinary.entity.Appointment;
import com.veterinary.veterinary.entity.Doctor;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    Appointment update(Long id, Appointment appointment);
    void delete(Long id);
    Appointment getById(Long id);
    List<Appointment> getAll();
    List<Appointment> getByDoctorIdAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end);
    List<Appointment> getByAnimalIdAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end);
    boolean existsByDoctorIdAndAppointmentDate(Doctor doctor, LocalDateTime appointmentDate);
    Appointment createAppointmentWithValidation(Appointment appointment);

}
