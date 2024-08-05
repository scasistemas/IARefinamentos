package com.dti.iarefinamento.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dti.iarefinamento.service.IntegracaoOpenAI;
import com.dti.iarefinamento.service.RefinamentoService;

@Service
public class RefinamentoServiceImpl implements RefinamentoService {
	
	private final IntegracaoOpenAI integracaoOpenAI;
	
	public RefinamentoServiceImpl(IntegracaoOpenAI integracaoOpenAI) {
		this.integracaoOpenAI = integracaoOpenAI;
	}
	
	@Override
	public String gerarAnalise(String transcricao) {
		Optional<String> analise= integracaoOpenAI.getAnalisesTranscricao(transcricao);
		return analise.get();
	}
}
