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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public  String toString(){
        return "Livro: "+" isbn= "+this.isbn+"; titulo= "
                +this.titulo+"; autor= "+this.autor+"; editor= "
                +this.editor+".";
    }
}
