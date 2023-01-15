package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
