package com.pirqana.springreactivecrm.application.dto.cuenta.mapper;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaSaveDto;
import com.pirqana.springreactivecrm.persistence.entity.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CuentaSaveMapper {
    @Mapping(source = "empresa", target = "empresa")
    @Mapping(source = "ruc", target = "ruc")
    @Mapping(source = "razonSocial", target = "razonSocial")
    @Mapping(source = "contrato", target = "contrato")
    @Mapping(source = "pagoMensual", target = "pagoMensual")
    @Mapping(source = "fechaInicio", target = "fechaInicio")
    @Mapping(source = "fechaFin", target = "fechaFin")
    Cuenta toCuenta(CuentaSaveDto cuentaSaveDto);
}
