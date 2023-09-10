package com.mateusjose98.lojavirtual.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UsuarioDTO {


    private Long id;
    private String login;
    private LocalDate dataUltimaAtualizacaoSenha;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.dataUltimaAtualizacaoSenha = usuario.getDataUltimaAtualizacaoSenha();
        this.login = usuario.getLogin();
    }

}
