package br.com.letscode.java.biblioteca.clientes;

import br.com.letscode.java.biblioteca.livro.Emprestimo;

import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ClienteDefault implements Cliente{

    protected final String nome;
    protected String email;
    protected int matricula;
    protected final TipoCliente tipoCliente;
    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    protected int tempoEntrega;

    public ClienteDefault(String nome, String email, int matricula, TipoCliente tipoCliente) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public boolean checarExistenciaEmprestimo(boolean existeEmprestimo) {
        if ((LocalDate.now()).isAfter(this.dataDevolucao)){

        }
        return existeEmprestimo;
    }

    @Override
    public String consultaPenalidade(String status) {
        if ((LocalDate.now()).isAfter(this.dataDevolucao)){
            long penalidade = ChronoUnit.DAYS.between(LocalDate.now(), this.dataDevolucao);
            status = ("Empréstimo atrasado, poderá fazer outro empréstimo daqui a " + penalidade + " dias.");
            return status;
        } else {
            status = "Não há empréstimos atrasados.";
            return status;
        }
    }

    //A linha abaixo serve se for preciso ter a data de término da penalidade
    @Override
    public LocalDate gerarPenalidade(LocalDate dataPenalidade) {
        dataPenalidade = LocalDate.now().plusDays(ChronoUnit.DAYS.between(LocalDate.now(), this.dataDevolucao));
        return dataPenalidade;
    }

    //A linha abaixo serve se for preciso ter apenas a confirmação se há penalidade ou não
//    @Override
//    public boolean gerarPenalidade() {
//        if (LocalDate.now().isAfter(dataDevolucao)){
//            return true;
//        }
//        return false;
//    }

    @Override
    public String toString() {
        return "ClienteDefault{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", matricula=" + matricula +
                ", tipoCliente=" + tipoCliente +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
