package com.dti.iarefinamento.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dti.iarefinamento.service.IntegracaoOpenAI;
import com.dti.iarefinamento.service.TranscricaoService;

import reactor.core.publisher.Mono;

@Service
public class TranscricaoServiceImpl implements TranscricaoService {
	
	private final IntegracaoOpenAI integracaoOpenAI;
	
	public TranscricaoServiceImpl(IntegracaoOpenAI integracaoOpenAI ) {
		this.integracaoOpenAI = integracaoOpenAI;
	}
	
	@Override
	public Mono<String> realizarTranscricao(MultipartFile file) throws IOException{
		return integracaoOpenAI.realizarTranscricao(file);
	}

}
