package com.autobots.automanager.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TelefoneDTO {
    @NotBlank(message = "DDD é um campo obrigatório")
    private String ddd;
    @NotBlank(message = "Número é um campo obrigatório")
    private String numero;
}