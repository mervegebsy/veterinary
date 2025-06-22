package com.veterinary.veterinary.mapper;

import com.veterinary.veterinary.dto.request.AnimalRequest;
import com.veterinary.veterinary.dto.response.AnimalResponse;
import com.veterinary.veterinary.entity.Animal;
import com.veterinary.veterinary.entity.Customer;
import com.veterinary.veterinary.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalMapper {

    private final CustomerService customerService;

    public Animal toEntity(AnimalRequest request) {
        Customer customer = customerService.findById(request.getCustomerId());

        Animal animal = new Animal();
        animal.setName(request.getName());
        animal.setSpecies(request.getSpecies());
        animal.setBreed(request.getBreed());
        animal.setColour(request.getColor());
        animal.setDateOfBirth(request.getDateOfBirth());
        animal.setCustomer(customer);

        return animal;
    }

    public AnimalResponse toResponse(Animal animal) {
        AnimalResponse response = new AnimalResponse();
        response.setId(animal.getId());
        response.setName(animal.getName());
        response.setSpecies(animal.getSpecies());
        response.setBreed(animal.getBreed());
        response.setColor(animal.getColour());
        response.setDateOfBirth(animal.getDateOfBirth());

        if (animal.getCustomer() != null) {
            response.setCustomerId(animal.getCustomer().getId());
            response.setCustomerName(animal.getCustomer().getName());
        }

        return response;
    }
}
