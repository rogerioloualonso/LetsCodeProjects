package br.com.letscode.java.classes;

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
}
