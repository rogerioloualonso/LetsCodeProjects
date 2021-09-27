package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaPoupanca extends Conta{

    private BigDecimal saldo;

    public ContaPoupanca(int cpf, int numConta, int numAgencia, BigDecimal saldo, int tipo) {
        super(numConta, numAgencia, cpf, tipo);
        this.saldo = saldo;
    }

    public ContaPoupanca(){

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
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", certidao=" + certidao +
                ", tipo=" + tipo +
                ", saldo=" + saldo +
                '}';
    }

    public ContaPoupanca CadastroCp(){
        Scanner sc = new Scanner(System.in);
        Aplicacao dados = new Aplicacao();
        int cpf = dados.getCPF();
        int conta = dados.getnConta();
        int agencia = 12;
        BigDecimal saldo = BigDecimal.valueOf(0);
        ContaPoupanca cp = new ContaPoupanca(cpf, conta, agencia, saldo, 1);
        return cp;
    }

    public void depositarCP(ContaPoupanca conta, BigDecimal valor){
        BigDecimal valorAntigo = conta.getSaldo();
        valor = valor.add(valorAntigo);
        conta.setSaldo(valor);
    }

}
