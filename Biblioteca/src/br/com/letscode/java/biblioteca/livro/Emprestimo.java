package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.Aplicacao;
import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Emprestimo {

    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    protected Cliente cliente;
    protected Livro livro;

    public Emprestimo(){

    }

    public Emprestimo(Cliente cliente, LocalDate dataEmprestimo, LocalDate dataDevolucao, Livro livro){
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
        this.livro = livro;
    }

    public Emprestimo gerarEmprestimo(){
        Scanner sc = new Scanner(System.in);
        cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
        String nomeLivro = "God of War";
        Aplicacao aplicacao = new Aplicacao();
        ArrayList<Livro> listaLivros = aplicacao.getListaLivros();
        int indice = 0;
        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getTitulo() == nomeLivro) {
                indice = i;
            }
        }
        Livro livro = listaLivros.get(indice);
        Emprestimo emprestimo = new Emprestimo(this.cliente, dataEmprestimo, dataDevolucao, livro);
        return emprestimo;
    }



    public LocalDate gerarDataDevolucao() {
        int diaSomados = 0;
        int tempoEntrega;
        if (cliente instanceof ClienteAluno){
            tempoEntrega = 10;
        } else {
            tempoEntrega = 20;
        }
        dataDevolucao = dataEmprestimo;
        while (diaSomados < tempoEntrega){
            if (this.dataEmprestimo.plusDays(1).getDayOfWeek() != DayOfWeek.SATURDAY || this.dataEmprestimo.plusDays(1).getDayOfWeek() != DayOfWeek.SUNDAY){
                dataDevolucao = dataDevolucao.plusDays(1);
                diaSomados++;
            }
        }
        return dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", cliente=" + cliente +
                ", livro=" + livro +
                '}';
    }
}
