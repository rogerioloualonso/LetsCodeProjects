package br.com.letscode.java.biblioteca;

import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.livro.Emprestimo;
import br.com.letscode.java.biblioteca.livro.Livro;

import java.util.ArrayList;

public class Biblioteca {

    private static ArrayList<Livro> listaLivro = new ArrayList<>();


    public static ArrayList<Livro> getlistaLivro() {
        return listaLivro;
    }

    public static void setLivro(ArrayList<Livro> livro) {
        Biblioteca.listaLivro = livro;
    }

    static public void emprestar (Emprestimo emprestimo, Cliente cliente, Livro livro) {
        emprestimo.gerarEmprestimo(cliente, livro);
    }
    static public void devolver (Livro livro){
        for (Livro l : listaLivro) {
            listaLivro.add(livro);
            System.out.println("Livro Devolvido");
        }
    }

}
