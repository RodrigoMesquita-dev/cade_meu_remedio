package com.example.cademeuremedio.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cademeuremedio.DbGateway;
import com.example.cademeuremedio.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class PossuiDAO {

    private final String TABLE_POSSUI = "possui";
    private DbGateway gw;
    private DbHelper dBase;
    private SQLiteDatabase db;
    private Context contex;

    public PossuiDAO(Context ctx) {
        gw = DbGateway.getInstance(ctx);
        contex = ctx;
    }

    public boolean salvar(Possui possui) {
        ContentValues cv = new ContentValues();
        cv.put("id_unidade",possui.getId_unidade());
        cv.put("id_remedio",possui.getId_remedio());
        cv.put("estoque",possui.getEstoque());
        return gw.getDatabase().insert(TABLE_POSSUI, null, cv) > 0;
    }

    public Possui Pesquisar_remedio_unidade(String id_remedio, String id_unidade) {

        Possui p = new Possui();
        dBase = new DbHelper(contex);
        db = dBase.getReadableDatabase();

        //Ficar atento, talvez dê treta aki dpois
        Cursor cursor = db.rawQuery("SELECT id_remedio,id_unidade,estoque FROM possui WHERE id_unidade = ? and id_remedio = ?", new String[]{id_unidade,id_remedio});
        //cursor.moveToFirst();
        p = null;
        while(cursor.moveToNext()) {
            p = new Possui();
            p.setId_remedio(Integer.parseInt(cursor.getString(0)));
            p.setId_unidade(cursor.getString(1));
            p.setEstoque(Integer.parseInt(cursor.getString(2)));
        }
        cursor.close();
        db.close();

        return p;

        /*
        if (cursor.getCount() > 0) {

            p = new Possui();
            p.setId_remedio(Integer.parseInt(cursor.getString(0)));
            p.setId_unidade(cursor.getString(1));
            p.setEstoque(Integer.parseInt(cursor.getString(2)));
        } else {
            p = null;
        }
        */
    }

    //Listar possui:
    public List<Possui> retornarpossui(String id_remedio){
        List<Possui> possuis = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM possui WHERE id_remedio  = ?",new String[]{id_remedio});
        while(cursor.moveToNext()){
            Possui p = new Possui();
            p.setId_unidade(cursor.getString(cursor.getColumnIndex("id_unidade")));
            p.setId_remedio(cursor.getInt(cursor.getColumnIndex("id_remedio")));
            p.setEstoque(cursor.getInt(cursor.getColumnIndex("estoque")));
            possuis.add(p);
        }
        cursor.close();
        return possuis;
    }

}
