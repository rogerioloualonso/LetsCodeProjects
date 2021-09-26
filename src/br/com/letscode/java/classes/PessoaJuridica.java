package br.com.letscode.java.classes;

public class PessoaJuridica extends Pessoa{

    private double cnpj;

    public PessoaJuridica(double cnpj, String nome, int telefone , String endereco) {
        super(nome, telefone, endereco, 2);
        this.cnpj = cnpj;
    }

    public double getCnpj() {
        return cnpj;
    }

    public void setCnpj(double cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", endereço='" + endereço + '\'' +
                ", ref=" + ref +
                ", cnpj=" + cnpj +
                '}';
    }
}