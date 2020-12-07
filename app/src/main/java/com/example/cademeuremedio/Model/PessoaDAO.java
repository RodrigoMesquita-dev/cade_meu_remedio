package com.example.cademeuremedio.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cademeuremedio.DbGateway;
import com.example.cademeuremedio.DbHelper;

public class PessoaDAO {
    private final String TABLE_PESSOA = "pessoa";
    private DbGateway gw;
    private DbHelper dBase;
    private SQLiteDatabase db;
    private Context contex;

    public PessoaDAO(Context ctx) {
        gw = DbGateway.getInstance(ctx);
        contex = ctx;
    }

    public boolean salvar( String email, String senha, String nome, String telefone,String celular) {
        ContentValues cv = new ContentValues();
        cv.put("email",email);
        cv.put("senha",senha);
        cv.put("nome",nome);
        cv.put("telefone",telefone);
        cv.put("celular",celular);
        return gw.getDatabase().insert(TABLE_PESSOA, null, cv) > 0;
    }

    public Pessoa Pesquisar(String email){

        Pessoa p = new Pessoa();
        dBase = new DbHelper(contex);
        db = dBase.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT email,senha,nome,telefone,celular FROM pessoa WHERE email = ?", new String[] {email});
        cursor.moveToFirst();

        if(cursor.getCount() > 0){

            p = new Pessoa();
            p.setEmail(cursor.getString(0));
            p.setSenha(cursor.getString(1));
            p.setNome(cursor.getString(2));
            p.setTelefone(cursor.getString(3));
            p.setCelular(cursor.getString(4));
        } else {
            p = null;
        }

        cursor.close();
        db.close();

        return p;
    }
}
