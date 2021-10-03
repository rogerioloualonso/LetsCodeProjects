package br.com.letscode.java.biblioteca.clientes;

import br.com.letscode.java.biblioteca.livro.Emprestimo;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteAluno extends ClienteDefault{

    int limite = 3;

    public ClienteAluno(){
    }

    public ClienteAluno(String nome, String email, int matricula, TipoCliente tipoCliente) {
        super(nome, email, matricula, tipoCliente);
    }

    @Override
    public String consultaPenalidade(String status) {
        return super.consultaPenalidade(status);
    }

    @Override
    public LocalDate gerarPenalidade(LocalDate dataPenalidade) {
        return super.gerarPenalidade(dataPenalidade);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ArrayList<Emprestimo> getEmprestimos() {
        return super.getEmprestimos();
    }

    @Override
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        super.setEmprestimos(emprestimos);
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public int getMatricula() {
        return super.getMatricula();
    }

    @Override
    public void setMatricula(int matricula) {
        super.setMatricula(matricula);
    }
}
