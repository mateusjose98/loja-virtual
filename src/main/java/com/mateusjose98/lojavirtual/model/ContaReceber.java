package com.mateusjose98.lojavirtual.model;

import com.mateusjose98.lojavirtual.enums.StatusContaReceber;
import com.mateusjose98.lojavirtual.enums.TipoEndereco;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "conta_receber")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContaReceber implements Serializable {

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

    @Enumerated(EnumType.STRING)
    private StatusContaReceber status;

}
