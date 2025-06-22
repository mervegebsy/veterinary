package com.veterinary.veterinary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailableDateResponse {
    private Long id;
    private LocalDate availableDate;
    private Long doctorId;
    private String doctorName;
}
