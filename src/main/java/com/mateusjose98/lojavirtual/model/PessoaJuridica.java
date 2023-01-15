package com.mateusjose98.lojavirtual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

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
    private String nomeFantasia;
    private String razaoSocial;
    private String categoria;
}
