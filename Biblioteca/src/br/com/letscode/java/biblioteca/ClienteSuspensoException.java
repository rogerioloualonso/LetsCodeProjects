package br.com.letscode.java.biblioteca;

public class ClienteSuspensoException extends RuntimeException{

    public ClienteSuspensoException(){
        super("Cliente em periodo de suspensao");
    }
}
