package br.com.letscode.java;

import br.com.letscode.java.biblioteca.Biblioteca;
import br.com.letscode.java.biblioteca.clientes.*;
import br.com.letscode.java.biblioteca.livro.Emprestimo;
import br.com.letscode.java.biblioteca.livro.Livro;

public class Aplicacao {

    public static void main(String[] args) throws Exception {

        //Criar aluno
        //Cliente aluno = new ClienteAluno();
        ClienteDefault aluno = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);

        //Criar professor
        //Cliente professor = new ClienteProfessor();
        ClienteDefault professor = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);

        //Criar livro
        Livro livroUm = new Livro(78484, "Pequeno Principe", "Antoine de Sans", "Agir", true);
        Livro livroDois = new Livro(78484, "Código limpo", "Robert Cecil Martin", "Alta Books", true);
        Livro livroTres = new Livro(78484, "Arquitetura limpa: O guia do artesão para estrutura e design de software",
                "Robert Cecil Martin", "Alta Books", true);

        Emprestimo emprestimo = new Emprestimo();

        aluno.adicionarCarrinho(aluno, livroUm);
        aluno.adicionarCarrinho(aluno, livroDois);

        try {
            emprestimo.gerarEmprestimo(aluno);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            professor.adicionarCarrinho(professor, livroUm);
        } catch (Exception e) {
            e.printStackTrace();
        }

        emprestimo.gerarEmprestimo(professor);

        aluno.adicionarCarrinho(aluno,livroTres);

        try {
            emprestimo.gerarEmprestimo(aluno);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Biblioteca.devolver(aluno);


    }
}
