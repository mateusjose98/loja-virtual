package com.mateusjose98.lojavirtual.enums;

public enum StatusContaReceber {
    COBRANCA("Pagar"),
    VENCIDA("Vencida"),
    ABERTA("Aberta"),
    QUITADA("Quitada");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    private StatusContaReceber (String descricao) {
        this.descricao = descricao;
    }
}
