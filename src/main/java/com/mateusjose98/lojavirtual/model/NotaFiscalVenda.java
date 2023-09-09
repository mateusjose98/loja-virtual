package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "nota_fiscal_venda")
@Getter
@Setter
public class NotaFiscalVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String numeroNota;
    private String serieNota;
    @Column(nullable = false)
    private String descricao;
    @Column(columnDefinition = "TEXT")
    private String xml;
    @Column(columnDefinition = "TEXT")
    private String pdf;
    @OneToOne(mappedBy = "notaFiscalVenda")
    private Venda venda;

}
