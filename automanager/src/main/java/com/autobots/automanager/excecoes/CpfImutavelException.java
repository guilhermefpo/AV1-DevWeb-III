package com.autobots.automanager.excecoes;

public class CpfImutavelException extends RuntimeException {
    public CpfImutavelException() {
        super("CPF não pode ser alterado");
    }
}