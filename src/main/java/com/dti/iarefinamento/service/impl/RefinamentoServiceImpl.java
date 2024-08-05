package com.dti.iarefinamento.service.impl;

import org.springframework.stereotype.Service;

import com.dti.iarefinamento.service.IntegracaoOpenAI;
import com.dti.iarefinamento.service.RefinamentoService;

import reactor.core.publisher.Mono;

@Service
public class RefinamentoServiceImpl implements RefinamentoService {
	
	private final IntegracaoOpenAI integracaoOpenAI;
	
	public RefinamentoServiceImpl(IntegracaoOpenAI integracaoOpenAI) {
		this.integracaoOpenAI = integracaoOpenAI;
	}
	
	@Override
	public Mono<String> gerarAnalise(String transcricao) {
		Mono<String> analise= integracaoOpenAI.getAnalisesTranscricao(transcricao);
		return analise;
	}
}
