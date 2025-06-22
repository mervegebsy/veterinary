package com.veterinary.veterinary.service.serviceImpl;


import com.veterinary.veterinary.entity.AnimalVaccine;
import com.veterinary.veterinary.exception.NotFoundException;
import com.veterinary.veterinary.repository.AnimalVaccineRepository;
import com.veterinary.veterinary.service.AnimalVaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalVaccineServiceImpl implements AnimalVaccineService {

    private final AnimalVaccineRepository animalVaccineRepository;

    @Override
    public AnimalVaccine save(AnimalVaccine animalVaccine) {
        return animalVaccineRepository.save(animalVaccine);
    }

    @Override
    public AnimalVaccine update(Long id, AnimalVaccine animalVaccine) {
        AnimalVaccine existing = animalVaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AnimalVaccine not found with id: " + id));

        existing.setAnimal(animalVaccine.getAnimal());
        existing.setVaccine(animalVaccine.getVaccine());
        existing.setApplicationDate(animalVaccine.getApplicationDate());

        return animalVaccineRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!animalVaccineRepository.existsById(id)) {
            throw new NotFoundException("AnimalVaccine not found with id: " + id);
        }
        animalVaccineRepository.deleteById(id);
    }

    @Override
    public AnimalVaccine getById(Long id) {
        return animalVaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AnimalVaccine not found with id: " + id));
    }

    @Override
    public List<AnimalVaccine> getAll() {
        return animalVaccineRepository.findAll();
    }

    @Override
    public List<AnimalVaccine> getByAnimalId(Long animalId) {
        return animalVaccineRepository.findByAnimal_Id(animalId);
    }

    @Override
    public List<AnimalVaccine> getByVaccineCodeAndActiveProtection(String vaccineCode, LocalDate date) {
        return animalVaccineRepository.findByVaccine_CodeAndVaccine_ProtectionFinishDateAfter(vaccineCode, date);
    }
}
