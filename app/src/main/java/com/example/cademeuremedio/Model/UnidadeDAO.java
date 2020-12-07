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

        Unidade u;
        dBase = new DbHelper(contex);
        db = dBase.getReadableDatabase();
        System.out.println("UnidadeDAO place_id: "+place_id);



        //Cursor cursor = db.query("unidade",new String[] {"nome","horario_a","horario_f","whatsapp","lat","lng"},"place_id = ?",new String[] {place_id},null,null,null);
        Cursor cursor = db.rawQuery("SELECT * FROM unidade WHERE place_id = ?",new String[] {place_id});
        u = null;

        while(cursor.moveToNext()){
                u = new Unidade();
                u.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                System.out.println("Cursor Index Nome "+cursor.getString(cursor.getColumnIndex("nome")));
                System.out.println("Cursor Index 0 "+cursor.getString(2));
                //System.out.println("UnidadeDAO u.getNome(): "+cursor.getString(cursor.getColumnIndex("cursor")));
                u.setHorario_a(cursor.getString(cursor.getColumnIndex("horario_a")));
                u.setHorario_f(cursor.getString(cursor.getColumnIndex("horario_f")));
                u.setWhatsapp(cursor.getString(cursor.getColumnIndex("whatsapp")));
                u.setLat(cursor.getString(cursor.getColumnIndex("lat")));
                u.setLng(cursor.getString(cursor.getColumnIndex("lng")));

        }

        cursor.close();
        db.close();

        return u;
    }
}
