package com.example.cademeuremedio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Crud.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE_PESSOA = "CREATE TABLE pessoa (\n" +
            "    cpf varchar(15) not null,\n" +
            "    email varchar(50) not null,\n" +
            "    senha varchar(70) not null,\n" +
            "    nome varchar(130) not null,\n" +
            "    celular varchar(15),\n" +
            "    telefone varchar(15),\n" +
            "    PRIMARY KEY (cpf)\n" +
            ");";
    private final String CREATE_TABLE_UNIDADE = "CREATE TABLE unidade (\n" +
            "    id_unidade int not null auto_increment,\n" +
            "    email varchar(50) not null,\n" +
            "    nome varchar(130) not null,\n" +
            "    senha varchar(70) not null,\n" +
            "    horario_a varchar(15),\n" +
            "    horario_f varchar(15),\n" +
            "    whatsapp varchar(15),\n" +
            "    localização varchar (100),\n" +
            "    obs varchar(15),\n" +
            "    tipo varchar(15),\n" +
            "    PRIMARY KEY (id_unidade)\n" +
            ");";
    private final String CREATE_TABLE_REMEDIO = "CREATE TABLE remedio(\n" +
            "\tid_remedio int not null auto_increment,\n" +
            "\tnome varchar(50) not null,\n" +
            "    dosagem varchar(15),\n" +
            "    descricao varchar(15),\n" +
            "    PRIMARY KEY (id_remedio)\n" +
            ");";
    private final String CREATE_TABLE_CONSULTA = "CREATE TABLE consulta(\n" +
            "\tid_unidade int,\n" +
            "    cpf_pessoa varchar(15),\n" +
            "\tnome varchar(30) not null,\n" +
            "    PRIMARY KEY (id_unidade,cpf_pessoa),\n" +
            "\tFOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),\n" +
            "    FOREIGN KEY (cpf_pessoa) REFERENCES pessoa(cpf)\n" +
            ");";
    private final String CREATE_TABLE_POSSUI = "CREATE TABLE possui(\n" +
            "    id_remedio int not null,\n" +
            "    id_unidade int not null,\n" +
            "    estoque int ,\n" +
            "    PRIMARY KEY (id_remedio,id_unidade),\n" +
            "    FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),\n" +
            "    FOREIGN KEY (id_remedio) REFERENCES remedio(id_remedio)\n" +
            ");";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PESSOA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
