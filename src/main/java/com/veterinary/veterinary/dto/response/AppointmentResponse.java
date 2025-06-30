package com.veterinary.veterinary.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AppointmentResponse {
    private Long id;
    private LocalDateTime appointmentDate;
    private Long doctorId;
    private String doctorName;
    private Long animalId;
    private String animalName;

}
