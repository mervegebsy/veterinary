package com.veterinary.veterinary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponse {
    private Long id;
    private LocalDateTime appointmentDate;
    private Long doctorId;
    private String doctorName;
    private Long animalId;
    private String animalName;

}
