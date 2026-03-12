package com.David.productAI.ai.service;

import com.David.productAI.ai.dto.ProductAnalysisAIResponseDto;
import com.David.productAI.ai.dto.ProductDescriptionAIResponseDto;

public interface AIService {

    ProductDescriptionAIResponseDto generateProductDescription(String productName);

    ProductAnalysisAIResponseDto generateProductAnalysis(String productName);
}
