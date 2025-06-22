package com.veterinary.veterinary.service.serviceImpl;

import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.exception.NotFoundException;
import com.veterinary.veterinary.repository.AnimalRepository;
import com.veterinary.veterinary.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Long id, Animal animal) {
        Animal existingAnimal = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));

        animal.setId(id); // güncellenecek ID’yi set ediyoruz
        return animalRepository.save(animal);
    }

    @Override
    public void delete(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));
        animalRepository.delete(animal);
    }

    @Override
    public Animal getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getByName(String name) {
        return animalRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Animal> getByCustomerId(Long customerId) {
        return animalRepository.findByCustomerId(customerId);
    }
}


