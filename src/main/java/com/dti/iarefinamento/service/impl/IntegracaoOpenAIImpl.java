package com.dti.iarefinamento.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dti.iarefinamento.service.IntegracaoOpenAI;

@Service
public class IntegracaoOpenAIImpl implements IntegracaoOpenAI  {

	@Value("${openai.api.key}")
	private String openaiApiKey;

	@Value("${openai.api.base-url}")
	private String openaiBaseUrl;

	private final WebClient webClient;

	public IntegracaoOpenAIImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(openaiBaseUrl)
				.defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + openaiApiKey).build();
	}

	//to do melhorar implementacao deste metodo
	@Override
	public Optional<String> getAnalisesTranscricao(String transcricao) {
		String escapedTranscricao = transcricao.replace("\\", "\\\\").replace("\"", "\\\"");
		String requestBody = String.format(
				"{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}",
				escapedTranscricao);

		return Optional.ofNullable(webClient.post().uri("/v1/chat/completions").contentType(MediaType.APPLICATION_JSON)
				.bodyValue(requestBody).retrieve().bodyToMono(String.class).block());
	}
}
