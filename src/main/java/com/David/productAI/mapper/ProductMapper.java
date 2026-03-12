package com.David.productAI.mapper;

import com.David.productAI.dto.ProductRequestDto;
import com.David.productAI.dto.ProductResponseDto;
import com.David.productAI.model.Product;

public class ProductMapper {

    private ProductMapper(){} //Evita que se instancie

    //DTO -> ENTITY
    public static Product toProductEntity(ProductRequestDto productRequestDto){

        Product product = new Product();

        product.setName(productRequestDto.name());
        product.setDescription(productRequestDto.description());
        product.setPrice(productRequestDto.price());


        return product;
    }

    //ENTITY -> DTO
    public static ProductResponseDto toMapDto(Product product){
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()

        );
    }
}
