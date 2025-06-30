package com.veterinary.veterinary.mapper;

import com.veterinary.veterinary.dto.request.AnimalVaccineRequest;
import com.veterinary.veterinary.dto.response.AnimalVaccineResponse;
import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.entity.AnimalVaccine;
import com.veterinary.veterinary.entity.Vaccine;
import org.springframework.stereotype.Component;

@Component
public class AnimalVaccineMapper {

    private final AnimalMapper animalMapper;
    private final VaccineMapper vaccineMapper;

    public AnimalVaccineMapper(AnimalMapper animalMapper, VaccineMapper vaccineMapper) {
        this.animalMapper = animalMapper;
        this.vaccineMapper = vaccineMapper;
    }

    public AnimalVaccine toEntity(AnimalVaccineRequest dto) {
        if (dto == null) return null;

        AnimalVaccine entity = new AnimalVaccine();
        entity.setApplicationDate(dto.getApplicationDate());

        if (dto.getAnimalId() != null) {
            Animal animal = new Animal();
            animal.setId(dto.getAnimalId());
            entity.setAnimal(animal);
        }

        if (dto.getVaccineId() != null) {
            Vaccine vaccine = new Vaccine();
            vaccine.setId(dto.getVaccineId());
            entity.setVaccine(vaccine);
        }

        return entity;
    }

    public AnimalVaccineResponse toResponseDto(AnimalVaccine entity) {
        if (entity == null) return null;

        AnimalVaccineResponse dto = new AnimalVaccineResponse();
        dto.setId(entity.getId());
        dto.setApplicationDate(entity.getApplicationDate());

        dto.setAnimal(animalMapper.toResponse(entity.getAnimal()));
        dto.setVaccine(vaccineMapper.toResponse(entity.getVaccine()));

        return dto;
    }
}
