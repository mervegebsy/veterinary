package com.veterinary.veterinary.service;

import com.veterinary.veterinary.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    Customer update(Long id, Customer customer);
    void delete(Long id);
    List<Customer> findAll();
    Customer findById(Long id);
    List<Customer> findByName(String name);
}
