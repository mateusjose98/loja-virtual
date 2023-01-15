package com.mateusjose98.lojavirtual.enums;

public enum StatusContaPagar {
    COBRANCA("Pagar"),
    VENCIDA("Vencida"),
    ABERTA("Aberta"),
    QUITADA("Quitada"),
    NEGOCIADA("Renegociada");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    private StatusContaPagar(String descricao) {
        this.descricao = descricao;
    }
}
