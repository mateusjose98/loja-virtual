package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "nota_fiscal_compra")
@Getter
@Setter
public class NotaFiscalCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String numeroNota;
    @Column(nullable = false)
    private String serieNota;
    private String descricao;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    private BigDecimal valorICMS;
    @Column(nullable = false)
    private LocalDate dataCompra;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ContaPagar contaPagar;
}
