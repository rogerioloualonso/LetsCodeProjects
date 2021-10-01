package br.com.letscode.java;

import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteProfessor;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;
import br.com.letscode.java.biblioteca.livro.Emprestimo;
import br.com.letscode.java.biblioteca.livro.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {

     private static ArrayList<Livro> listaLivros;
     private static ArrayList<Cliente> listaClientes;
     private static ArrayList<Emprestimo> emprestimos;

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public static void main(String[] args) {
        
        listaLivros = new ArrayList<>();
        listaClientes = new ArrayList<>();
        emprestimos = new ArrayList<>();

        ClienteAluno al1 = new ClienteAluno("Roberto", "rob123@gmail.com", 32165478, TipoCliente.CLIENTE_ALUNO);
        ClienteAluno al2 = new ClienteAluno("Alberto", "alb123@gmail.com", 32654178, TipoCliente.CLIENTE_ALUNO);
        ClienteAluno al3 = new ClienteAluno("Queberto", "qeb123@gmail.com", 36578214, TipoCliente.CLIENTE_ALUNO);

        listaClientes.add(al1);
        listaClientes.add(al2);
        listaClientes.add(al3);

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

        Emprestimo em1 = new Emprestimo(al1, LocalDate.now(), LocalDate.now().plusDays(10), dub);

        emprestimos.add(em1);

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite se o empréstimo pertence a um professor ou a um aluno: ");
        String tpCliente = sc.nextLine();
        Cliente cliente = null;
        if (tpCliente.equalsIgnoreCase("aluno")) {
            cliente = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);
            listaClientes.add(cliente);
        } else if (tpCliente.equalsIgnoreCase("professor")) {
             cliente = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);
            listaClientes.add(cliente);
        }
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo.gerarEmprestimo();
        System.out.println(emprestimo.toString());
        boolean check = emprestimo.checarExistenciaEmprestimo();
        System.out.println(check);
    }
}
