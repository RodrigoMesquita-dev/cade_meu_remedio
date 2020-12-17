package com.example.cademeuremedio.Model;

/*
* CREATE TABLE remedio(
	id_remedio int not null auto_increment,
	nome varchar(50) not null,
    dosagem varchar(15),
    descricao varchar(15),
    PRIMARY KEY (id_remedio)
);
* */

import java.io.Serializable;

public class Remedio implements Serializable {
    private int id_remedio;
    private String nome;
    private String dosagem;
    private String descricao;

    public Remedio() {
    }

    public Remedio(int id_remedio, String nome, String dosagem, String descricao) {
        this.id_remedio = id_remedio;
        this.nome = nome;
        this.dosagem = dosagem;
        this.descricao = descricao;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
