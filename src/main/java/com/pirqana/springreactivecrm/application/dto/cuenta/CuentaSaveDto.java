package com.pirqana.springreactivecrm.application.dto.cuenta;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CuentaSaveDto {
    @NotEmpty
    private String empresa;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String ruc;

    @NotEmpty
    private String razonSocial;

    private String contrato;

    @PositiveOrZero
    private String pagoMensual;

    private String fechaInicio;

    private String fechaFin;
}
