package br.com.letscode.java.classes;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{

    private BigDecimal saldo;

    public ContaPoupanca(int numConta, int numAgencia, BigDecimal saldo) {
        super(numConta, numAgencia);
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "saldo=" + saldo +
                '}';
    }
}
