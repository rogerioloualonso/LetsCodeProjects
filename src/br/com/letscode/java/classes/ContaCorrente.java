package br.com.letscode.java.classes;

import java.math.BigDecimal;

public class ContaCorrente extends Conta{

    private BigDecimal saldo;
    double taxa = 0.005;

    public ContaCorrente(int certidao,int numConta, int numAgencia, BigDecimal valor) {
        super(numConta, numAgencia, certidao);
        this.saldo = valor;
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
                ", saldo=" + saldo +
                '}';
    }

    public void abrirContaCorrente() {
        //abrirConta();
        saldo = null;
        System.out.println("Conta Aberta!");
    }

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

    public void depositarContaCorrente (BigDecimal deposito){
        this.saldo.add(deposito);
        System.out.println("Depósito  realizado!");
    }// chamar Conta pelo método Construtor com parâmetros.

    public void transferirContaCorrente (Conta contaSacar, Conta contaDepositar, BigDecimal valorTransferir){
        /*if(this.ref == 2){
            this.saldo = this.saldo.subtract(this.saldo.multiply(BigDecimal.valueOf(taxa)));
        }
        contaSacar.saldo =  saldo.subtract(valorTransferir);
        contaDepositar.saldo = saldo.add(valorTransferir);*/
    }
    public void consultarSaldoContaCorrente() {
        System.out.println("O saldo da Conta Corrente é: " + this.saldo);
    }

}