package com.autobots.automanager.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class TelefoneDTO {
    private Long id;
    @Pattern(regexp = "^\\d{2}$", message = "DDD deve conter exatamente 2 números")
    @NotBlank(message = "DDD é um campo obrigatório")
    private String ddd;

    @NotBlank(message = "Número é um campo obrigatório")
    private String numero;
}