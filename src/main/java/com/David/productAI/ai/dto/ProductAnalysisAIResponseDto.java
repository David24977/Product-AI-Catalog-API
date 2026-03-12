package com.David.productAI.ai.dto;


import java.math.BigDecimal;

public record ProductAnalysisAIResponseDto(
       String name,
       String description,
       BigDecimal price,
       String priceEvaluation,
       String category,
       String error
) {
}
