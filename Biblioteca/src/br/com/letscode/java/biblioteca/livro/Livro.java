package br.com.letscode.java.biblioteca.livro;

public class Livro {
    private int isbn;
    private String titulo;
    private String autor;
    private String editor;

    public Livro( int isbn, String titulo, String autor, String editor){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editor = editor;
    }
    public  String toString(){
        return "Livro: "+" isbn= "+this.isbn+"; titulo= "
                +this.titulo+"; autor= "+this.autor+"; editor= "
                +this.editor+".";
    }
}
