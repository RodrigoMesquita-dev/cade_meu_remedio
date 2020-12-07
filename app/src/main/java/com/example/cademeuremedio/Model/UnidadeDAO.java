package com.example.cademeuremedio.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cademeuremedio.DbGateway;
import com.example.cademeuremedio.DbHelper;

public class UnidadeDAO {
    private final String TABLE_UNIDADE = "unidade";
    private DbGateway gw;
    private DbHelper dBase;
    private SQLiteDatabase db;
    private Context contex;


    public UnidadeDAO(Context ctx) {
        gw = DbGateway.getInstance(ctx);
        contex = ctx;
    }

    public boolean salvar(Unidade unidade) {
        ContentValues cv = new ContentValues();
        cv.put("place_id",unidade.getPlace_id());
        cv.put("nome",unidade.getNome());
        cv.put("email",unidade.getEmail());
        cv.put("senha",unidade.getSenha());
        cv.put("nome",unidade.getHorario_a());
        cv.put("horario_a",unidade.getHorario_a());
        cv.put("horario_f",unidade.getHorario_f());
        cv.put("whatsapp",unidade.getWhatsapp());
        cv.put("obs",unidade.getObs());
        cv.put("lat",unidade.getLat());
        cv.put("lng",unidade.getLng());
        cv.put("tipo",unidade.getTipo());
        return gw.getDatabase().insert(TABLE_UNIDADE, null, cv) > 0;
    }

    public Unidade Pesquisar(String place_id){

        Unidade u = new Unidade();
        dBase = new DbHelper(contex);
        db = dBase.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT nome,horario_a,horario_f,whatsapp,obs,lat,lng,tipo FROM unidade WHERE place_id = ?", new String[] {place_id});
        cursor.moveToFirst();

        if(cursor.getCount() > 0){

            u = new Unidade();
            u.setNome(cursor.getString(0));
            u.setHorario_a(cursor.getString(1));
            u.setHorario_f(cursor.getString(2));
            u.setWhatsapp(cursor.getString(3));
            u.setObs(cursor.getString(4));
            u.setLat(cursor.getString(5));
            u.setLng(cursor.getString(6));
            u.setTipo(cursor.getString(7));
        } else {
            u = null;
        }

        cursor.close();
        db.close();

        return u;
    }
}
