package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public interface Cliente {

    LocalDate emprestimo(LocalDate dataEmprestimo);
    //gerarDataDevolucao e emprestimo vao mudar depois de criar a classe Livro
    LocalDate gerarDataDevolucao(LocalDate dataDevolucao);

    boolean checarExistenciaEmprestimo(boolean existeEmprestimo);

    String consultaPenalidade(String status);

    LocalDate gerarPenalidade(LocalDate dataSuspensao);

}
