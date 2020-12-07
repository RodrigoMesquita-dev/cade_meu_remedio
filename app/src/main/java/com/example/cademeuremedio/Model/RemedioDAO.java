package com.example.cademeuremedio.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cademeuremedio.DbGateway;
import com.example.cademeuremedio.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class RemedioDAO {

    private final String TABLE_REMEDIO = "remedio";
    private DbGateway gw;
    private DbHelper dBase;
    private SQLiteDatabase db;
    private Context contex;

    public RemedioDAO(Context ctx) {
        gw = DbGateway.getInstance(ctx);
        contex = ctx;
    }

    public boolean salvar(Remedio remedio) {
        ContentValues cv = new ContentValues();
        cv.put("id_remedio",remedio.getId_remedio());
        cv.put("nome",remedio.getNome());
        cv.put("dosagem",remedio.getDosagem());
        cv.put("descricao",remedio.getDescricao());
        return gw.getDatabase().insert(TABLE_REMEDIO, null, cv) > 0;
    }

    public Remedio Pesquisar_nome(String nome) {

        Remedio r = new Remedio();
        dBase = new DbHelper(contex);
        db = dBase.getReadableDatabase();

        //Ficar atento, talvez dê treta aki dpois
        Cursor cursor = db.rawQuery("SELECT id_remedio,nome,dosagem,descricao FROM remedio WHERE nome like ?", new String[]{nome});
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {

            r = new Remedio();
            r.setId_remedio(Integer.parseInt(cursor.getString(0)));
            r.setNome(cursor.getString(1));
            r.setDosagem(cursor.getString(2));
            r.setDescricao(cursor.getString(3));
        } else {
            r = null;
        }

        cursor.close();
        db.close();

        return r;
    }

}
