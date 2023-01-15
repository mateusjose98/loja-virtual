package com.mateusjose98.lojavirtual.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "status_rastreio")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StatusRastreio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String centroDistribuicao;
    private String cidade;
    private String estado;
    private String status;
    @ManyToOne
    @JoinColumn
    private Venda venda;
}
