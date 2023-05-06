package com.pirqana.springreactivecrm.application.dto.cuenta.mapper;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaFilterDto;
import com.pirqana.springreactivecrm.persistence.entity.Cuenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaFilterMapper {

    @Mapping(source = "empresa", target = "empresa")
    @Mapping(source = "ruc", target = "ruc")
    @Mapping(source = "estado", target = "estado")
    CuentaFilterDto toCuentaFilterDto(Cuenta cuenta);

    List<CuentaFilterDto> toCuentaFilterDtos(List<Cuenta> cuentas);

    @InheritInverseConfiguration
    Cuenta toCuenta(CuentaFilterDto cuentaFilterDto);
}
