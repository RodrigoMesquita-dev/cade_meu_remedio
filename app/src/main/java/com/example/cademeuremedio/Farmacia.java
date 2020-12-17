package com.example.cademeuremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cademeuremedio.Model.Possui;
import com.example.cademeuremedio.Model.PossuiDAO;
import com.example.cademeuremedio.Model.Remedio;
import com.example.cademeuremedio.Model.RemedioDAO;
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
        Button btnVoltar = (Button) findViewById(R.id.btn_voltar_farmacia);

        ImageButton imgbtn = (ImageButton) findViewById(R.id.imageView);

        final EditText txtrem = (EditText) findViewById(R.id.editTextTextPersonName2);

        final Unidade unidade = (Unidade) getIntent().getSerializableExtra("unidade");

        txtNome.setText(unidade.getNome());
        txtCont.setText(unidade.getWhatsapp());
        txtHr.setText("abre: "+unidade.getHorario_a()+" , Fecha: "+unidade.getHorario_f());
        txtWht.setText(unidade.getWhatsapp());
        txtObs.setText(unidade.getObs());

        final String id_unidade = unidade.getPlace_id();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Menu.class);
                startActivity(myIntent);
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Remedio remedio = null;
                RemedioDAO remedioDAO = new RemedioDAO(getApplicationContext());
                remedio = remedioDAO.Pesquisar_nome(String.valueOf(txtrem.getText()));

                Possui possui = null;

                if (remedio!=null){

                    PossuiDAO possuidao = new PossuiDAO(getApplicationContext());
                    System.out.println("Farmacia remedio.getId_Remedio(): "+remedio.getId_remedio());
                    System.out.println("Farmacia id_unidade: "+id_unidade);
                    possui = possuidao.Pesquisar_remedio_unidade(String.valueOf(remedio.getId_remedio()),id_unidade);

                    if(possui!=null){
                        Intent myIntent = new Intent(getBaseContext(), Remedio_tela.class);
                        //Bundle bundle = new Bundle();
                        Unidade unidade2 = unidade;
                        //bundle.putParcelable("remedio", (Parcelable) remedio);
                        //bundle.putParcelable("unidade", (Parcelable) unidade2);
                       //bundle.putParcelable("possui", (Parcelable) possui);
                        //myIntent.putExtras(bundle);
                        //myIntent.putExtra("remedio", unidade);
                        //myIntent.putExtra("remedio", remedio);
                        //myIntent.putExtra("possui", possui);

                        myIntent.putExtra("nomef",unidade.getNome());
                        myIntent.putExtra("nomer",remedio.getNome());
                        myIntent.putExtra("estoque",possui.getEstoque());
                        myIntent.putExtra("dosagem",remedio.getDosagem());
                        myIntent.putExtra("descricao",remedio.getDescricao());
                        startActivity(myIntent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),
                                "Esta farmácia não possui esse remédio",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Remédio não encontrado",
                            Toast.LENGTH_LONG)
                            .show();
                }



            }
        });

    }
}