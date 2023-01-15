package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marca_produto")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MarcaProduto implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String descricao;


}
