package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaInvestimento extends Conta{

    private BigDecimal saldo;

    public ContaInvestimento(int certidao, int numConta, int numAgencia, BigDecimal saldo) {
        super(numConta, numAgencia, certidao);
        this.saldo = saldo;
    }

    public ContaInvestimento(){

    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaInvestimento{" +
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", saldo=" + saldo +
                '}';
    }

    public ContaInvestimento cadastroCi(){
        Scanner sc = new Scanner(System.in);
        Aplicacao dados = new Aplicacao();
        int cpf = dados.getCPF();
        int conta = dados.getnConta();
        int agencia = 12;
        BigDecimal saldo = BigDecimal.valueOf(0);
        ContaInvestimento ci = new ContaInvestimento(cpf, conta, agencia, saldo);
        return ci;
    }

    public ContaInvestimento CadastroCiJuridico(){
        Scanner sc = new Scanner(System.in);
        Aplicacao dados = new Aplicacao();
        int cnpj = dados.getCNPJ();
        int conta = dados.getnConta();
        int agencia = 12;
        BigDecimal saldo = BigDecimal.valueOf(0);
        ContaInvestimento ci = new ContaInvestimento(cnpj, conta, agencia, saldo);
        return ci;
    }
}
