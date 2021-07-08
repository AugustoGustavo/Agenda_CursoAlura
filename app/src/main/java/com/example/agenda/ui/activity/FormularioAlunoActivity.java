package com.example.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDao;
import com.example.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    //constants
    public static final String TITULO_APPBAR = "Novo Aluno";
    //objects
    private final AlunoDao dao = new AlunoDao(); //classe criada para manipulacao dos dados no pkg DAO
    //atributtes
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private Button botaoSalvaAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //sobrescreve o metodo herdado onCreate da AppCompatActivity para inicializar esta activity por meio do setContentView
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR); //intitula esta activity no appbar

        inicializaCampos();
        configuraBotaoSalvaAluno();
    }

    private void configuraBotaoSalvaAluno() {
        botaoSalvaAluno = findViewById(R.id.activity_formulario_aluno_salvar_aluno);
        //ref activity SalvaAluno para ativar o listener do OnClick, ou seja, ao clicar no botao irá acionar os metodos da classe anonimada dentro deste View.OnClickListener()
        botaoSalvaAluno.setOnClickListener(new View.OnClickListener() {
            //cria a classe anonima e sobrescreve o metodo onClick para add as acoes
            @Override
            public void onClick(View v) {
                Aluno NovoAluno = criaAluno();
                salvaAluno(NovoAluno);
            }
        });
    }

    private Aluno criaAluno() {
        //Obtem os dados da activity EditText e converte para String
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        //Instacia a classe de modelo Aluno e passa por parametro os dados obtidos da EditText
        return new Aluno(nome, telefone, email);
    }

    private void salvaAluno(Aluno novoAluno) {
        //Aciona o metdodo salvar da classe DAO para gravar os dados do NovoAluno
        dao.salvar(novoAluno);

        //inicializa a activity ListaAlunoActivity
        //startActivity(ActivityIntent);

        finish(); //mata a activity

        //teste que retorna o nome do aluno direto da DAO
        //Toast.makeText(FormularioAlunoActivity.this, dao.nome(), Toast.LENGTH_SHORT).show();
    }

    private void inicializaCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }
}