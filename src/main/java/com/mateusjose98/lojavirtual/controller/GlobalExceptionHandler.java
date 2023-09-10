package com.mateusjose98.lojavirtual.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    record DefaultError(String userMessage, int statusCode, String devMessage){}

    @ExceptionHandler
    public ResponseEntity<DefaultError> handleInvalidCredentialsException(
            BadCredentialsException ex) {
        log.error("Erro ao autenticar usuário, mensagem: {}", ex.getMessage());
        return new ResponseEntity<DefaultError>(new DefaultError("Credenciais inválidas", 401, ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
