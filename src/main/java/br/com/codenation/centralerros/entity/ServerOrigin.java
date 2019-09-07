package br.com.codenation.centralerros.entity;

public enum ServerOrigin {

    PRODUCAO("PRD"),
    HOMOLOGACAO("HML"),
    DESENVOLVIMENTO("DESENV");

    private String valor;

    ServerOrigin(String valor){
        this.valor = valor;
    }

    public String get() {
        return valor;
    }

    public boolean equals(String valor){
        return this.valor.equals(valor);
    }

}