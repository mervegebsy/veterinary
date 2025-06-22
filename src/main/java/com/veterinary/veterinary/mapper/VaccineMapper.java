package com.veterinary.veterinary.mapper;

import com.veterinary.veterinary.dto.request.VaccineRequest;
import com.veterinary.veterinary.dto.response.VaccineResponse;
import com.veterinary.veterinary.entity.Vaccine;
import org.springframework.stereotype.Component;

@Component
public class VaccineMapper {

    public Vaccine toEntity(VaccineRequest request) {
        if (request == null) return null;

        Vaccine vaccine = new Vaccine();
        vaccine.setName(request.getName());
        vaccine.setCode(request.getCode());
        vaccine.setProtectionStartDate(request.getProtectionStartDate());
        vaccine.setProtectionFinishDate(request.getProtectionFinishDate());
        return vaccine;
    }

    public VaccineResponse toResponse(Vaccine vaccine) {
        if (vaccine == null) return null;

        VaccineResponse response = new VaccineResponse();
        response.setId(vaccine.getId());
        response.setName(vaccine.getName());
        response.setCode(vaccine.getCode());
        response.setProtectionStartDate(vaccine.getProtectionStartDate());
        response.setProtectionFinishDate(vaccine.getProtectionFinishDate());
        return response;
    }
}
