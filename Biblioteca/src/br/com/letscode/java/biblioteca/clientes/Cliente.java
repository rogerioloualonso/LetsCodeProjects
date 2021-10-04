package br.com.letscode.java.biblioteca.clientes;

import br.com.letscode.java.biblioteca.livro.Livro;

import java.time.LocalDate;

public interface Cliente {

    boolean consultaPenalidade(ClienteDefault cliente);

    void adicionarCarrinho(ClienteDefault cliente, Livro livro);

    String getNome();
}
