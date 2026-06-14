package com.anant.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RagServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RagServiceApplication.class, args);
	}

	@Bean
	ChatClient chatClient(ChatModel chatModel) {
		return ChatClient.create(chatModel);
	}
}