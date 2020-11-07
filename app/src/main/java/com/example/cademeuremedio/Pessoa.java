package com.example.cademeuremedio;

import java.io.Serializable;
import java.sql.Date;

public class Pessoa implements Serializable {

    //private int id;
    //private String cpf;
    private String email;
    private String senha;
    private String nome;
    private String telefone;
    private String celular;

    public Pessoa( String email, String senha, String nome, String telefone, String celular) {
        //this.id = id;
        //this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Pessoa(){

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public boolean equals(Object o){
        return this.email == ((Pessoa)o).email;
    }

    //Tem como usar esse hashcode com string?
    @Override
    public int hashCode(){
        return 0;
    }
}

/*
    CREATE TABLE pessoa (
            cpf varchar(15) not null,
    email varchar(50) not null,
    senha varchar(70) not null,
    nome varchar(130) not null,
    celular varchar(15),
    senha_data date,
    PRIMARY KEY (cpf)
);   */