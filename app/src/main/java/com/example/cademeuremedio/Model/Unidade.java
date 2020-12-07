package com.example.cademeuremedio.Model;

import java.io.Serializable;

public class Unidade implements Serializable {

    private int id_unidade;
    private String email;
    private String nome;
    private String senha;
    private String horario_a;
    private String horario_f;
    private String whatsapp;
    private String place_id;
    private String lat;
    private String lng;
    private String obs;
    private String tipo;

    public Unidade() {
        //hi folks
    }

    public Unidade(int id_unidade, String email, String nome, String senha, String horario_a, String horario_f, String whatsapp, String place_id, String lat, String lng, String obs, String tipo) {
        this.id_unidade = id_unidade;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.horario_a = horario_a;
        this.horario_f = horario_f;
        this.whatsapp = whatsapp;
        this.place_id = place_id;
        this.lat = lat;
        this.lng = lng;
        this.obs = obs;
        this.tipo = tipo;
    }

    public int getId_unidade() {
        return id_unidade;
    }

    public void setId_unidade(int id_unidade) {
        this.id_unidade = id_unidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getHorario_a() {
        return horario_a;
    }

    public void setHorario_a(String horario_a) {
        this.horario_a = horario_a;
    }

    public String getHorario_f() {
        return horario_f;
    }

    public void setHorario_f(String horario_f) {
        this.horario_f = horario_f;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
