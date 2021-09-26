package br.com.letscode.java.classes;

public class Conta {

    protected int numConta;
    protected int numAgencia;

    public Conta(int numConta, int numAgencia) {
        this.numConta = numConta;
        this.numAgencia = numAgencia;
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
}
