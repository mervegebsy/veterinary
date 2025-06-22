package com.veterinary.veterinary.repository;

import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    // isim bazlı hayvan araması
    List<Animal> findByNameIgnoreCase(String name);
    // bir müşteriye ait tüm hayvanlar
    List<Animal> findByCustomer(Customer customer);
    List<Animal> findByCustomerId(Long customerId);

}
