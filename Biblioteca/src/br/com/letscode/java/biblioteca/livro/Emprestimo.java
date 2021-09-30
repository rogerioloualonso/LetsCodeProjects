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


    public Emprestimo(){

    }

    public Emprestimo(Cliente cliente, LocalDate dataEmprestimo, LocalDate dataDevolucao){

        dataEmprestimo = LocalDate.now();
        dataDevolucao = gerarDataDevolucao();
    }

    public Emprestimo gerarEmprestimo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite se o empréstimo pertence a um professor ou a um aluno: ");
        String tpCliente = sc.nextLine();
        Cliente cliente = null;
        if (tpCliente.toLowerCase() == "aluno") {
            cliente = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);
        } else if (tpCliente.toLowerCase() == "professor") {
            cliente = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);
        }
        Emprestimo emprestimo = new Emprestimo(cliente, LocalDate.now(), gerarDataDevolucao());
        return emprestimo;
    }


    public LocalDate gerarDataDevolucao() {
        int diaSomados = 0;
        dataDevolucao = dataEmprestimo;
        while (diaSomados < this.tempoEntrega){
            if (this.dataEmprestimo.plusDays(1).getDayOfWeek() != DayOfWeek.SATURDAY || this.dataEmprestimo.plusDays(1).getDayOfWeek() != DayOfWeek.SUNDAY){
                dataDevolucao = dataDevolucao.plusDays(1);
                diaSomados++;
            }
        }
        return dataDevolucao;
    }

}
