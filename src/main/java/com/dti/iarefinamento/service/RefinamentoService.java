package com.dti.iarefinamento.service;

import reactor.core.publisher.Mono;

public interface RefinamentoService {

	Mono<String> gerarAnalise(String transcricao);

}
