package com.veterinary.veterinary.service.serviceImpl;
import static com.veterinary.veterinary.exception.MessageConstants.*;

import com.veterinary.veterinary.entity.Appointment;
import com.veterinary.veterinary.entity.Doctor;
import com.veterinary.veterinary.exception.AlreadyExistsException;
import com.veterinary.veterinary.exception.MessageConstants;
import com.veterinary.veterinary.exception.NotFoundException;
import com.veterinary.veterinary.repository.AppointmentRepository;
import com.veterinary.veterinary.repository.DoctorRepository;
import com.veterinary.veterinary.service.AnimalService;
import com.veterinary.veterinary.service.AppointmentService;
import com.veterinary.veterinary.service.AvailableDateService;
import com.veterinary.veterinary.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final AvailableDateService availableDateService;
    private final DoctorService doctorService;
    private final AnimalService animalService;

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment not found with id: " + id));

        existing.setAppointmentDate(appointment.getAppointmentDate());
        existing.setDoctor(appointment.getDoctor());
        existing.setAnimal(appointment.getAnimal());

        return appointmentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new NotFoundException("Appointment not found with id: " + id);
        }
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment not found with id: " + id));
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }


    @Override
    public List<Appointment> getByDoctorIdAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + doctorId));
        return appointmentRepository.findByDoctorAndAppointmentDateBetween(doctor, start, end);
    }


    @Override
    public List<Appointment> getByAnimalIdAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByAnimalIdAndAppointmentDateBetween(animalId, start, end);
    }
    @Override
    public boolean existsByDoctorIdAndAppointmentDate(Doctor doctor, LocalDateTime appointmentDate) {
        return appointmentRepository.existsByDoctorAndAppointmentDate(doctor, appointmentDate);
    }

    @Override
    public Appointment createAppointmentWithValidation(Appointment appointment) {
        boolean isAvailableDay = availableDateService.existsByDoctorIdAndAvailableDate(
                appointment.getDoctor().getId(), appointment.getAppointmentDate().toLocalDate()
        );

        if (!isAvailableDay) {
            throw new NotFoundException(MessageConstants.DOCTOR_NOT_AVAILABLE);        }

        boolean conflict = appointmentRepository.existsByDoctorAndAppointmentDate(
                appointment.getDoctor(), appointment.getAppointmentDate()
        );

        if (conflict) {
            throw new AlreadyExistsException(MessageConstants.APPOINTMENT_CONFLICT);
        }

        return appointmentRepository.save(appointment);
    }




}
