package com.veterinary.veterinary.controller;

import com.veterinary.veterinary.dto.request.AnimalVaccineRequest;
import com.veterinary.veterinary.dto.response.AnimalVaccineResponse;
import com.veterinary.veterinary.entity.AnimalVaccine;
import com.veterinary.veterinary.mapper.AnimalVaccineMapper;
import com.veterinary.veterinary.service.AnimalVaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/*@RestController
@RequestMapping("/api/animal-vaccines")
@RequiredArgsConstructor
public class AnimalVaccineController {

    private final AnimalVaccineService animalVaccineService;

    @PostMapping
    public ResponseEntity<AnimalVaccine> createAnimalVaccine(@RequestBody AnimalVaccine animalVaccine) {
        AnimalVaccine saved = animalVaccineService.save(animalVaccine);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalVaccine> getAnimalVaccineById(@PathVariable Long id) {
        AnimalVaccine animalVaccine = animalVaccineService.getById(id);
        return ResponseEntity.ok(animalVaccine);
    }

    @GetMapping
    public ResponseEntity<List<AnimalVaccine>> getAllAnimalVaccines() {
        List<AnimalVaccine> list = animalVaccineService.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalVaccine> updateAnimalVaccine(@PathVariable Long id,
                                                             @RequestBody AnimalVaccine animalVaccine) {
        AnimalVaccine updated = animalVaccineService.update(id, animalVaccine);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimalVaccine(@PathVariable Long id) {
        animalVaccineService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<AnimalVaccine>> getByAnimalId(@PathVariable Long animalId) {
        List<AnimalVaccine> list = animalVaccineService.getByAnimalId(animalId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/vaccine-code")
    public ResponseEntity<List<AnimalVaccine>> getByVaccineCodeAndActiveProtection(
            @RequestParam String code,
            @RequestParam String date) {

        LocalDate protectionDate = LocalDate.parse(date);
        List<AnimalVaccine> list = animalVaccineService.getByVaccineCodeAndActiveProtection(code, protectionDate);
        return ResponseEntity.ok(list);
    }
}

*/
@RestController
@RequestMapping("/api/animal-vaccines")
@RequiredArgsConstructor
public class AnimalVaccineController {

    private final AnimalVaccineService animalVaccineService;
    private final AnimalVaccineMapper mapper;

    @PostMapping
    public ResponseEntity<AnimalVaccineResponse> createAnimalVaccine(@RequestBody AnimalVaccineRequest requestDto) {
        AnimalVaccine entity = mapper.toEntity(requestDto);
        AnimalVaccine saved = animalVaccineService.save(entity);
        return new ResponseEntity<>(mapper.toResponseDto(saved), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalVaccineResponse> getAnimalVaccineById(@PathVariable Long id) {
        AnimalVaccine entity = animalVaccineService.getById(id);
        return ResponseEntity.ok(mapper.toResponseDto(entity));
    }

    @GetMapping
    public ResponseEntity<List<AnimalVaccineResponse>> getAllAnimalVaccines() {
        List<AnimalVaccine> list = animalVaccineService.getAll();
        List<AnimalVaccineResponse> dtoList = list.stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalVaccineResponse> updateAnimalVaccine(@PathVariable Long id,
                                                                        @RequestBody AnimalVaccineRequest requestDto) {
        AnimalVaccine entity = mapper.toEntity(requestDto);
        AnimalVaccine updated = animalVaccineService.update(id, entity);
        return ResponseEntity.ok(mapper.toResponseDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimalVaccine(@PathVariable Long id) {
        animalVaccineService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<AnimalVaccineResponse>> getByAnimalId(@PathVariable Long animalId) {
        List<AnimalVaccine> list = animalVaccineService.getByAnimalId(animalId);
        List<AnimalVaccineResponse> dtoList = list.stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/vaccine-code")
    public ResponseEntity<List<AnimalVaccineResponse>> getByVaccineCodeAndActiveProtection(
            @RequestParam String code,
            @RequestParam String date) {
        LocalDate protectionDate = LocalDate.parse(date);
        List<AnimalVaccine> list = animalVaccineService.getByVaccineCodeAndActiveProtection(code, protectionDate);
        List<AnimalVaccineResponse> dtoList = list.stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
