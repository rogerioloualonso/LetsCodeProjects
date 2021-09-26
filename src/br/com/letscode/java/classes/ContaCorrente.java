package br.com.letscode.java.classes;

import java.math.BigDecimal;

public class ContaCorrente extends Conta{

    private BigDecimal saldo;

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
}