package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String tipoUnidade;
    private String nome;
    @Column(columnDefinition = "TEXT", length = 500)
    private String descricao;
    private Double peso;
    private Double largura;
    private Double altura;
    private Double profundidade;
    private BigDecimal valorVenda;
    private Integer quantidadeEstoque;
    private Integer quantidadeMinimaEstoque;
    private String linkVideo;
    private Boolean alertaQuantidadeEstoqueAtivo;
    private Integer quantidadeClick;

}
