package com.David.productAI.ai.dto;

import java.math.BigDecimal;

public record ProductDescriptionAIResponseDto(
        String description,
        BigDecimal price
) {
}
