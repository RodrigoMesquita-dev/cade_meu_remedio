package com.example.cademeuremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cademeuremedio.Model.Possui;
import com.example.cademeuremedio.Model.Unidade;
import com.example.cademeuremedio.Model.Remedio;

import java.io.Serializable;

public class Remedio_tela extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedio);

        TextView txtUnidade = (TextView) findViewById(R.id.txt_NomeFarmacia);
        TextView txtrem = (TextView) findViewById(R.id.textView_rem);
        TextView txtest = (TextView) findViewById(R.id.textView_est);
        TextView txtdos = (TextView) findViewById(R.id.textView_dos);
        TextView txtdesc = (TextView) findViewById(R.id.textView_desc);

        /*
        Bundle bundle=getIntent().getExtras();
        Unidade unidade = (Unidade) getIntent().getSerializableExtra("unidade");
        Possui possui = (Possui) getIntent().getSerializableExtra("possui");
        com.example.cademeuremedio.Model.Remedio remedio = (com.example.cademeuremedio.Model.Remedio) getIntent().getSerializableExtra("remedio");
         */
        String nomef = getIntent().getStringExtra("nomef");
        String nomer = getIntent().getStringExtra("nomer");//se der pau arruma isso aki
        String estoque = getIntent().getStringExtra("estoque");
        String dosagem = getIntent().getStringExtra("dosagem");
        String descricao = getIntent().getStringExtra("descricao");

        txtUnidade.setText(nomef);
        txtrem.setText(nomer);
        txtest.setText("20");
        txtdos.setText(dosagem);
        txtdesc.setText(descricao);
        /*

        txtUnidade.setText(unidade.getNome());
        txtrem.setText(remedio.getNome());
        txtest.setText(possui.getEstoque());
        txtdos.setText(remedio.getDosagem());
        txtdesc.setText(remedio.getDescricao());
         */

    }
}