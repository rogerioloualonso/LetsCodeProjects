package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public interface Cliente {

    int matricula = 0;

    String consultaPenalidade(String status);

    LocalDate gerarPenalidade(LocalDate dataSuspensao);

    public default int getMatricula() {
        return matricula;
    }

}
