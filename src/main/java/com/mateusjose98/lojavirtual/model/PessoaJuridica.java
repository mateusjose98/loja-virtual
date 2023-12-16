package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoa_juridica")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa{
    @Column(nullable = false)
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String razaoSocial;
    private String categoria;
}
