package br.com.letscode.java.biblioteca.clientes;

import java.time.LocalDate;

public class ClienteProfessor extends ClienteDefault{

    public ClienteProfessor(){
        super();
    }

    public ClienteProfessor(String nome, String email, int matricula, TipoCliente tipoCliente) {
        super(nome, email, matricula, tipoCliente);
    }

    @Override
    public boolean checarExistenciaEmprestimo(boolean existeEmprestimo) {
        return super.checarExistenciaEmprestimo(existeEmprestimo);
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
