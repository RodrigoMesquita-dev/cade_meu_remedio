package com.example.cademeuremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cademeuremedio.Model.Pessoa;
import com.example.cademeuremedio.Model.PessoaDAO;

public class tela_inicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        final EditText txtEmail = (EditText) findViewById(R.id.txtLoginMail);
        final EditText txtSenha = (EditText) findViewById(R.id.txtLoginSenha);
        Button  btnEntrar = (Button) findViewById(R.id.btnEntrar);
        Button btnCriar = (Button) findViewById(R.id.btnCriar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PessoaDAO pd = new PessoaDAO(getBaseContext());
                Pessoa p = new Pessoa();
                p = pd.Pesquisar(txtEmail.getText().toString());
                if(p!=null){

                    if(p.getSenha().equals(txtSenha.getText().toString())){
                        Toast.makeText(getBaseContext(),"Login efetuado com sucesso!",Toast.LENGTH_LONG).show();
                        //Intent myIntent = new Intent(getBaseContext(), Usuario.class);
                        //startActivity(myIntent);
                        Intent myIntent = new Intent(getBaseContext(), Menu.class);
                        startActivity(myIntent);
                    } else{
                        Toast.makeText(getBaseContext(),"Login Invalido!",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(),"Usuario não encontrado!",Toast.LENGTH_LONG).show();
                }



            }
        });

        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Registro_Usuario.class);
                startActivity(myIntent);
            }
        });


    }
}