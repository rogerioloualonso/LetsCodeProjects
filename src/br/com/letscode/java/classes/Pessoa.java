package br.com.letscode.java.classes;

import java.math.BigDecimal;

public class Pessoa {
    protected String nome;
    protected int telefone;
    protected String endereço;
    protected int ref;

    public Pessoa(){

    }

    public Pessoa(String nome, int telefone, String endereço, int ref){
        this.nome = nome;
        this.telefone = telefone;
        this.endereço = endereço;
        this.ref = ref;
    }



    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public int getRef() {
        return ref;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "telefone=" + telefone +
                ", endereço='" + endereço + '\'' +
                ", nome='" + nome + '\'' +
                ", ref=" + ref +
                '}';
    }

    public void sacarCI(ContaInvestimento conta, BigDecimal valor, int tipo){
        BigDecimal valorAntigo = conta.getSaldo();

        if(tipo == 1){
            if(valorAntigo.compareTo(valor) >= 0){
                valor = valorAntigo.subtract(valor);
                conta.setSaldo(valor);
            }else {
                System.out.println("\n\nSaldo insuficiente!");
            }
        }else if(tipo == 2){

            BigDecimal aux = valor.multiply(BigDecimal.valueOf(0.005));
            if(aux.compareTo(valor) >= 0){
                valor = valorAntigo.subtract(aux);
                conta.setSaldo(valor);
            }else{
                System.out.println("\n\nSaldo insuficiente!");
            }
        }

    }
}
