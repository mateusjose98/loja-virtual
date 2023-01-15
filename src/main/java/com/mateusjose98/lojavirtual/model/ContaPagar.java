package com.mateusjose98.lojavirtual.model;

import com.mateusjose98.lojavirtual.enums.StatusContaPagar;
import com.mateusjose98.lojavirtual.enums.StatusContaReceber;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "conta_pagar")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContaPagar implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String descricao;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoaFornecedor;

    @Enumerated(EnumType.STRING)
    private StatusContaPagar status;

}
