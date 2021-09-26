package br.com.letscode.java.classes;

public class PessoaFisica extends Pessoa {

    private int cpf;

    public PessoaFisica(int cpf, String nome, int telefone , String endereco) {
        super(nome, telefone, endereco, 1);
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", endereço='" + endereço + '\'' +
                ", ref=" + ref +
                ", cpf=" + cpf +
                '}';
    }
}