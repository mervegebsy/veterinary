package com.veterinary.veterinary.service.serviceImpl;

import com.veterinary.veterinary.entity.Vaccine;
import com.veterinary.veterinary.exception.NotFoundException;
import com.veterinary.veterinary.repository.VaccineRepository;
import com.veterinary.veterinary.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine update(Long id, Vaccine vaccine) {
        Vaccine existing = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found with id: " + id));

        existing.setName(vaccine.getName());
        existing.setCode(vaccine.getCode());
        existing.setProtectionStartDate(vaccine.getProtectionStartDate());
        existing.setProtectionFinishDate(vaccine.getProtectionFinishDate());

        return vaccineRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!vaccineRepository.existsById(id)) {
            throw new NotFoundException("Vaccine not found with id: " + id);
        }
        vaccineRepository.deleteById(id);
    }

    @Override
    public Vaccine getById(Long id) {
        return vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found with id: " + id));
    }

    @Override
    public List<Vaccine> getAll() {
        return vaccineRepository.findAll();
    }

    @Override
    public List<Vaccine> getByProtectionFinishDateBetween(LocalDate start, LocalDate end) {
        return vaccineRepository.findByProtectionFinishDateBetween(start, end);
    }
}
