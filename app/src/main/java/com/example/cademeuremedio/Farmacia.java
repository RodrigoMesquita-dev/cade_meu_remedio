package com.example.cademeuremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cademeuremedio.Model.Unidade;

import java.io.Serializable;

public class Farmacia extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmacia);

        TextView txtNome = (TextView) findViewById(R.id.txt_NomeFarmacia);
        TextView txtCont = (TextView) findViewById(R.id.textView_cont);
        TextView txtHr = (TextView) findViewById(R.id.textView_hr);
        TextView txtWht = (TextView) findViewById(R.id.textView_what);
        TextView txtObs = (TextView) findViewById(R.id.textView_obs);

        Unidade unidade = new Unidade();
        unidade = (Unidade) getIntent().getSerializableExtra("unidade");

        txtNome.setText(unidade.getNome());
        txtCont.setText(unidade.getWhatsapp());
        txtHr.setText("abre: "+unidade.getHorario_a()+" , Fecha: "+unidade.getHorario_f());
        txtWht.setText(unidade.getWhatsapp());
        txtObs.setText(unidade.getObs());

    }
}