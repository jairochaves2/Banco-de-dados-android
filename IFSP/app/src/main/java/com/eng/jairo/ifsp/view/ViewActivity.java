//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: José Maria Jairo Chaves

//******************************************************


package com.eng.jairo.ifsp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.eng.jairo.ifsp.R;
import com.eng.jairo.ifsp.bd.DBHelper;

public class ViewActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        lv=(ListView) findViewById(R.id.lv);

        final DBHelper dbHelper=new DBHelper(getBaseContext());
        dbHelper.getReadableDatabase();
// OBJETIVO.......: Buscar e inserir os dados no ListView
        lv.setAdapter(DBHelper.select(dbHelper));
    }
}
