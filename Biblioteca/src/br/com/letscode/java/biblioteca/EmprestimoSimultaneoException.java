package br.com.letscode.java.biblioteca;

public class EmprestimoSimultaneoException extends RuntimeException{

    public EmprestimoSimultaneoException(){
        super("Limite de emprestimos simultaneos excedido");
    }
}
