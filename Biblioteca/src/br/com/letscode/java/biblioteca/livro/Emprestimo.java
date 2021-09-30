package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteProfessor;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Emprestimo {

    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    protected Cliente cliente;

    public Emprestimo(){

    }

    public Emprestimo(Cliente cliente, LocalDate dataEmprestimo, LocalDate dataDevolucao){
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
    }

    public Emprestimo gerarEmprestimo(){
        Scanner sc = new Scanner(System.in);
        cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
        Emprestimo emprestimo = new Emprestimo(this.cliente, dataEmprestimo, dataDevolucao);
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

    @Override
    public String toString() {
        return "Emprestimo{" +
                "dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", cliente=" + cliente +
                '}';
    }
}
