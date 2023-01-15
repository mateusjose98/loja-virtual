package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item_venda")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Double quantidade;
    @ManyToOne @JoinColumn
    private Produto produto;
    @ManyToOne @JoinColumn
    private Venda venda;
}
