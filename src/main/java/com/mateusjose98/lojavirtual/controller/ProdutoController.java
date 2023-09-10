package com.mateusjose98.lojavirtual.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
@Log4j2
public class ProdutoController {

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok("teste");
    }
}
