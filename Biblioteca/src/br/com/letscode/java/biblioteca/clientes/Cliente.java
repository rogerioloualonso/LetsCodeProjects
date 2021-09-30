package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public interface Cliente {

    boolean checarExistenciaEmprestimo(boolean existeEmprestimo);

    String consultaPenalidade(String status);

    LocalDate gerarPenalidade(LocalDate dataSuspensao);

}
