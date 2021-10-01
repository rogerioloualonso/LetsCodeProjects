package br.com.letscode.java;

import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteProfessor;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;
import br.com.letscode.java.biblioteca.livro.Emprestimo;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        
        ArrayList<Livro> listaLivros = new ArrayList<>();

        Livro dub = new Livro(15566, "Diário de um banana", "Jeff Kinney", "V&R");
        Livro pj = new Livro(14477, "Percy Jackson", "Rick Riordan", "Intrínseca");
        Livro hp = new Livro(33009, "Harry Potter", "J. K. Rowling", "Rocco");
        Livro sa = new Livro(65757, "Senhor dos anéis", "J. K. K. Tolkien", "Martins Fontes");
        Livro gow = new Livro(90987, "God of War", "Matthew Stover", "Europa");

        listaLivros.add(dub);
        listaLivros.add(pj);
        listaLivros.add(hp);
        listaLivros.add(sa);
        listaLivros.add(gow);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite se o empréstimo pertence a um professor ou a um aluno: ");
        String tpCliente = sc.nextLine();
        Cliente cliente = null;
        if (tpCliente.equalsIgnoreCase("aluno")) {
            cliente = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);
        } else if (tpCliente.equalsIgnoreCase("professor")) {
             cliente = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);
        }
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo = emprestimo.gerarEmprestimo();
        System.out.println(emprestimo.toString());
    }
}
