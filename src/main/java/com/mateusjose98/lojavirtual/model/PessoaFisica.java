package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa_fisica")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa{
    @Column(nullable = false)
    private String cpf;

    private LocalDate dataNascimento;
}
