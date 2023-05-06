package com.pirqana.springreactivecrm.application.dto.cuenta;

import lombok.Data;

@Data
public class CuentaFilterDto {
    private String empresa;

    private String ruc;

    private String estado;
}
