package com.dti.iarefinamento.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dti.iarefinamento.service.RefinamentoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/refinamento")
public class RefinamentoController {

    private final RefinamentoService refinamentoService;

    public RefinamentoController(RefinamentoService refinamentoService) {
        this.refinamentoService = refinamentoService;
    }

    @PostMapping
    public Mono<String> getInsights(@RequestBody String transcricao) {
        return refinamentoService.gerarAnalise(transcricao);
    }
}
