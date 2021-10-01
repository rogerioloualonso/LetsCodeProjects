package br.com.letscode.java.biblioteca.livro;

public class Livro {
    private int isbn;
    private String titulo;
    private String autor;
    private String editora;

    public Livro( int isbn, String titulo, String autor, String editor){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editor) {
        this.editora = editor;
    }

    public  String toString(){
        return "Livro: "+" isbn= "+this.isbn+"; titulo= "
                +this.titulo+"; autor= "+this.autor+"; editora= "
                +this.editora+".";
    }
}
