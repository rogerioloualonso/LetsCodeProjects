package br.com.letscode.java.biblioteca;

import br.com.letscode.java.biblioteca.clientes.ClienteDefault;
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

    static public void devolver (ClienteDefault cliente) {
        for (int i = 0; i < cliente.getCarrinho().size(); i++) {
            Livro livro = cliente.getCarrinho().get(i);
            livro.setDisponivel(true);
            System.out.println("O livro " + livro.getTitulo() + " foi devolvido");
        }
        cliente.getCarrinho().clear();
    }
}

