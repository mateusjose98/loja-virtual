package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



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
    @Column(nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Venda venda;
}
