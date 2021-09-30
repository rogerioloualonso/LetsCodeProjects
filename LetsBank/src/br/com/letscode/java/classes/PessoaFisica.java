package br.com.letscode.java.classes;

import java.util.Scanner;

public class PessoaFisica extends Pessoa {

    private int cpf;

    public PessoaFisica(int cpf, String nome, int telefone , String endereco) {
        super(nome, telefone, endereco, 1);
        this.cpf = cpf;
    }

    public PessoaFisica(){

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

    public PessoaFisica cadastroPf(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite, respectivamente, o cpf, nome, telefone e endereço da pessoa física: ");
        int cpfCadastro = sc.nextInt();
        sc.nextLine();
        String nomeCadastro = sc.nextLine();
        int telCadastro = sc.nextInt();
        sc.nextLine();
        String enderecoCadastro = sc.nextLine();
        PessoaFisica pf = new PessoaFisica(cpfCadastro, nomeCadastro, telCadastro, enderecoCadastro);
        return pf;
    }
}