package br.com.letscode.java.biblioteca.clientes;

import br.com.letscode.java.biblioteca.livro.Emprestimo;
import br.com.letscode.java.biblioteca.livro.Livro;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteAluno extends ClienteDefault{

    public ClienteAluno(){

    }

    public ClienteAluno(String nome, String email, int matricula, TipoCliente tipoCliente) {
        super(nome, email, matricula, tipoCliente);
    }

    @Override
    public boolean consultaPenalidade(ClienteDefault cliente) {
        return super.consultaPenalidade(cliente);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public ArrayList<Livro> getCarrinho() {
        return super.getCarrinho();
    }

    @Override
    public void setCarrinho(ArrayList<Livro> carrinho) {
        super.setCarrinho(carrinho);
    }

    @Override
    public ArrayList<Emprestimo> getEmprestimos() {
        return super.getEmprestimos();
    }

    @Override
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        super.setEmprestimos(emprestimos);
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
