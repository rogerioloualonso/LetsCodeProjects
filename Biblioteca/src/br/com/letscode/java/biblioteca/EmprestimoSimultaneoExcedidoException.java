package br.com.letscode.java.biblioteca;

public class EmprestimoSimultaneoExcedidoException extends Exception{

    public EmprestimoSimultaneoExcedidoException(){
        super("Limite de emprestimos simultaneos excedido");
    }
}
