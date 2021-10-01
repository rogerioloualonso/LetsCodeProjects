package br.com.letscode.java.biblioteca.clientes;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public abstract class ClienteDefault implements Cliente{

    protected String nome;
    protected String email;
    protected int matricula;
    protected TipoCliente tipoCliente;
    protected LocalDate dataDevolucao;


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

    public int getMatricula() {
        return matricula;
    }

    protected void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
