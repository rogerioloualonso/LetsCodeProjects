package br.com.letscode.java.biblioteca;

import br.com.letscode.java.biblioteca.clientes.ClienteDefault;
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

    static public void devolver (ClienteDefault cliente, Livro livro){
        for (Livro l : listaLivro) {
            listaLivro.add(livro);
            livro.setDisponivel(true);
        }
        livro.setDisponivel(true);
        System.out.println("O livro " + livro.getTitulo() +" foi devolvido");
        }
    }
