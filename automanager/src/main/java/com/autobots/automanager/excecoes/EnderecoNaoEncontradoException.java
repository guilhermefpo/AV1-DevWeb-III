package com.autobots.automanager.excecoes;

public class EnderecoNaoEncontradoException extends RuntimeException {
    public EnderecoNaoEncontradoException(long id) {
        super("Endereco não encontrado com o id: " + id);
    }
}
