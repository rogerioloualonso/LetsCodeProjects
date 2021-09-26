package br.com.letscode.java.classes;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta{

    private BigDecimal saldo;

    public ContaInvestimento(int certidao, int numConta, int numAgencia, BigDecimal saldo) {
        super(numConta, numAgencia, certidao);
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
        return "ContaInvestimento{" +
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", saldo=" + saldo +
                '}';
    }
}
