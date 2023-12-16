package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "avaliacao_produto")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AvaliacaoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer nota;
    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn
    private Produto produto;


    @ManyToOne(targetEntity = Pessoa.class)
    private Pessoa empresa;
}
