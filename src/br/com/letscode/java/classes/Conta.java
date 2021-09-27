package br.com.letscode.java.classes;

import br.com.letscode.java.Aplicacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Conta {

    protected int numConta;
    protected int numAgencia;
    protected int certidao;
    protected int tipo;
    protected int ref;

    protected BigDecimal saldo;

    public Conta(){

    }

    public Conta(int numConta, int numAgencia, int certidao,BigDecimal saldo, int tipo, int ref) {
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.certidao = certidao;
        this.saldo = saldo;
        this.tipo = tipo;
        this.ref = ref;
    }

    public int getRef() {
        return ref;
    }

    public int getTipo() {
        return tipo;
    }

    public int getCertidao() {
        return certidao;
    }

    public int getNumConta() {
        return numConta;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setCertidao(int certidao) {
        this.certidao = certidao;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", certidao=" + certidao +
                ", tipo=" + tipo +
                ", ref=" + ref +
                ", saldo=" + saldo +
                '}';
    }

    protected Conta Cadastro(){
        Scanner sc = new Scanner(System.in);
        Aplicacao dados = new Aplicacao();
        BigDecimal saldo = new BigDecimal(0);
        saldo.add(new BigDecimal(100));
        int certidao = dados.getCPF();
        int conta = dados.getnConta();
        int agencia = 12;
        Conta co = new Conta(conta,agencia,certidao,saldo,0, 1);
        return co;
    }

    protected Conta CadastroJuridico(){
        Scanner sc = new Scanner(System.in);
        Aplicacao dados = new Aplicacao();
        BigDecimal saldo = new BigDecimal(0);
        saldo.add(new BigDecimal(100));
        int certidao = dados.getCNPJ();
        int conta = dados.getnConta();
        int agencia = 12;
        Conta co = new Conta(conta,agencia,certidao,saldo,0, 2);
        return co;
    }

    protected void consultarSaldo(){
        Aplicacao dados = new Aplicacao();
        System.out.println("Seu saldoa atual é = "+dados.getSaldoExport());
    }

    public static void transferir(Conta contaSacar, Conta contaDepositar, BigDecimal valor){

        if(contaSacar.getRef() == 1){
            if(contaSacar.getTipo() == 0){
                ((ContaCorrente)contaSacar).sacarCC(((ContaCorrente)contaSacar), valor, 1);
                ((ContaCorrente)contaDepositar).depositarCC(((ContaCorrente) contaDepositar),
                        ((ContaCorrente)contaDepositar).getSaldo());
            }else if(contaSacar.getTipo() == 1){
                ((ContaPoupanca)contaSacar).sacarCP(((ContaPoupanca)contaSacar), valor, 1);
                ((ContaPoupanca)contaDepositar).depositarCP(((ContaPoupanca) contaDepositar),
                        ((ContaPoupanca)contaDepositar).getSaldo());
            }else if(contaSacar.getTipo() == 2){
                ((ContaInvestimento)contaSacar).sacarCI(((ContaInvestimento)contaSacar), valor, 1);
                ((ContaInvestimento)contaDepositar).depositarCI(((ContaInvestimento) contaDepositar),
                        ((ContaInvestimento)contaDepositar).getSaldo());
            }

        }else if(contaSacar.getRef() == 2){
            if(contaSacar.getTipo() == 0){
                ((ContaCorrente)contaSacar).sacarCC(((ContaCorrente)contaSacar), valor, 2);
                ((ContaCorrente)contaDepositar).depositarCC(((ContaCorrente) contaDepositar),
                        ((ContaCorrente)contaDepositar).getSaldo());
            }else if(contaSacar.getTipo() == 2){
                ((ContaInvestimento)contaSacar).sacarCI(((ContaInvestimento)contaSacar), valor, 2);
                ((ContaInvestimento)contaDepositar).depositarCI(((ContaInvestimento) contaDepositar),
                        ((ContaInvestimento)contaDepositar).getSaldo());
            }
        }

    }


}
