package com.dti.iarefinamento.service;

import java.util.Optional;

public interface IntegracaoOpenAI {

	Optional<String> getAnalisesTranscricao(String transcricao);

}
