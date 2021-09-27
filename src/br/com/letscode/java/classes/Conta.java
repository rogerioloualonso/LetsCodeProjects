package br.com.letscode.java.classes;

import java.util.ArrayList;

public class Conta {

    protected int numConta;
    protected int numAgencia;
    protected int certidao;
    protected int tipo;

    public Conta(){

    }

    public Conta(int numConta, int numAgencia, int certidao, int tipo) {
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.certidao = certidao;
        this.tipo = tipo;
    }

    // public void abrirConta(){
    //   ArrayList<> CP = new ArrayList<>();

    // }


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

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", numAgencia=" + numAgencia +
                ", certidao=" + certidao +
                ", tipo=" + tipo +
                '}';
    }

}
