package com.veterinary.veterinary.service.serviceImpl;

import com.veterinary.veterinary.entity.Customer;
import com.veterinary.veterinary.repository.CustomerRepository;
import com.veterinary.veterinary.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " id’li müşteri bulunamadı."));

        existingCustomer.setName(customer.getName());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setMail(customer.getMail());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void delete(Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " id’li müşteri bulunamadı."));
        customerRepository.delete(existingCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " id’li müşteri bulunamadı."));
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }
}
