package com.pirqana.springreactivecrm.api.controller;


import com.pirqana.springreactivecrm.persistence.entity.Cuenta;
import com.pirqana.springreactivecrm.persistence.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequestMapping("cuentas")
@RequiredArgsConstructor
@RestController
public class CuentaController {
    private final CuentaRepository cuentaRepository;


    @GetMapping
    public ResponseEntity<Flux<Cuenta>> findAll(){
        return ResponseEntity.ok(cuentaRepository.findAll());
    }

}
