package com.autobots.automanager.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String estado;
    @NotBlank(message = "Cidade é um campo obrigatório")
    private String cidade;
    private String bairro;
    @NotBlank(message = "Rua é um campo obrigatório")
    private String rua;
    @NotBlank(message = "Número é um campo obrigatório")
    private String numero;
    private String codigoPostal;
    private String informacoesAdicionais;
}
