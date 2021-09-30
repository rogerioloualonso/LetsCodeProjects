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

    public Emprestimo(Cliente cliente){
        if (cliente instanceof ClienteAluno){
            this.cliente = new ClienteAluno();
        } else {
            this.cliente = new ClienteProfessor();
        }
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
    }

    public Emprestimo gerarEmprestimo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite se o empréstimo pertence a um professor ou a um aluno: ");
        String tpCliente = sc.nextLine();
        if (tpCliente.equalsIgnoreCase("aluno")) {
            this.cliente = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);
        } else if (tpCliente.equalsIgnoreCase("professor")) {
            this.cliente = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);
        }
        LocalDate devolucao = gerarDataDevolucao();
        Emprestimo emprestimo = new Emprestimo(cliente);
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

}
