package com.banking.mcp.SmartMcpClient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/fraud")
public class FraudChatController {

    private final ChatClient chatClient;

    public FraudChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping("/analyze")
    public String analyze(@RequestBody String query) {

        log.info("Received fraud analysis request: {}", query);
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}