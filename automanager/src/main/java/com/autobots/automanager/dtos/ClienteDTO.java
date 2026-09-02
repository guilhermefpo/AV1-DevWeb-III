package com.autobots.automanager.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String nomeSocial;
    private Date dataNascimento;
    private Date dataCadastro;
    private EnderecoDTO endereco;
    private List<DocumentoDTO> documentos;
    private List<TelefoneDTO> telefones;
}