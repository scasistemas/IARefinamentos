package com.dti.iarefinamento.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import reactor.core.publisher.Mono;

public interface IntegracaoOpenAI {

	Mono<String> getAnalisesTranscricao(String transcricao);

	Mono<String> realizarTranscricao(MultipartFile file) throws IOException;

}
