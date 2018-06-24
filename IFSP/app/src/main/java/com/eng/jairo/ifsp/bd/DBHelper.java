//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: José Maria Jairo Chaves

//******************************************************

package com.eng.jairo.ifsp.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.SimpleCursorAdapter;

import com.eng.jairo.ifsp.view.Agenda;
import com.eng.jairo.ifsp.R;

public class DBHelper extends SQLiteOpenHelper{
    //Variável que mantem o nome do banco de dados
    private static final String DB_NAME="Agenda.db";
    //Variável que mantem a versão do banco
    private static final int DB_VERSION=1;
    //Variável que mantem o nome da tabela
    private static final String TABLE_NAME="contato";

    private Context context;
    private SQLiteDatabase db;
    //Método construtor
    public DBHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
        this.context = context;
    }
    //Criação da tabela
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE contato (_id integer primary key AUTOINCREMENT  not null, nome varchar(200) not null, cpf varchar(20) not null, idade int not null, telefone varchar(20) not null, email varchar(400)not null);";
        sqLiteDatabase.execSQL(sql);
    }
    //Atualização da tabela
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
//Retorna para classes externas o nome da tabela
    public static String getTableName() {
        return TABLE_NAME;
    }
//Inserção dos dados no banco de dados sqlite
    public static void insereDados(Agenda agenda, DBHelper dbHelper){
        ContentValues ctv=new ContentValues();
        SQLiteDatabase sqlDatabase=dbHelper.getWritableDatabase();
        ctv.put("nome",agenda.getNome());
        ctv.put("cpf",agenda.getCpf());
        ctv.put("idade",agenda.getIdade());
        ctv.put("telefone",agenda.getTelefone());
        ctv.put("email",agenda.getEmail());

        sqlDatabase.insert(DBHelper.getTableName(),null,ctv);
    }
//Faz uma busca no banco por todos os dados que estão salvos na tabela e retorna um SimpleCursorAdapter
    public static SimpleCursorAdapter select(DBHelper dbHelper){
        String sql="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=dbHelper.getWritableDatabase();
//Realiza a busca dos dados e atribui a um cursor
        Cursor cursor=db.rawQuery(sql,null);
        String[] from={"nome","cpf","idade","telefone","email"};
        int[] to={R.id.tv_nome,R.id.tv_cpf,R.id.tv_idade,R.id.tv_telefone,R.id.tv_email};
//Atribui os dados do cursor a um Adapter
        SimpleCursorAdapter adapter=new SimpleCursorAdapter
                                        (dbHelper.context,R.layout.activity_layout_cadastro,cursor,from,to,0);
//Retorna o adapter
        return adapter;
    }
}
