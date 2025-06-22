package com.veterinary.veterinary.service;

import com.veterinary.veterinary.entity.Animal;

import java.util.List;

public interface AnimalService {
    Animal save(Animal animal);
    Animal update(Long id, Animal animal);
    void delete(Long id);
    Animal getById(Long id);
    List<Animal> getAll();
    List<Animal> getByName(String name);
    List<Animal> getByCustomerId(Long customerId);
}

