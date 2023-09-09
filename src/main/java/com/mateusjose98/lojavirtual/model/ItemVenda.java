package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



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
    @Column(nullable = false)
    private Double quantidade;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;
    @ManyToOne @JoinColumn(nullable = false)
    private Venda venda;
}
