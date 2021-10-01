package br.com.letscode.java.biblioteca;

public class EmprestimoSimultaneoExcedidoException extends RuntimeException{

    public EmprestimoSimultaneoExcedidoException(){
        super("Limite de emprestimos simultaneos excedido");
    }
}
