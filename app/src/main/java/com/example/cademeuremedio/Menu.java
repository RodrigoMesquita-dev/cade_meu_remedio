package com.example.cademeuremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buscar_medicamentos = (Button) findViewById(R.id.buscar_medicamentos);
        Button buscar_ubs = (Button) findViewById(R.id.buscar_ubs);
        Button ver_mapa = (Button) findViewById(R.id.ver_mapa);

        buscar_medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Mapa.class);
                startActivity(myIntent);
            }
        });

        buscar_medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Mapa.class);
                startActivity(myIntent);
            }
        });

        buscar_medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Mapa.class);
                startActivity(myIntent);
            }
        });
    }
}