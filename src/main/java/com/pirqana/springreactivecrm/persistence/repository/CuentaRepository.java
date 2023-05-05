package com.pirqana.springreactivecrm.persistence.repository;

import com.pirqana.springreactivecrm.persistence.entity.Cuenta;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CuentaRepository extends ReactiveMongoRepository<Cuenta, String> {
}
