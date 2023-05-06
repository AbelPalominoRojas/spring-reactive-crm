package com.pirqana.springreactivecrm.application.service;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaFilterDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaSaveDto;
import com.pirqana.springreactivecrm.shared.pagination.PageFilter;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CuentaService {
    Flux<CuentaDto> findAll();

    Mono<CuentaDto> findById(String id);

    Mono<CuentaDto> create(CuentaSaveDto cuentaSaveDto);

    Mono<CuentaDto> edit(String id, CuentaSaveDto cuentaSaveDto);

    Mono<CuentaDto> disable(String id);

    Mono<Page<CuentaDto>> pagination(PageFilter<CuentaFilterDto> pageFilter);
}
