package com.veterinary.veterinary.service.serviceImpl;

import com.veterinary.veterinary.entity.AvailableDate;
import com.veterinary.veterinary.exception.MessageConstants;
import com.veterinary.veterinary.exception.NotFoundException;
import com.veterinary.veterinary.repository.AvailableDateRepository;
import com.veterinary.veterinary.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailableDateServiceImpl implements AvailableDateService {

    private final AvailableDateRepository availableDateRepository;

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate update(Long id, AvailableDate availableDate) {
        Optional<AvailableDate> existing = availableDateRepository.findById(id);
        if (existing.isPresent()) {
            AvailableDate updated = existing.get();
            updated.setAvailableDate(availableDate.getAvailableDate());
            updated.setDoctor(availableDate.getDoctor());
            return availableDateRepository.save(updated);
        }
        return null; // Daha sonra Exception ile değiştirilecek
    }

    @Override
    public void delete(Long id) {
        availableDateRepository.deleteById(id);
    }

    @Override
    public Optional<AvailableDate> findById(Long id) {
        return availableDateRepository.findById(id);
    }

    @Override
    public List<AvailableDate> findAll() {
        return availableDateRepository.findAll();
    }


    @Override
    public AvailableDate getById(Long id) {
        return availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " " + MessageConstants.AVAILABLE_DATE_NOT_FOUND));
    }


    @Override
    public List<AvailableDate> findByDoctorId(Long doctorId) {
        return availableDateRepository.findByDoctorId(doctorId);
    }

    @Override
    public boolean existsByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate) {
        return availableDateRepository.existsByDoctorIdAndAvailableDate(doctorId, availableDate);
    }
}
