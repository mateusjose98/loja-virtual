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
    private String numeroNota;
    private String serieNota;
    private String descricao;
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    private BigDecimal valorICMS;
    private LocalDate dataCompra;
    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn
    private ContaPagar contaPagar;
}