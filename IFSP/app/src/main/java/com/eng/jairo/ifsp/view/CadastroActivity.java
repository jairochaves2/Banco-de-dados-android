//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: José Maria Jairo Chaves

//******************************************************

package com.eng.jairo.ifsp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eng.jairo.ifsp.R;
import com.eng.jairo.ifsp.bd.DBHelper;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {
// OBJETIVO.......: Declaração das variáveis
    private Button btnVoltar;
    private Button btnCadastrar;
    private Button btnView;
    private EditText etNome;
    private EditText etCPF;
    private EditText etTelefone;
    private EditText etEmail;
    private EditText etIdade;
    private Agenda agenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

// OBJETIVO.......:Inicialização dos botões
        btnCadastrar=(Button) findViewById(R.id.btn_cadastrar);
        btnView=(Button) findViewById(R.id.btn_view);
        btnVoltar=(Button) findViewById(R.id.btn_voltar);
// OBJETIVO.......:Instanciação da classe DBHelper
        final DBHelper dbHelper=new DBHelper(getBaseContext());
        dbHelper.getReadableDatabase();
// OBJETIVO.......:Método executado quando o botão é clicado
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNome=(EditText) findViewById(R.id.et_nome);
                etCPF=(EditText) findViewById(R.id.et_cpf);
                etTelefone=(EditText) findViewById(R.id.et_telefone);
                etEmail=(EditText) findViewById(R.id.et_email);
                etIdade=(EditText) findViewById(R.id.et_idade);

// OBJETIVO.......:Verificar se os campos estão preenchidos
                if(!(etEmail.getText().toString().isEmpty()||etTelefone.getText().toString().isEmpty()||etIdade.getText().toString().isEmpty()||etNome.getText().toString().isEmpty()||etCPF.getText().toString().isEmpty())){
// OBJETIVO.......: atribuir os dados inseridos pelo usuários em variáveis String e int
                    String nome=etNome.getText().toString(),
                           cpf=etCPF.getText().toString(),
                           telefone=etTelefone.getText().toString(),
                           email=etEmail.getText().toString();

                    int idade=Integer.parseInt(etIdade.getText().toString());
// OBJETIVO.......:preencher o objeto agenda
                    agenda=new Agenda(nome, cpf, telefone, email, idade);

// OBJETIVO.......:inserir os dados no SQLite
                    DBHelper.insereDados(agenda,dbHelper);

// OBJETIVO.......:limpar campos de texto
                    etNome.setText("");
                    etCPF.setText("");
                    etIdade.setText("");
                    etTelefone.setText("");
                    etEmail.setText("");
                }
            }
        });
// OBJETIVO.......: abrir a tela para visualização dos dados
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
                it.setClass(CadastroActivity.this, ViewActivity.class);
                startActivity(it);
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
                it.setClass(CadastroActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });
    }
}
