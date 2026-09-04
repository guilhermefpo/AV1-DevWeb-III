package com.autobots.automanager.dtos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ClienteDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter exatamente 11 números")
    @NotBlank(message = "CPF é um campo obrigatório")
    private String cpf;
    private String nomeSocial;
    private Date dataNascimento;
    @NotNull(message = "Data cadastro é obrigatório")
    private Date dataCadastro;
    private EnderecoDTO endereco;
    private List<DocumentoDTO> documentos;
    private List<TelefoneDTO> telefones;
}