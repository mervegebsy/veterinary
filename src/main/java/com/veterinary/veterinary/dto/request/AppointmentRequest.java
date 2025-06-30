package com.veterinary.veterinary.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AppointmentRequest {

    private Long doctorId;

    private Long animalId;

    private LocalDateTime appointmentDate;
}
