package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public interface Cliente {

    boolean consultaPenalidade(ClienteDefault cliente);

    LocalDate gerarPenalidade(LocalDate dataSuspensao);

    String getNome();
}
