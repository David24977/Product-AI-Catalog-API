package com.David.productAI.dto;

import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductUpdateRequestDto(
        @Size(max = 30)
        String name,
        String description,
        BigDecimal price
) {
}
