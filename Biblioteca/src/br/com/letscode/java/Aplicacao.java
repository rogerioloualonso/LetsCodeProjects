package br.com.letscode.java;

import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteProfessor;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;
import br.com.letscode.java.biblioteca.livro.Emprestimo;

public class Aplicacao {

    public static void main(String[] args) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.gerarEmprestimo();
    }
}
