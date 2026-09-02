package com.autobots.automanager.excecoes;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

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

        @ExceptionHandler(DocumentoNaoEncontradoException.class)
        public ResponseEntity<ErrorResponse> handleDocumentoNaoEncontrado(
                        DocumentoNaoEncontradoException ex) {
                ErrorResponse response = new ErrorResponse(
                                ex.getMessage(),
                                HttpStatus.NOT_FOUND.value());

                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(response);

        }

        @ExceptionHandler(EnderecoNaoEncontradoException.class)
        public ResponseEntity<ErrorResponse> handleEnderecoNaoEncontrado(
                        EnderecoNaoEncontradoException ex) {
                ErrorResponse response = new ErrorResponse(
                                ex.getMessage(),
                                HttpStatus.NOT_FOUND.value());

                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(response);

        }

        @ExceptionHandler(TelefoneNaoEncontradoException.class)
        public ResponseEntity<ErrorResponse> handleTelefoneNaoEncontrado(
                        TelefoneNaoEncontradoException ex) {
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

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidation(
                        MethodArgumentNotValidException ex) {

                String mensagem = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                                .findFirst()
                                .orElse("Dados inválidos");

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(new ErrorResponse(
                                                mensagem,
                                                HttpStatus.BAD_REQUEST.value()));
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<ErrorResponse> handleJsonInvalido(
                        HttpMessageNotReadableException ex) {

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(new ErrorResponse(
                                                "JSON inválido ou dados em formato incorreto",
                                                HttpStatus.BAD_REQUEST.value()));
        }

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<ErrorResponse> handleTipoInvalido(
                        MethodArgumentTypeMismatchException ex) {

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(new ErrorResponse(
                                                "Parâmetro '" + ex.getName() + "' possui valor inválido",
                                                HttpStatus.BAD_REQUEST.value()));
        }

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleEntityNotFound(
                        EntityNotFoundException ex) {

                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(new ErrorResponse(
                                                "Recurso não encontrado",
                                                HttpStatus.NOT_FOUND.value()));
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ErrorResponse> handleIntegridadeBanco(
                        DataIntegrityViolationException ex) {

                ErrorResponse response = new ErrorResponse(
                                "Registro já cadastrado ou viola uma restrição de dados.",
                                HttpStatus.CONFLICT.value());

                return ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .body(response);
        }

        @ExceptionHandler(ClienteJaCadastradoException.class)
        public ResponseEntity<ErrorResponse> handleClienteJaCadastrado(
                        ClienteJaCadastradoException ex) {

                ErrorResponse response = new ErrorResponse(
                                ex.getMessage(),
                                HttpStatus.CONFLICT.value());

                return ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .body(response);
        }

        @ExceptionHandler(DocumentoJaCadastradoException.class)
        public ResponseEntity<ErrorResponse> handleDocumentoJaCadastrado(
                        DocumentoJaCadastradoException ex) {

                ErrorResponse response = new ErrorResponse(
                                ex.getMessage(),
                                HttpStatus.CONFLICT.value());

                return ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .body(response);
        }

        @ExceptionHandler(TelefoneJaCadastradoException.class)
        public ResponseEntity<ErrorResponse> handleTelefoneJaCadastrado(
                        TelefoneJaCadastradoException ex) {

                ErrorResponse response = new ErrorResponse(
                                ex.getMessage(),
                                HttpStatus.CONFLICT.value());

                return ResponseEntity
                                .status(HttpStatus.CONFLICT)
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