package br.com.letscode.java;

import br.com.letscode.java.biblioteca.Biblioteca;
import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteProfessor;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;
import br.com.letscode.java.biblioteca.livro.Emprestimo;
import br.com.letscode.java.biblioteca.livro.Livro;

public class Aplicacao {

    public static void main(String[] args) {

        //Criar aluno
        Cliente aluno = new ClienteAluno();
        aluno = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);

        //Criar professor
        Cliente professor = new ClienteProfessor();
        professor = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);

        //Criar livro
        Livro livro = new Livro(78484, "Pequeno Principe", "Antoine de Sans", "Agir", true);


        Emprestimo emprestimo = new Emprestimo();
        // A saída de Aluno está null
        Biblioteca.emprestar(emprestimo, aluno, livro);
        System.out.println(emprestimo.toString());
        Biblioteca.emprestar(emprestimo, professor, livro);
        //emprestimo.gerarEmprestimo(aluno, livro);
        System.out.println(emprestimo.toString());
        boolean check = emprestimo.checarExistenciaEmprestimo();
        System.out.println(check);
        try {
            emprestimo.gerarEmprestimo(aluno, livro);
            System.out.println(emprestimo.toString());
            emprestimo.gerarEmprestimo(aluno, livro);
            System.out.println(emprestimo.toString());
            emprestimo.gerarEmprestimo(aluno, livro);
            System.out.println(emprestimo.toString());
            //Isso não pode acontecer, tem que dar erro
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
