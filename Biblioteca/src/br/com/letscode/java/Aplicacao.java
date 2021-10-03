package br.com.letscode.java;

import br.com.letscode.java.biblioteca.EmprestimoSimultaneoExcedidoException;
import br.com.letscode.java.biblioteca.clientes.*;
import br.com.letscode.java.biblioteca.livro.*;
import br.com.letscode.java.biblioteca.Biblioteca;
import br.com.letscode.java.biblioteca.clientes.*;
import br.com.letscode.java.biblioteca.livro.Emprestimo;
import br.com.letscode.java.biblioteca.livro.Livro;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacao {


    public static void main(String[] args) throws EmprestimoSimultaneoExcedidoException {

        //Criar aluno
        //Cliente aluno = new ClienteAluno();
        ClienteDefault aluno = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);

        //Criar professor
        //Cliente professor = new ClienteProfessor();
        ClienteDefault professor = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);

        //Criar biblioteca e adicionar livro
        Biblioteca biblioteca = new Biblioteca ();
     

        //Criar livro
        Livro livroUm = new Livro(78484, "Pequeno Principe", "Antoine de Sans", "Agir", true);
        Livro livroDois = new Livro(78484, "Código limpo", "Robert Cecil Martin", "Alta Books", true);
        Livro livroTres = new Livro(78484, "Arquitetura limpa: O guia do artesão para estrutura e design de software",
                "Robert Cecil Martin", "Alta Books", true);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.gerarEmprestimo(aluno, livroUm);
        emprestimo.gerarEmprestimo(professor, livroUm);
        emprestimo.gerarEmprestimo(aluno, livroTres); // teste da restrição
        Biblioteca.devolver(aluno, livroUm);
        emprestimo.gerarEmprestimo(professor, livroUm);
        emprestimo.gerarEmprestimo(professor, livroDois);
        emprestimo.gerarEmprestimo(aluno, livroTres); // quando restringir aqui libera

        try {
            emprestimo.gerarEmprestimo(aluno, livroUm);
            System.out.println(emprestimo);
            emprestimo.gerarEmprestimo(aluno, livroUm);
            System.out.println(emprestimo);
            emprestimo.gerarEmprestimo(aluno, livroUm);
            System.out.println(emprestimo);
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
