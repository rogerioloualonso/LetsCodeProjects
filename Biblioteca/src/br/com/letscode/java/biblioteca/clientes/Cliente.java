package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public interface Cliente {

    Cliente cadastroCliente(Cliente cliente);

    boolean checarExistenciaEmprestimo(boolean existeEmprestimo);

    String consultaPenalidade(String status);

    LocalDate gerarPenalidade(LocalDate dataSuspensao);

}
