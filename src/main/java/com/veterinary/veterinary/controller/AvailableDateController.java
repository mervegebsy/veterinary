package com.veterinary.veterinary.controller;

import com.veterinary.veterinary.dto.request.AvailableDateRequest;
import com.veterinary.veterinary.dto.response.AvailableDateResponse;
import com.veterinary.veterinary.entity.AvailableDate;
import com.veterinary.veterinary.entity.Doctor;
import com.veterinary.veterinary.service.AvailableDateService;
import com.veterinary.veterinary.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/available-dates")
@RequiredArgsConstructor
public class AvailableDateController {

    private final AvailableDateService availableDateService;
    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<AvailableDateResponse> create(@RequestBody AvailableDateRequest request) {
        Doctor doctor = doctorService.getById(request.getDoctorId());
        AvailableDate availableDate = new AvailableDate();
        availableDate.setDoctor(doctor);
        availableDate.setAvailableDate(request.getAvailableDate());
        AvailableDate saved = availableDateService.save(availableDate);

        return new ResponseEntity<>(toResponse(saved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvailableDateResponse> update(@PathVariable Long id,
                                                        @RequestBody AvailableDateRequest request) {
        Doctor doctor = doctorService.getById(request.getDoctorId());
        AvailableDate updated = new AvailableDate();
        updated.setDoctor(doctor);
        updated.setAvailableDate(request.getAvailableDate());

        AvailableDate result = availableDateService.update(id, updated);
        return ResponseEntity.ok(toResponse(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        availableDateService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AvailableDateResponse>> getAll() {
        List<AvailableDateResponse> list = availableDateService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailableDateResponse> getById(@PathVariable Long id) {
        AvailableDate availableDate = availableDateService.getById(id);
        return ResponseEntity.ok(toResponse(availableDate));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AvailableDateResponse>> getByDoctorId(@PathVariable Long doctorId) {
        List<AvailableDateResponse> list = availableDateService.findByDoctorId(doctorId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    private AvailableDateResponse toResponse(AvailableDate availableDate) {
        return new AvailableDateResponse(
                availableDate.getId(),
                availableDate.getAvailableDate(),
                availableDate.getDoctor().getId(),
                availableDate.getDoctor().getName()
        );
    }
}
