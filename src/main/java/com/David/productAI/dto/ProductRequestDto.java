package com.David.productAI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank
        @Size(max = 30)
        String name,
        String description,
        BigDecimal price
) {
}
