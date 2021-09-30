package br.com.letscode.java;

import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteProfessor;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;
import br.com.letscode.java.biblioteca.livro.Emprestimo;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite se o empréstimo pertence a um professor ou a um aluno: ");
        String tpCliente = sc.nextLine();
        if (tpCliente.equalsIgnoreCase("aluno")) {
            ClienteAluno cliente = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);
        } else if (tpCliente.equalsIgnoreCase("professor")) {
             ClienteProfessor cliente = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);
        }
        Emprestimo emprestimo = new Emprestimo();
        emprestimo = emprestimo.gerarEmprestimo();
        System.out.println(emprestimo.toString());
    }
}
