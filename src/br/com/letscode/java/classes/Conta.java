package br.com.letscode.java.classes;

public class Conta {

    protected int numConta;
    protected int numAgencia;
    protected int certidao;

    public Conta(int numConta, int numAgencia, int certidao) {
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.certidao = certidao;
    }

    public int getNumConta() {
        return numConta;
    }

    public int getNumAgencia() {
        return numAgencia;
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
                '}';
    }

    public void abrirConta(){
        numConta += 1;
        numAgencia += 2;
        //saldo = null;
    }



}
