package com.David.productAI.service;

import com.David.productAI.ai.dto.ProductAnalysisAIRequestDto;
import com.David.productAI.ai.dto.ProductAnalysisAIResponseDto;
import com.David.productAI.dto.ProductRequestDto;
import com.David.productAI.dto.ProductResponseDto;
import com.David.productAI.dto.ProductUpdateRequestDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductResponseDto> findAllProducts();

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductUpdateRequestDto productRequestDto);

    ProductResponseDto deleteProduct(Long id);

    ProductResponseDto findProductId(Long id);

    List<ProductResponseDto> findByName(String name);

    List<ProductResponseDto> findByPriceBetween(BigDecimal min, BigDecimal max);

    ProductResponseDto createProductWithAI(ProductRequestDto productRequestDto);

    ProductAnalysisAIResponseDto generateProductAnalisysAI(ProductAnalysisAIRequestDto productAnalisysAIRequestDto);

}
