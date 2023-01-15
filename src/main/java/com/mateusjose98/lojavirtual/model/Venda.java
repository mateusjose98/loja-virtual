package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "venda")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn
    private Endereco enderecoEntrega;

    @ManyToOne
    @JoinColumn
    private Endereco enderecoCobranca;

    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    @ManyToOne
    @JoinColumn
    private FormaPagamento formaPagamento;
    @OneToOne
    @JoinColumn
    private NotaFiscalVenda notaFiscalVenda;
    @ManyToOne
    @JoinColumn
    private CupomDesconto cupomDesconto;
    private BigDecimal valorFrete;
    private Integer diaEntrega;
    private LocalDate vendaEm;
    private LocalDate entregaEm;

}
