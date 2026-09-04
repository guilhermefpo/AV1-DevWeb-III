package com.autobots.automanager.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DocumentoDTO {
    private String tipo;
    @NotBlank(message = "Número é um campo obrigatório")
    private String numero;
}