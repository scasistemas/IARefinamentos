package com.dti.iarefinamento.service;


import reactor.core.publisher.Mono;

public interface IntegracaoOpenAI {

	Mono<String> getAnalisesTranscricao(String transcricao);

}
