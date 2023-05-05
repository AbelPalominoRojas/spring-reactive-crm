package com.pirqana.springreactivecrm.application.service.impl;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.mapper.CuentaMapper;
import com.pirqana.springreactivecrm.application.service.CuentaService;
import com.pirqana.springreactivecrm.persistence.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final CuentaMapper cuentaMapper;


    @Override
    public Flux<CuentaDto> findAll() {
        var cuentas = cuentaRepository.findAll();

        return cuentas.map(cuentaMapper::toCuentaDto);
    }

    @Override
    public Mono<CuentaDto> findById(String id) {
        var cuenta = cuentaRepository.findById(id);

        return cuenta.map(cuentaMapper::toCuentaDto);
    }
}
