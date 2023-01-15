package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cupom_desconto")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CupomDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String descricao;
    private BigDecimal valorReal;
    private BigDecimal valorPorcentagem;
    private LocalDate dataValidadeCupom;

}
