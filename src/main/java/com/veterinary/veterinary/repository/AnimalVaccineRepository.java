package com.veterinary.veterinary.repository;

import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.entity.AnimalVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.entity.AnimalVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalVaccineRepository extends JpaRepository<AnimalVaccine, Long> {

    // Hayvana ait tüm aşı kayıtlarını getirme (Animal nesnesiyle)
    List<AnimalVaccine> findByAnimal(Animal animal);

    // Hayvana ait tüm aşı kayıtlarını getirme (Hayvan ID ile)
    List<AnimalVaccine> findByAnimal_Id(Long animalId);

    // Aynı aşı koduna sahip ve koruyuculuk bitiş tarihi belirli bir tarihten sonra olan kayıtları listeleme
    List<AnimalVaccine> findByVaccine_CodeAndVaccine_ProtectionFinishDateAfter(String code, LocalDate date);

    // Koruyuculuk bitiş tarihi belirli tarih aralığında olan aşıları bulma
    List<AnimalVaccine> findByVaccine_ProtectionFinishDateBetween(LocalDate start, LocalDate end);
}

