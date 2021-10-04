package br.com.letscode.java.biblioteca;

public class LivroJaEmprestadoException extends RuntimeException{

    public LivroJaEmprestadoException(){
        super("Este livro ja está em um empréstimo");
    }
}
