package com.pirqana.springreactivecrm.application.dto.cuenta.mapper;

import com.pirqana.springreactivecrm.application.dto.cuenta.CuentaDto;
import com.pirqana.springreactivecrm.persistence.entity.Cuenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "empresa", target = "empresa")
    @Mapping(source = "ruc", target = "ruc")
    @Mapping(source = "razonSocial", target = "razonSocial")
    @Mapping(source = "contrato", target = "contrato")
    @Mapping(source = "pagoMensual", target = "pagoMensual")
    @Mapping(source = "fechaInicio", target = "fechaInicio")
    @Mapping(source = "fechaFin", target = "fechaFin")
    @Mapping(source = "estado", target = "estado")
    CuentaDto toCuentaDto(Cuenta cuenta);

    List<CuentaDto> toCuentaDtos(List<Cuenta> cuentas);

    @InheritInverseConfiguration
    Cuenta toCuenta(CuentaDto cuentaDto);
}
