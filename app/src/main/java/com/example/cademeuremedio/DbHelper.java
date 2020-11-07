package com.example.cademeuremedio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Crud.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE = "CREATE TABLE pessoa (\n" +
            "    email varchar(50) not null,\n" +
            "    senha varchar(70) not null,\n" +
            "    nome varchar(130) not null,\n" +
            "    celular varchar(15),\n" +
            "    telefone varchar(15),\n" +
            "    PRIMARY KEY (email)\n" +
            ");";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
