package com.David.productAI.exception;

import com.David.productAI.model.Product;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);
    }
}

