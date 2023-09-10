package com.mateusjose98.lojavirtual.controller;

import com.mateusjose98.lojavirtual.service.AcessoService;
import com.mateusjose98.lojavirtual.model.Acesso;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessos")
@RequiredArgsConstructor
public class AcessoController {

    final AcessoService acessoService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(List.of("acessos"));
    }

    @PostMapping
    public void salvar(@RequestBody Acesso acesso) {
        acessoService.cadastrar(acesso);
    }
}
