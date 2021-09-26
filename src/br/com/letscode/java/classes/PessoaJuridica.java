package br.com.letscode.java.classes;

public class PessoaJuridica extends Pessoa{
    private int cnpj;

    public PessoaJuridica() {

    }

    public PessoaJuridica(int cnpj, String nome, int telefone , String endereco) {
        super(nome, telefone, endereco, 2);
        this.cnpj = cnpj;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj=" + cnpj +
                '}';
    }
}