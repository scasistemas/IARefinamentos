package com.dti.iarefinamento.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import reactor.core.publisher.Mono;

public interface TranscricaoService {

	Mono<String> realizarTranscricao(MultipartFile file) throws IOException;

}
