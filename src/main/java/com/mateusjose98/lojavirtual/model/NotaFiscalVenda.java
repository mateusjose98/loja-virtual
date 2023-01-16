package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
