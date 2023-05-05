package com.pirqana.springreactivecrm.api.controller;


import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaSaveDto;
import com.pirqana.springreactivecrm.application.service.CuentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ResponseEntity<Mono<CuentaDto>> create(@Valid @RequestBody CuentaSaveDto cuentaSaveDto){
        return ResponseEntity.ok(cuentaService.create(cuentaSaveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<CuentaDto>> edit(@PathVariable("id") String id, @Valid @RequestBody CuentaSaveDto cuentaSaveDto){
        return ResponseEntity.ok(cuentaService.edit(id, cuentaSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<CuentaDto>> disable(@PathVariable("id") String id){
        return ResponseEntity.ok(cuentaService.disable(id));
    }

}
