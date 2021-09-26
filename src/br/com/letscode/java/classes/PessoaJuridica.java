package br.com.letscode.java.classes;

import java.util.Scanner;

public class PessoaJuridica extends Pessoa{

    private int cnpj;

    public PessoaJuridica(int cnpj, String nome, int telefone , String endereco) {
        super(nome, telefone, endereco, 2);
        this.cnpj = cnpj;
    }

    public PessoaJuridica(){

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
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", endereço='" + endereço + '\'' +
                ", ref=" + ref +
                ", cnpj=" + cnpj +
                '}';
    }

    public PessoaJuridica cadastroPj(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite, respectivamente, o CNPJ, nome, telefone e endereço da pessoa física: ");
        int cnpjCadastro = sc.nextInt();
        sc.nextLine();
        String nomeCadastro = sc.nextLine();
        int telCadastro = sc.nextInt();
        sc.nextLine();
        String enderecoCadastro = sc.nextLine();
        PessoaJuridica pj = new PessoaJuridica(cnpjCadastro, nomeCadastro, telCadastro, enderecoCadastro);
        return pj;
    }
}