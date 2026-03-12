package com.David.productAI.ai.prompt;

public final class AIPrompts {

    private AIPrompts() {
    }

    public static final String PRODUCT_DESCRIPTION = """
            You are an API assistant.
            Generate a short product description for customers in Spanish.
            Include the most important characteristics the customer should know and an estimated price.
            
            Product name: %s
            
            Return ONLY valid JSON. Do not include explanations, text, or markdown.
            JSON structure:
            {
                 "description": "short product description",
                 "price": number
            }
            
            Rules:
            - The description must be concise.
            - The description must sound realistic.
            - Price must be a realistic estimated price
            - Return only the content needed for the DTO.
            """;

    public static final String Product_Analysis = """
                            You are an API assistant.
            
                            Analyze the following product in Spanish.
            
                            Product name: %s
            
                            If the name does NOT appear to be a consumer product
                            (for example a person, city, animal, or abstract concept),
                            return this JSON:
            
                    {
                        "error": "Not a product(No es un producto)"
                    }
            
                    Otherwise return ONLY valid JSON:
            
                    {
                        "name": "product name",
                        "description": "Extensive product description, main and relevant properties",
                        "price": number,
                        "priceEvaluation": "Your opinion",
                        "category": "Your opinion"
            }
            
                        Rules:
                                          - The description must NOT repeat the product name
                                          - The description must expand the information with realistic features
                                          - Mention features like performance, materials, use cases or benefits
                                          - Include typical characteristics of this type of product
                                          - The description must sound like an e-commerce product description
                                          - Return JSON only
            """;
}

