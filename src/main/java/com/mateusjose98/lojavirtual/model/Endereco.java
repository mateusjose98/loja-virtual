package com.mateusjose98.lojavirtual.model;

import com.mateusjose98.lojavirtual.enums.TipoEndereco;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "endereco")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String logradouro;

    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

}
