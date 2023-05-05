package com.pirqana.springreactivecrm.api.controller;


import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import com.pirqana.springreactivecrm.application.service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("cuentas")
@RequiredArgsConstructor
@RestController
public class CuentaController {
    private final CuentaService cuentaService;


    @GetMapping
    public ResponseEntity<Flux<CuentaDto>> findAll(){
        return ResponseEntity.ok(cuentaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<CuentaDto>>findById(@PathVariable("id") String id){
        return ResponseEntity.ok(cuentaService.findById(id));
    }

}
