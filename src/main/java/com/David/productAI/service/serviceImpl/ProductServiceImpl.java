package com.David.productAI.service.serviceImpl;

import com.David.productAI.ai.dto.ProductAnalysisAIRequestDto;
import com.David.productAI.ai.dto.ProductAnalysisAIResponseDto;
import com.David.productAI.ai.service.AIService;
import com.David.productAI.ai.service.serviceImpl.AIServiceImpl;
import com.David.productAI.ai.dto.ProductDescriptionAIResponseDto;
import com.David.productAI.dto.ProductRequestDto;
import com.David.productAI.dto.ProductResponseDto;
import com.David.productAI.dto.ProductUpdateRequestDto;
import com.David.productAI.exception.ProductNotFoundException;
import com.David.productAI.mapper.ProductMapper;
import com.David.productAI.model.Product;
import com.David.productAI.repository.ProductRepository;
import com.David.productAI.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final AIService aiService;

    public ProductServiceImpl(ProductRepository productRepository, AIServiceImpl aiService) {
        this.productRepository = productRepository;
        this.aiService = aiService;
    }


    @Override
    public List<ProductResponseDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toMapDto)
                .toList();
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = ProductMapper.toProductEntity(productRequestDto);

        Product productSaved = productRepository.save(product);

        return ProductMapper.toMapDto(productSaved);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductUpdateRequestDto productUpdateRequestDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        if(productUpdateRequestDto.name() != null){
            product.setName(productUpdateRequestDto.name());
        }

        if(productUpdateRequestDto.description() != null){
            product.setDescription(productUpdateRequestDto.description());
        }

        if(productUpdateRequestDto.price() != null){
            product.setPrice(productUpdateRequestDto.price());
        }

        Product productUpdate = productRepository.save(product);

        return ProductMapper.toMapDto(productUpdate);
    }

    @Override
    public ProductResponseDto deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        productRepository.delete(product);

        return ProductMapper.toMapDto(product);
    }

    @Override
    public ProductResponseDto findProductId(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return ProductMapper.toMapDto(product);
    }

    @Override
    public List<ProductResponseDto> findByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(ProductMapper::toMapDto)
                .toList();
    }

    @Override
    public List<ProductResponseDto> findByPriceBetween(BigDecimal min, BigDecimal max) {
        return productRepository.findByPriceBetweenOrderByPriceAsc(min, max)
                .stream()
                .map(ProductMapper::toMapDto)
                .toList();
    }

    @Override
    public ProductResponseDto createProductWithAI(ProductRequestDto productRequestDto) {

        //Llamamos al método de respuesta de la AI
        ProductDescriptionAIResponseDto aiResponseDto = aiService.generateProductDescription(productRequestDto.name());

        Product product = ProductMapper.toProductEntity(productRequestDto);

        product.setDescription(aiResponseDto.description());

        product.setPrice(aiResponseDto.price());

        Product savedProduct = productRepository.save(product);

        return ProductMapper.toMapDto(savedProduct);
    }

    @Override
    public ProductAnalysisAIResponseDto generateProductAnalisysAI(ProductAnalysisAIRequestDto productAnalisysAIRequestDto) {

        return aiService.generateProductAnalysis(productAnalisysAIRequestDto.name());




    }
}
