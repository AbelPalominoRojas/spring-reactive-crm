package com.pirqana.springreactivecrm.application.service;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CuentaService {
    Flux<CuentaDto> findAll();
    Mono<CuentaDto> findById(String id);
}
