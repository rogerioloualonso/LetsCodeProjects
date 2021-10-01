package br.com.letscode.java.biblioteca;

public class LimiteDeEmprestimoExcedidoException extends RuntimeException{

    public LimiteDeEmprestimoExcedidoException(){
        super("Limite de empréstimo excedido");
    }
}
