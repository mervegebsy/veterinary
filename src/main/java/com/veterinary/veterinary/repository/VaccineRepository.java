package com.veterinary.veterinary.repository;

import com.veterinary.veterinary.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    //aşı adı ve kodu arama
    Optional<Vaccine> findByNameAndCode(String name, String code);
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate start, LocalDate end);
}
