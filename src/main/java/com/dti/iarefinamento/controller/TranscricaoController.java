package com.dti.iarefinamento.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dti.iarefinamento.service.TranscricaoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/transcricoes")
public class TranscricaoController {

    private final TranscricaoService transcricaoService;

    public TranscricaoController(TranscricaoService transcricaoService) {
        this.transcricaoService = transcricaoService;
    }

    @PostMapping
    public Mono<String> transcribe(@RequestParam MultipartFile file) throws IOException {
        return transcricaoService.realizarTranscricao(file);
    }
}
