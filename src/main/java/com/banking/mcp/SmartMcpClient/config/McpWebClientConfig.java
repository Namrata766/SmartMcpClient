package com.banking.mcp.SmartMcpClient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class McpWebClientConfig {

    @Value("${app.mcp.security.api-key}")
    private String apiKey;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .defaultHeader("X-API-Key", apiKey);
    }
}