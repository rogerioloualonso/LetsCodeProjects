package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaCorrente extends Conta{

    private BigDecimal saldo;
    private double taxa = 0.005;

    public ContaCorrente(int certidao,int numConta, int numAgencia, BigDecimal valor, int tipo) {
        super(numConta, numAgencia, certidao,tipo);
        this.saldo = valor;
    }

    public ContaCorrente(){

    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", certidao=" + certidao +
                ", tipo=" + tipo +
                ", saldo=" + saldo +
                ", taxa=" + taxa +
                '}';
    }

    public void abrirContaCorrente() {
        //abrirConta();
        saldo = null;
        System.out.println("Conta Aberta!");
    }

    //Stephania
    public void sacarContaCorrente(BigDecimal retirada) {
        if (saldo.compareTo(retirada) < 0) {
            System.out.println("Saldo insuficiente para o saque");
        } else if (this.saldo.compareTo(retirada) >= 0) {
            this.saldo.subtract(retirada);
            System.out.println("Saque realizado!");
        }
        /*if (this.ref == 2) {
            this.saldo = this.saldo.subtract(this.saldo.multiply(BigDecimal.valueOf(taxa)));
        }*/ // Colocar a taxa de conta corrente
    }

    //Stephania
    public void depositarContaCorrente (BigDecimal deposito){
        this.saldo.add(deposito);
        System.out.println("Depósito  realizado!");
    }// chamar Conta pelo método Construtor com parâmetros.

    //Stephania
    public void transferirContaCorrente (Conta contaSacar, Conta contaDepositar, BigDecimal valorTransferir){
        /*if(this.ref == 2){
            this.saldo = this.saldo.subtract(this.saldo.multiply(BigDecimal.valueOf(taxa)));
        }
        contaSacar.saldo =  saldo.subtract(valorTransferir);
        contaDepositar.saldo = saldo.add(valorTransferir);*/
    }

    //Stephania
    public void consultarSaldoContaCorrente() {
        System.out.println("O saldo da Conta Corrente é: " + this.saldo);
    }

    public ContaCorrente CadastroCC(){
        Scanner sc = new Scanner(System.in);
        Aplicacao dados = new Aplicacao();
        int cpf = dados.getCPF();
        int conta = dados.getnConta();
        int agencia = 12;
        BigDecimal saldo = BigDecimal.valueOf(0);
        ContaCorrente cc = new ContaCorrente(cpf, conta, agencia, saldo, 1);
        return cc;
    }

    public ContaCorrente CadastroCCJuridico(){
        Scanner sc = new Scanner(System.in);
        Aplicacao dados = new Aplicacao();
        int cnpj = dados.getCNPJ();
        int conta = dados.getnConta();
        int agencia = 12;
        BigDecimal saldo = BigDecimal.valueOf(0);
        ContaCorrente cc = new ContaCorrente(cnpj, conta, agencia, saldo, 1);
        return cc;
    }

    public void depositar(ContaCorrente conta, BigDecimal valor){



    }

}