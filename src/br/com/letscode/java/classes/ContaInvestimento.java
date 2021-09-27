package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaInvestimento extends Conta{

    public ContaInvestimento(int certidao, int numConta, int numAgencia, BigDecimal saldo, int tipo) {
        super(numConta, numAgencia, certidao, saldo, tipo);
    }

    public ContaInvestimento(){

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
        return "ContaInvestimento{" +
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", certidao=" + certidao +
                ", tipo=" + tipo +
                ", saldo=" + saldo +
                '}';
    }


    public void depositarCI(ContaInvestimento conta, BigDecimal valor){
        BigDecimal valorAntigo = conta.getSaldo();
        valor = valor.add(valorAntigo);
        conta.setSaldo(valor);
    }

    public void investir(ContaInvestimento conta, BigDecimal valor){
        BigDecimal valorAntigo = conta.getSaldo();
        valor = valor.add(valorAntigo);
        conta.setSaldo(valor);
    }

    public void sacarCI(ContaInvestimento conta, BigDecimal valor){
        BigDecimal valorAntigo = conta.getSaldo();

        /*
        if(valorAntigo >= valor){
            valor = valor.subtract(valorAntigo);
            conta.setSaldo(valor);
        }
        */
    }
}
