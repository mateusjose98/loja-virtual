package com.mateusjose98.lojavirtual.enums;

public enum TipoEndereco {

    COBRANCA("Cobrança"), ENTREGA("Entrega");

    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }
}
