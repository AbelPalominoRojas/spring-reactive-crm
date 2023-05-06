package com.pirqana.springreactivecrm.persistence.repository;

import com.pirqana.springreactivecrm.persistence.entity.Cuenta;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface CuentaRepository extends ReactiveMongoRepository<Cuenta, String> {
    @Query("{" +
            "'empresa': {$regex: :#{#cuenta.empresa}, $options: 'i'}" +
            "'ruc': {$regex: :#{#cuenta.ruc}, $options: 'i'}" +
            "'estado': {$regex: :#{#cuenta.estado}, $options: 'i'}" +
            "}")
    Flux<Cuenta> filter(@Param("cuenta") Cuenta cuenta);
}
