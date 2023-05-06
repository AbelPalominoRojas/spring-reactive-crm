package com.pirqana.springreactivecrm.application.service.impl;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaFilterDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaSaveDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.mapper.CuentaFilterMapper;
import com.pirqana.springreactivecrm.application.dto.cuenta.mapper.CuentaMapper;
import com.pirqana.springreactivecrm.application.dto.cuenta.mapper.CuentaSaveMapper;
import com.pirqana.springreactivecrm.application.service.CuentaService;
import com.pirqana.springreactivecrm.persistence.repository.CuentaRepository;
import com.pirqana.springreactivecrm.shared.pagination.PageFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final CuentaMapper cuentaMapper;
    private final CuentaSaveMapper cuentaSaveMapper;
    private final CuentaFilterMapper cuentaFilterMapper;

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

    @Override
    public Mono<CuentaDto> create(CuentaSaveDto cuentaSaveDto) {
        var cuenta = cuentaSaveMapper.toCuenta(cuentaSaveDto);
        cuenta.setEstado("A");

        return cuentaRepository.save(cuenta).map(cuentaMapper::toCuentaDto);
    }

    @Override
    public Mono<CuentaDto> edit(String id, CuentaSaveDto cuentaSaveDto) {
        var cuentaDb = cuentaRepository.findById(id);

        var cuenta = cuentaSaveMapper.toCuenta(cuentaSaveDto);

        cuentaDb.subscribe(c -> {
            cuenta.setId(c.getId());
            cuenta.setEstado(c.getEstado());
        });

        return cuentaRepository.save(cuenta).map(cuentaMapper::toCuentaDto);
    }

    @Override
    public Mono<CuentaDto> disable(String id) {
        var cuenta = cuentaRepository.findById(id);

        return cuenta.flatMap(c -> {
            c.setEstado("E");

            return cuentaRepository.save(c).map(cuentaMapper::toCuentaDto);
        });
    }

    @Override
    public Mono<Page<CuentaDto>> pagination(PageFilter<CuentaFilterDto> pageFilter) {
        Pageable pageable = PageRequest.of(pageFilter.getPage(), pageFilter.getSize());

        var cuenta = cuentaFilterMapper.toCuenta(
                pageFilter.getFilter().orElse(new CuentaFilterDto())
        );

        var cuentaPage = cuentaRepository.filter(cuenta).count()
                .flatMap(cuentaCount -> {
                    return cuentaRepository.filter(cuenta)
                            .buffer(pageable.getPageSize(), (pageable.getPageNumber() + 1))
                            .elementAt(pageable.getPageNumber(), new ArrayList<>())
                            .flatMap(cuentas -> {
                                Page<CuentaDto> p = new PageImpl<CuentaDto>(cuentaMapper.toCuentaDtos(cuentas), pageable, cuentaCount);
                                return Mono.just(p);
                            });
                });

        return cuentaPage;
    }
}
