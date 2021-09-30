package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaPoupanca extends Conta{

    private BigDecimal saldo;

    public ContaPoupanca(int numConta, int numAgencia, int certidao, BigDecimal saldo, int tipo, int ref) {
        super(numConta, numAgencia, certidao, saldo, tipo, ref);
    }

    public ContaPoupanca(){

    }

    @Override
    public Conta Cadastro() {
        return super.Cadastro();
    }

    @Override
    public void consultarSaldo() {
        super.consultarSaldo();
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", certidao=" + certidao +
                ", tipo=" + tipo +
                ", saldo=" + saldo +
                '}';
    }


    public void depositarCP(ContaPoupanca conta, BigDecimal valor){
        BigDecimal valorAntigo = conta.getSaldo();
        valor = valor.add(valorAntigo);
        conta.setSaldo(valor);
    }

    public void sacarCP(ContaPoupanca conta, BigDecimal valor, int tipo){
        BigDecimal valorAntigo = conta.getSaldo();

        if(valorAntigo.compareTo(valor) >= 0){
            valor = valorAntigo.subtract(valor);
            conta.setSaldo(valor);
        }else {
            System.out.println("\n\nSaldo insuficiente!");
        }

    }

}
