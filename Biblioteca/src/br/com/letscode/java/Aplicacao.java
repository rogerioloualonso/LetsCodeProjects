package br.com.letscode.java;

import br.com.letscode.java.biblioteca.livro.Emprestimo;

public class Aplicacao {

    public static void main(String[] args) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo = emprestimo.gerarEmprestimo();

    }
}
