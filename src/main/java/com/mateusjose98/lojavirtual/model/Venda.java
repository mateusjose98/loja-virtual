package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn
    private Endereco enderecoEntrega;

    @ManyToOne
    @JoinColumn
    private Endereco enderecoCobranca;
    @Column(nullable = false)
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
    @Column(nullable = false)
    private LocalDate vendaEm;
    private LocalDate entregaEm;

    @ManyToOne(targetEntity = Pessoa.class)
    private Pessoa empresa;

}
