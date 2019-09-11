package br.com.codenation.centralerros.entity;

import javax.persistence.Entity;

public enum LevelLog {

    INFO("info"),
    TRACE("trace"),
    DEBUG("debug"),
    WARNING("warn"),
    ERROR("error"),
    FATAL("fatal");

    private String valor;

    LevelLog(String valor) {
        this.valor = valor;
    }

    public String get() {
        return valor;
    }

    public boolean equals(String valor) {
        return this.valor.equals(valor);
    }
}