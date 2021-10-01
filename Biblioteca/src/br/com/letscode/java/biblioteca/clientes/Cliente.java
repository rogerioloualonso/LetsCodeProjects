package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public interface Cliente {

    String consultaPenalidade(String status);

    LocalDate gerarPenalidade(LocalDate dataSuspensao);

}
