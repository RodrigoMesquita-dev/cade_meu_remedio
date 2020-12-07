package com.example.cademeuremedio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cademeuremedio.Model.Possui;
import com.example.cademeuremedio.Model.Remedio;
import com.example.cademeuremedio.Model.Unidade;
import com.example.cademeuremedio.Model.UnidadeDAO;

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
            "    PRIMARY KEY (email)\n" +
            ");";
    private final String CREATE_TABLE_UNIDADE = "CREATE TABLE unidade (\n" +
            "    place_id varchar(100) not null,\n" +
            "    email varchar(50) not null,\n" +
            "    nome varchar(130) not null,\n" +
            "    senha varchar(70) not null,\n" +
            "    horario_a varchar(15),\n" +
            "    horario_f varchar(15),\n" +
            "    whatsapp varchar(15),\n" +
            "    lat varchar(50),\n" +
            "    lng varchar(50),\n"+
            "    obs varchar(15),\n" +
            "    tipo varchar(15),\n" +
            "    PRIMARY KEY (place_id)\n" +
            ");";
    private final String CREATE_TABLE_REMEDIO = "CREATE TABLE remedio (\n" +
            "    id_remedio int not null,\n" +
            "    nome varchar(50) not null,\n" +
            "    dosagem varchar(15),\n" +
            "    descricao varchar(15),\n" +
            "    PRIMARY KEY (id_remedio)\n" +
            ");";
    private final String CREATE_TABLE_CONSULTA = "CREATE TABLE consulta (\n" +
            "    id_unidade int,\n" +
            "    cpf_pessoa varchar(15),\n" +
            "    nome varchar(30) not null,\n" +
            "    PRIMARY KEY (id_unidade,cpf_pessoa),\n" +
            "    FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),\n" +
            "    FOREIGN KEY (cpf_pessoa) REFERENCES pessoa(cpf)\n" +
            ");";
    private final String CREATE_TABLE_POSSUI = "CREATE TABLE possui (\n" +
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
        db.execSQL(CREATE_TABLE_UNIDADE);
        db.execSQL(CREATE_TABLE_REMEDIO);
        db.execSQL(CREATE_TABLE_POSSUI);
        db.execSQL(CREATE_TABLE_CONSULTA);
        boolean r;

        r = salvar_unidade(db,new Unidade("ChIJARyeczoFbJIRW7qWUXOtfNk","1","katyane","123","07:00","17:00","","","","","Farmacia"));
        r = salvar_unidade(db,new Unidade("ChIJHahP91sFbJIR-5qEJ4UmBvc","1","santo remedio","123","07:00","17:00","","","","","Farmacia"));
        r = salvar_unidade(db,new Unidade("ChIJvZB9f2wFbJIRZViQEuJdVqA","1","Drogaria Santo Remédio","123","07:00","17:00","","","","","Farmacia"));
        r = salvar_unidade(db,new Unidade("ChIJVRuqKW8FbJIRAxOJUpxOA7U","1","Drogaria de Jesus","123","07:00","17:00","","","","","Farmacia"));
        r = salvar_unidade(db,new Unidade("ChIJraEGR3kFbJIRHR0UFNzJVA0","1","Drogarias Flex Farma ","123","07:00","17:00","","","","","Farmacia"));

        r = salvar_remedio(db,new Remedio(1,"paracetamol","20gm","Combate dores"));
        r = salvar_remedio(db,new Remedio(2,"nimesulida","20gm","Anti inflamatório"));
        r = salvar_remedio(db,new Remedio(3,"dorflex","20gm","Relaxante Muscular"));

        r = salvar_possui(db,new Possui("ChIJARyeczoFbJIRW7qWUXOtfNk",1,23));
        r = salvar_possui(db,new Possui("ChIJARyeczoFbJIRW7qWUXOtfNk",2,12));
        r = salvar_possui(db,new Possui("ChIJARyeczoFbJIRW7qWUXOtfNk",3,40));

        r = salvar_possui(db,new Possui("ChIJHahP91sFbJIR-5qEJ4UmBvc",1,10));
        r = salvar_possui(db,new Possui("ChIJHahP91sFbJIR-5qEJ4UmBvc",2,20));
        r = salvar_possui(db,new Possui("ChIJHahP91sFbJIR-5qEJ4UmBvc",3,40));

        r = salvar_possui(db,new Possui("ChIJvZB9f2wFbJIRZViQEuJdVqA",1,8));
        r = salvar_possui(db,new Possui("ChIJvZB9f2wFbJIRZViQEuJdVqA",2,70));
        r = salvar_possui(db,new Possui("ChIJvZB9f2wFbJIRZViQEuJdVqA",3,31));

        r = salvar_possui(db,new Possui("ChIJVRuqKW8FbJIRAxOJUpxOA7U",1,8));
        r = salvar_possui(db,new Possui("ChIJVRuqKW8FbJIRAxOJUpxOA7U",2,70));
        r = salvar_possui(db,new Possui("ChIJVRuqKW8FbJIRAxOJUpxOA7U",3,31));

        r = salvar_possui(db,new Possui("ChIJraEGR3kFbJIRHR0UFNzJVA0",1,8));
        r = salvar_possui(db,new Possui("ChIJraEGR3kFbJIRHR0UFNzJVA0",2,70));
        r = salvar_possui(db,new Possui("ChIJraEGR3kFbJIRHR0UFNzJVA0",3,31));

    }

    public boolean salvar_unidade(SQLiteDatabase db, Unidade unidade) {
        ContentValues cv = new ContentValues();
        cv.put("place_id",unidade.getPlace_id());
        cv.put("email",unidade.getEmail());
        cv.put("nome",unidade.getNome());
        cv.put("senha",unidade.getSenha());
        cv.put("horario_a",unidade.getHorario_a());
        cv.put("horario_f",unidade.getHorario_f());
        cv.put("whatsapp",unidade.getWhatsapp());
        cv.put("lat",unidade.getLat());
        cv.put("lng",unidade.getLng());
        cv.put("obs",unidade.getObs());
        cv.put("tipo",unidade.getTipo());
        return db.insert("unidade", null, cv) > 0;
    }

    public boolean salvar_remedio(SQLiteDatabase db, Remedio remedio) {
        ContentValues cv = new ContentValues();
        cv.put("id_remedio",remedio.getId_remedio());
        cv.put("nome",remedio.getNome());
        cv.put("dosagem",remedio.getDosagem());
        cv.put("descricao",remedio.getDescricao());
        return db.insert("remedio", null, cv) > 0;
    }

    public boolean salvar_possui(SQLiteDatabase db, Possui possui) {
        ContentValues cv = new ContentValues();
        cv.put("id_unidade",possui.getId_unidade());
        cv.put("id_remedio",possui.getId_remedio());
        cv.put("estoque",possui.getEstoque());
        return db.insert("possui", null, cv) > 0;
    }
    /*

    (int id_unidade, String email, String nome, String senha, String horario_a, String horario_f
    , String whatsapp, String place_id, String lat, String lng, String obs, String tipo)

    * */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
