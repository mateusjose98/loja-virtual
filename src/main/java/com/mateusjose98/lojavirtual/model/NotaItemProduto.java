package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "nota_item_produto")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NotaItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Double quantidade;
    @ManyToOne
    @JoinColumn
    private NotaFiscalCompra notaFiscalCompra;
    @ManyToOne
    @JoinColumn
    private Produto produto;


}
