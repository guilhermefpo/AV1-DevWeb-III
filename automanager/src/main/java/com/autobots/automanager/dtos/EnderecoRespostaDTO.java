package com.autobots.automanager.dtos;

import lombok.Data;

@Data
public class EnderecoRespostaDTO {
    private Long id;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String informacoesAdicionais;
}
