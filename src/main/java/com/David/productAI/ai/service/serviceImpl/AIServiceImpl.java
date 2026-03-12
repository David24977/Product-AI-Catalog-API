package com.David.productAI.ai.service.serviceImpl;

import com.David.productAI.ai.dto.ProductAnalysisAIResponseDto;
import com.David.productAI.ai.prompt.AIPrompts;
import com.David.productAI.ai.service.AIService;
import com.David.productAI.ai.dto.ProductDescriptionAIResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {
    private final ChatClient chatClient;

    public AIServiceImpl(ChatClient chatClient) {

        this.chatClient = chatClient;
    }

    public ProductDescriptionAIResponseDto generateProductDescription(String productName){
        String prompt = AIPrompts.PRODUCT_DESCRIPTION.formatted(productName);//Utilizo la clase AIPrompts
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .entity(ProductDescriptionAIResponseDto.class);

    }

    @Override
    public ProductAnalysisAIResponseDto generateProductAnalysis(String productName) {
       String prompt = AIPrompts.Product_Analysis.formatted(productName);

       return chatClient
               .prompt()
               .user(prompt)
               .call()
               .entity(ProductAnalysisAIResponseDto.class);
    }
}
