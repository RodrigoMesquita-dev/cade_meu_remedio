package com.example.cademeuremedio.Model;

import java.io.Serializable;

public class Possui implements Serializable {
    private String id_unidade;
    private int id_remedio;
    private int estoque;

    public Possui() {
    }

    public Possui(String id_unidade, int id_remedio, int estoque) {
        this.id_unidade = id_unidade;
        this.id_remedio = id_remedio;
        this.estoque = estoque;
    }

    public String getId_unidade() {
        return id_unidade;
    }

    public void setId_unidade(String id_unidade) {
        this.id_unidade = id_unidade;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
