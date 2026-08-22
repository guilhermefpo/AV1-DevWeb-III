package com.autobots.automanager.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrosRespostas {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleClienteNaoEncontrado(
            ClienteNaoEncontradoException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleDadosInvalidos(
            IllegalArgumentException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {

        ErrorResponse response = new ErrorResponse(
                "Erro interno do servidor",
                HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    public record ErrorResponse(String message, int status) {
    }
}