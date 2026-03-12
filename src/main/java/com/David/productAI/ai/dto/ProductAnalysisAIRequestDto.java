package com.David.productAI.ai.dto;

import java.math.BigDecimal;

public record ProductAnalysisAIRequestDto(
        String name,
        String description,
        BigDecimal price,
        String priceEvaluation,
        String category
) {
}
