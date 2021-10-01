package br.com.letscode.java;

import br.com.letscode.java.biblioteca.clientes.*;
import br.com.letscode.java.biblioteca.livro.*;

import java.time.LocalDate;

public class Aplicacao {

    public static void main(String[] args) {

        //Criar aluno
        ClienteDefault aluno = new ClienteAluno();
        aluno.setNome("cleiton");
        aluno = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);

        //Criar professor
        Cliente professor = new ClienteProfessor();
        professor = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);

        //Criar biblioteca e adicionar livro

        //Criar livro
        Livro livro = new Livro(78484, "Pequeno Principe", "Antoine de Sans", "Agir");

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.gerarEmprestimo(aluno, livro);
        System.out.println(emprestimo.toString());
        boolean check = emprestimo.checarExistenciaEmprestimo();
        System.out.println(check);
        try {
            emprestimo.gerarEmprestimo(aluno, livro);
            System.out.println(emprestimo.toString());
            //Isso não pode acontecer, tem que dar erro
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
