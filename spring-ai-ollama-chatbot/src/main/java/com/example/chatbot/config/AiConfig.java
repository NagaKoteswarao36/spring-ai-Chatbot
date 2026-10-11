package com.example.chatbot.config;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AiConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem("You are a helpful, clear, and friendly assistant. Give accurate answers and use examples when useful.").build();
    }
}
