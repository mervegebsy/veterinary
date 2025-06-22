package com.veterinary.veterinary.controller;

import com.veterinary.veterinary.dto.request.AppointmentRequest;
import com.veterinary.veterinary.dto.response.AppointmentResponse;
import com.veterinary.veterinary.entity.Appointment;
import com.veterinary.veterinary.mapper.AppointmentMapper;
import com.veterinary.veterinary.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppointment(@RequestBody AppointmentRequest request) {
        Appointment appointment = appointmentMapper.toEntity(request);
        Appointment saved = appointmentService.createAppointmentWithValidation(appointment);
        AppointmentResponse response = appointmentMapper.toResponse(saved);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getById(id);
        return ResponseEntity.ok(appointmentMapper.toResponse(appointment));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAll();
        List<AppointmentResponse> responses = appointments.stream()
                .map(appointmentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(@PathVariable Long id,
                                                                 @RequestBody AppointmentRequest request) {
        Appointment appointment = appointmentMapper.toEntity(request);
        Appointment updated = appointmentService.update(id, appointment);
        return ResponseEntity.ok(appointmentMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getByDoctorAndDateRange(
            @PathVariable Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<Appointment> appointments = appointmentService.getByDoctorIdAndDateRange(doctorId, start, end);
        List<AppointmentResponse> responses = appointments.stream()
                .map(appointmentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<AppointmentResponse>> getByAnimalAndDateRange(
            @PathVariable Long animalId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<Appointment> appointments = appointmentService.getByAnimalIdAndDateRange(animalId, start, end);
        List<AppointmentResponse> responses = appointments.stream()
                .map(appointmentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
