package com.dti.iarefinamento.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dti.iarefinamento.service.IntegracaoOpenAI;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

//to do melhorar implementacao desta classe
@Service
public class IntegracaoOpenAIImpl implements IntegracaoOpenAI  {

	@Value("${openai.api.key}")
	private String openaiApiKey;

	@Value("${openai.api.base-url}")
	private String openaiBaseUrl;

	private final WebClient.Builder webClientBuilder;
	private WebClient webClient;

	public IntegracaoOpenAIImpl(WebClient.Builder webClientBuilder) {
		this.webClientBuilder = webClientBuilder;
	}
	
    @PostConstruct
    public void init() {
        this.webClient = this.webClientBuilder.baseUrl(openaiBaseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + openaiApiKey).build();
    }

	
	@Override
	public Mono<String> getAnalisesTranscricao(String transcricao) {
		Map<String, Object> requestBody = new HashMap<>();
	    requestBody.put("model", "gpt-3.5-turbo");
	    requestBody.put("messages", List.of(Map.of("role", "user", "content", transcricao)));

		try {
			return this.webClient.post().uri("/v1/chat/completions").contentType(MediaType.APPLICATION_JSON)
				.bodyValue(requestBody).retrieve().bodyToMono(String.class);
		}catch(Exception e) {
			String erro = e.getMessage();
			return null;
		}
	}
}
