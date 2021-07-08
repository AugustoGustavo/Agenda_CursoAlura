package com.example.agenda.dao;

import com.example.agenda.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
    //array estatica que ira manter os dados salvos enquanto roda o app, removendo a necessidade de integracao via banco de dados nesse app
    private final static List<Aluno> Alunos = new ArrayList<>();

    //metodo para adicionar um aluno novo no array estatico
    public static void salvar(Aluno aluno) {
        Alunos.add(aluno);
    }

    //metodo para retornar para as outras activities uma copia do array Alunos
    public List<Aluno> todos() {
        //devolve uma NOVA instancia de ArrayList<> contendo o conteudo do array Aluno
        return new ArrayList<>(Alunos);
    }


    /* APENAS PARA TESTE
    public String nome() {
        Aluno aluno = Alunos.get(0);
        return aluno.getNome();
    }
    */
}
