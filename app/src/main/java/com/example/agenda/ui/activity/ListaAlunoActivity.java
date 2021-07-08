package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.agenda.R;
import com.example.agenda.dao.AlunoDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private FloatingActionButton botaoAdd;
    private final AlunoDao dao = new AlunoDao(); //instancia um objeto da classe AlunoDao para manipulacao dos dados
    private ListView listaAlunos;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Toast.makeText(this, "SEJA BEM-VINDO", Toast.LENGTH_LONG).show();
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //sobrescreve o metodo herdado onCreate da AppCompatActivity para inicializar esta activity por meio do setContentView
        setContentView(R.layout.activity_lista_aluno);
        setTitle(TITULO_APPBAR); //intitula esta activity no appbar

        configuraBotaoFabNovoAluno();

    }

    private void configuraBotaoFabNovoAluno() {
        botaoAdd = findViewById(R.id.activity_lista_aluno_fab_novo_aluno);
        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraListaAlunos();

        /* REMOVIDO PARA USAR NO LUGAR O OBJETO DAO
        //criar um array do tipo list intanciando a classe ArrayList e passando por parametro do metedo asList da classe Arrays os elementos
        List<String> Alunos = new ArrayList(Arrays.asList("GUSTAVO","GISELLE","MATHEUS","SANDRA"));
        */

        /*
        //instacia as activities e define o texto com base no array - REMOVIDO E USADO NO LUGAR O LISTVIEW
        TextView aluno1 = findViewById(R.id.textView);
        TextView aluno2 = findViewById(R.id.textView2);
        TextView aluno3 = findViewById(R.id.textView3);
        aluno1.setText(Alunos.get(0));
        aluno2.setText(Alunos.get(1));
        aluno3.setText(Alunos.get(2));
        */

    }

    private void configuraListaAlunos() {
        //trocamos o TextView pelo ListView, abaixo é instanciado o ListView
        listaAlunos = findViewById(R.id.activity_lista_alunos_listview);

        //Prepara o Array com os dados para que seja adaptado os elementos como uma lista - REMOVIDO, NAO PRECISA MAIS
        //ArrayAdapter<String> listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dao.todos());

        //Passa para o ListView o array adaptado
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}


