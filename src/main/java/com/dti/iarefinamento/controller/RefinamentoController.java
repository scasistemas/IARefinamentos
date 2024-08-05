package com.dti.iarefinamento.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dti.iarefinamento.service.RefinamentoService;

@RestController
@RequestMapping("/api/v1/refinamento")
public class RefinamentoController {

    private final RefinamentoService refinamentoService;

    public RefinamentoController(RefinamentoService refinamentoService) {
        this.refinamentoService = refinamentoService;
    }

    @PostMapping
    public String getInsights(@RequestBody String transcricao) {
        return refinamentoService.gerarAnalise(transcricao);
    }
}
