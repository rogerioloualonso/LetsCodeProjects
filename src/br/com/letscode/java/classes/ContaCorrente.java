package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaCorrente extends Conta{

    public ContaCorrente(int numConta, int numAgencia, int certidao, BigDecimal saldo, int tipo, int ref) {
        super(numConta, numAgencia, certidao, saldo, tipo, ref);
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
                '}';
    }

    public void depositarCC(ContaCorrente conta, BigDecimal valor){
        BigDecimal valorAntigo = conta.getSaldo();
        valor = valor.add(valorAntigo);
        conta.setSaldo(valor);
    }

    public void sacarCC(ContaCorrente conta, BigDecimal valor, int tipo){
        BigDecimal valorAntigo = conta.getSaldo();

        if(tipo == 1){
            if(valorAntigo.compareTo(valor) >= 0){
                valor = valorAntigo.subtract(valor);
                conta.setSaldo(valor);
            }else {
                System.out.println("\n\nSaldo insuficiente!");
            }
        }else if(tipo == 2){

            BigDecimal aux = valor.multiply(BigDecimal.valueOf(1.005));
            if(aux.compareTo(valor) >= 0){
                valor = valorAntigo.subtract(aux);
                conta.setSaldo(valor);
            }else{
                System.out.println("\n\nSaldo insuficiente!");
            }
        }

    }



}