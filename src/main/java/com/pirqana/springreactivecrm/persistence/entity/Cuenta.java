package com.pirqana.springreactivecrm.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "cuentas")
public class Cuenta {

    @Id
    private String id;

    private String empresa;

    private String ruc;

    @Field(name = "razon_social")
    private String razonSocial;

    private String contrato;

    @Field(name = "pago_mensual")
    private String pagoMensual;

    @Field(name = "fecha_inicio")
    private String fechaInicio;

    @Field(name = "fecha_fin")
    private String fechaFin;

    private String estado;
}
