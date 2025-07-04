package com.veterinary.veterinary.repository;

import com.veterinary.veterinary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    // isim bazlı müşteri araması
    List<Customer> findByNameContainingIgnoreCase(String name);
}
