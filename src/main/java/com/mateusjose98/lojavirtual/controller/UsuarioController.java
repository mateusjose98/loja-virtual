package com.mateusjose98.lojavirtual.controller;


import com.mateusjose98.lojavirtual.mappers.UsuarioMapper;
import com.mateusjose98.lojavirtual.model.UsuarioDTO;
import com.mateusjose98.lojavirtual.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    final UsuarioMapper usuarioMapper;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UsuarioDTO> criar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        usuarioDTO = usuarioService.criar(usuarioMapper.toEntity(usuarioDTO));
        return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
    }

}
