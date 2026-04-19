package com.banking.mcp.SmartMcpClient.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient mcpChatClient(ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider) {
        return builder.defaultToolCallbacks(toolCallbackProvider).build();
    }
}