package br.com.letscode.java;

import br.com.letscode.java.biblioteca.clientes.*;
import br.com.letscode.java.biblioteca.livro.*;
import br.com.letscode.java.biblioteca.Biblioteca;

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
        Livro livro = new Livro(78484, "Pequeno Principe", "Antoine de Sans", "Agir", true);


        Emprestimo emprestimo = new Emprestimo();
        // A saída de Aluno está null
        Biblioteca.emprestar(emprestimo, aluno, livro);
        System.out.println(emprestimo.toString());
        Biblioteca.emprestar(emprestimo, professor, livro);
        //emprestimo.gerarEmprestimo(aluno, livro);
        System.out.println(emprestimo.toString());

        try {
            emprestimo.gerarEmprestimo(aluno, livro);
            System.out.println(emprestimo.toString());
            //Isso não pode acontecer, tem que dar erro
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        /*
        boolean check = emprestimo.checarExistenciaEmprestimo();
        System.out.println(check);
        *///Isso deve ser usado em um método

    }
}
