package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaCorrente extends Conta{

    private double taxa = 0.005;

    public ContaCorrente(int numConta, int numAgencia, int certidao, BigDecimal saldo, int tipo) {
        super(numConta, numAgencia, certidao, saldo, tipo);
        this.saldo = saldo;
    }

    public ContaCorrente(){

    }

    @Override
    public Conta Cadastro() {
        return super.Cadastro();
    }

    @Override
    public Conta CadastroJuridico() {
        return super.CadastroJuridico();
    }

    @Override
    public void consultarSaldo() {
        super.consultarSaldo();
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

    public void depositarCC(ContaCorrente conta, BigDecimal valor){
        BigDecimal valorAntigo = conta.getSaldo();
        valor = valor.add(valorAntigo);
        conta.setSaldo(valor);
    }

}