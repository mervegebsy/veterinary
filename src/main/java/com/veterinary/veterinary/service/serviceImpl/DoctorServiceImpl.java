package com.veterinary.veterinary.service.serviceImpl;

import com.veterinary.veterinary.entity.Doctor;
import com.veterinary.veterinary.exception.NotFoundException;
import com.veterinary.veterinary.repository.DoctorRepository;
import com.veterinary.veterinary.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Long id, Doctor doctor) {
        Optional<Doctor> existing = doctorRepository.findById(id);
        if (existing.isPresent()) {
            Doctor updated = existing.get();
            updated.setName(doctor.getName());
            updated.setPhone(doctor.getPhone());
            updated.setMail(doctor.getMail());
            updated.setAddress(doctor.getAddress());
            updated.setCity(doctor.getCity());
            return doctorRepository.save(updated);
        }
        return null; // Exception ile değiştireceğim
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + id));
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> findByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }
}
