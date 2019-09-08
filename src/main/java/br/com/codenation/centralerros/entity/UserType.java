package br.com.codenation.centralerros.entity;

public enum UserType {

    USER("user"),
    ADMIN("admin"),
    COMPANYADMIN("companyadmin");

    private String valor;

    UserType(String valor) {
        this.valor = valor;
    }

    public String get() {
        return valor;
    }

    public boolean equals(String valor) {
        return this.valor.equals(valor);
    }

}
