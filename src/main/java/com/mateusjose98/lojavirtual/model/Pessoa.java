package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Endereco> enderecos = new HashSet<>();
}
