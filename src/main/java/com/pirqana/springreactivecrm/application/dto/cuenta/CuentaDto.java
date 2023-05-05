package com.pirqana.springreactivecrm.application.dto.cuenta;

import lombok.Data;

@Data
public class CuentaDto {
    private String id;

    private String empresa;

    private String ruc;

    private String razonSocial;

    private String contrato;

    private String pagoMensual;

    private String fechaInicio;

    private String fechaFin;

    private String estado;
}

