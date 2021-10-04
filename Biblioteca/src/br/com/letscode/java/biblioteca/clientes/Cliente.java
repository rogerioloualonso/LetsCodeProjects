package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public interface Cliente {

    boolean consultaPenalidade(ClienteDefault cliente);

    LocalDate diasPenalidade(ClienteDefault cliente);

    String getNome();
}
