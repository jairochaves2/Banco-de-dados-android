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

import com.eng.jairo.ifsp.R;

public class MainActivity extends AppCompatActivity {
    private Button btnDados;
    private Button btnVerDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDados=(Button) findViewById(R.id.btn_dados);
        btnVerDados=(Button) findViewById(R.id.btn_view_inicial);
// OBJETIVO.......: Abrir a tela para inserção dos dados
        btnDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
                it.setClass(MainActivity.this, CadastroActivity.class);
                startActivity(it);
                finish();
            }
        });
// OBJETIVO.......: Abrir a tela para visualização dos dados
        btnVerDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
                it.setClass(MainActivity.this, ViewActivity.class);
                startActivity(it);
            }
        });
    }

}
