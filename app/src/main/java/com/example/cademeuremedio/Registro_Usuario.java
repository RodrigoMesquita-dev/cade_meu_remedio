package com.example.cademeuremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cademeuremedio.Model.PessoaDAO;

public class Registro_Usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__usuario);


        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);



        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 */

                EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
                EditText txtNome = (EditText) findViewById(R.id.txtNome);
                EditText txtCpf = (EditText) findViewById(R.id.txtCpf);
                EditText txtTelefone = (EditText) findViewById(R.id.txtTelefone);
                EditText txtCelular = (EditText) findViewById(R.id.txtCelular);
                EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
                EditText txtSenha2 = (EditText) findViewById(R.id.txtSenha2);

                String email = txtEmail.getText().toString();
                String nome = txtNome.getText().toString();
                String cpf = txtCpf.getText().toString();
                String telefone = txtTelefone.getText().toString();
                String celular = txtCelular.getText().toString();
                String senha = txtSenha.getText().toString();
                String senha2 = txtSenha2.getText().toString();

                PessoaDAO dao = new PessoaDAO(getBaseContext());
                boolean sucesso = dao.salvar(cpf,email,senha,nome,telefone,celular);
                if(sucesso){
                    Toast.makeText(getBaseContext(), "Você foi cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(getBaseContext(), tela_inicial.class);
                    startActivity(myIntent);
                }
                else{
                    Toast.makeText(getBaseContext(), "Algum erro ocorreu no seu cadastro!", Toast.LENGTH_LONG).show();
                }


                //Intent myIntent = new Intent(getBaseContext(), tela_inicial.class);
                //startActivity(myIntent);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), tela_inicial.class);
                startActivity(myIntent);
            }
        });

    }
}