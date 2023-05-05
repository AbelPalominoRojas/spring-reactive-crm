package com.pirqana.springreactivecrm.application.service;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaSaveDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CuentaService {
    Flux<CuentaDto> findAll();

    Mono<CuentaDto> findById(String id);

    Mono<CuentaDto> create(CuentaSaveDto cuentaSaveDto);

    Mono<CuentaDto> edit(String id, CuentaSaveDto cuentaSaveDto);

    Mono<CuentaDto> disable(String id);
}
