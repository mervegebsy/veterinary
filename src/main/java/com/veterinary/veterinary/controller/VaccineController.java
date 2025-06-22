package com.veterinary.veterinary.controller;

import com.veterinary.veterinary.dto.request.VaccineRequest;
import com.veterinary.veterinary.dto.response.VaccineResponse;
import com.veterinary.veterinary.entity.Vaccine;
import com.veterinary.veterinary.mapper.VaccineMapper;
import com.veterinary.veterinary.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vaccines")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;
    private final VaccineMapper vaccineMapper;

    @PostMapping
    public ResponseEntity<VaccineResponse> createVaccine(@RequestBody VaccineRequest request) {
        Vaccine vaccine = vaccineMapper.toEntity(request);
        Vaccine saved = vaccineService.save(vaccine);
        return new ResponseEntity<>(vaccineMapper.toResponse(saved), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccineResponse> getById(@PathVariable Long id) {
        Vaccine vaccine = vaccineService.getById(id);
        return ResponseEntity.ok(vaccineMapper.toResponse(vaccine));
    }

    @GetMapping
    public ResponseEntity<List<VaccineResponse>> getAll() {
        List<Vaccine> vaccines = vaccineService.getAll();
        List<VaccineResponse> responses = vaccines.stream()
                .map(vaccineMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VaccineResponse> update(@PathVariable Long id, @RequestBody VaccineRequest request) {
        Vaccine vaccine = vaccineMapper.toEntity(request);
        Vaccine updated = vaccineService.update(id, vaccine);
        return ResponseEntity.ok(vaccineMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vaccineService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/protection-finish-date")
    public ResponseEntity<List<VaccineResponse>> getByProtectionFinishDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<Vaccine> vaccines = vaccineService.getByProtectionFinishDateBetween(start, end);
        List<VaccineResponse> responses = vaccines.stream()
                .map(vaccineMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

}
