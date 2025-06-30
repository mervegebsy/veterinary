package com.veterinary.veterinary.mapper;

import com.veterinary.veterinary.dto.request.AppointmentRequest;
import com.veterinary.veterinary.dto.response.AppointmentResponse;
import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.entity.Appointment;
import com.veterinary.veterinary.entity.Doctor;
import com.veterinary.veterinary.service.AnimalService;
import com.veterinary.veterinary.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final DoctorService doctorService;
    private final AnimalService animalService;

    public Appointment toEntity(AppointmentRequest request) {
        Doctor doctor = doctorService.getById(request.getDoctorId());
        Animal animal = animalService.getById(request.getAnimalId());

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setDoctor(doctor);
        appointment.setAnimal(animal);
        return appointment;
    }

    public AppointmentResponse toResponse(Appointment appointment) {
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .doctorName(appointment.getDoctor().getName())
                .animalName(appointment.getAnimal().getName())
                .build();
    }
}





