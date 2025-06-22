package com.veterinary.veterinary.controller;

import com.veterinary.veterinary.dto.request.AnimalRequest;
import com.veterinary.veterinary.dto.response.AnimalResponse;
import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.mapper.AnimalMapper;
import com.veterinary.veterinary.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;
    private final AnimalMapper animalMapper;

    @PostMapping
    public ResponseEntity<AnimalResponse> save(@RequestBody AnimalRequest request) {
        Animal animal = animalMapper.toEntity(request);
        Animal saved = animalService.save(animal);
        return ResponseEntity.status(201).body(animalMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponse> update(@PathVariable Long id,
                                                 @RequestBody AnimalRequest request) {
        Animal updatedAnimal = animalMapper.toEntity(request);
        Animal updated = animalService.update(id, updatedAnimal);
        return ResponseEntity.ok(animalMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> findAll() {
        List<Animal> animals = animalService.getAll();
        List<AnimalResponse> responses = animals.stream()
                .map(animalMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponse> findById(@PathVariable Long id) {
        Animal animal = animalService.getById(id);
        return ResponseEntity.ok(animalMapper.toResponse(animal));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnimalResponse>> findByName(@RequestParam String name) {
        List<Animal> animals = animalService.getByName(name);
        List<AnimalResponse> responses = animals.stream()
                .map(animalMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AnimalResponse>> findByCustomer(@PathVariable Long customerId) {
        List<Animal> animals = animalService.getByCustomerId(customerId);
        List<AnimalResponse> responses = animals.stream()
                .map(animalMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
