package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "imagem_produto")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ImagemProduto implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String imagemOriginal;
    private String imagemMiniatura;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;


    @ManyToOne(targetEntity = Pessoa.class)
    private Pessoa empresa;


}
