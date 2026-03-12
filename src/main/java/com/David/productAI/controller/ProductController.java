package com.David.productAI.controller;

import com.David.productAI.ai.dto.ProductAnalysisAIRequestDto;
import com.David.productAI.ai.dto.ProductAnalysisAIResponseDto;
import com.David.productAI.dto.ProductRequestDto;
import com.David.productAI.dto.ProductResponseDto;
import com.David.productAI.dto.ProductUpdateRequestDto;

import com.David.productAI.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDto> findAllProducts(){
        return productService.findAllProducts();
    }

    @PostMapping
    public ProductResponseDto createProduct(@Valid @RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }

    @PatchMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id,
                                            @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return productService.updateProduct(id, productUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public ProductResponseDto deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public ProductResponseDto findProductId(@PathVariable Long id){
        return productService.findProductId(id);
    }

    @GetMapping("/name")
    public List<ProductResponseDto> findByName(@RequestParam String name){
        return productService.findByName(name);
    }

    @GetMapping("/price")
    public List<ProductResponseDto> findByPriceBetween(@RequestParam BigDecimal min,
                                                        @RequestParam BigDecimal max){
        return productService.findByPriceBetween(min, max);
    }

    @PostMapping("/ai-create")
    public ProductResponseDto createProductWithAI(@Valid @RequestBody ProductRequestDto productRequestDto){
        return productService.createProductWithAI(productRequestDto);
    }

    @PostMapping("/ai-analysis")
    public ProductAnalysisAIResponseDto generateProductAnalysis(@Valid @RequestBody ProductAnalysisAIRequestDto productAnalisysAIRequestDto){
        return productService.generateProductAnalisysAI(productAnalisysAIRequestDto);
    }

}
