package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteDefault;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Emprestimo {

    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    protected Cliente cliente;
    protected ArrayList<Livro> livros = new ArrayList<>();

    public Emprestimo(){
    }

    public Emprestimo(Cliente cliente, LocalDate dataEmprestimo, LocalDate dataDevolucao, ArrayList<Livro> livros){
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
        this.livros = livros;
    }

    public void gerarEmprestimo(ClienteDefault cliente) {
        if (validarEmprestimo(cliente)) {
            setCliente(cliente);
            ArrayList<Livro> livros = cliente.getCarrinho();
            setLivros(livros);
            this.dataEmprestimo = LocalDate.now();
            this.dataDevolucao = gerarDataDevolucao();
            System.out.println(this.getCliente().getNome() + " realizou o emprestimo dos livros " + cliente.getCarrinho()
                    + " no dia " + getDataEmprestimo() + " com data de devolução para o dia " + getDataDevolucao());
            Emprestimo emprestimo = new Emprestimo(cliente, dataEmprestimo, dataDevolucao, livros);
            cliente.getEmprestimos().add(emprestimo);
        } else {
            System.out.println("Esta pessoa não pode fazer empréstimo");//puxar exception
        }
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

    public boolean validarEmprestimo(ClienteDefault cliente){
        if (cliente instanceof ClienteAluno){
            if ((cliente.getEmprestimos().size() == 3 || cliente.consultaPenalidade(cliente))){
                return false;
            }
            for (int i = 0; i < cliente.getEmprestimos().size(); i++){
                if (!cliente.getEmprestimos().get(i).getDataEmprestimo().equals(LocalDate.now())){
                return false;
                }
            }
        } else {
            if ((cliente.getEmprestimos().size() == 5 || cliente.consultaPenalidade(cliente))){
                return false;
            }
            for (int i = 0; i < cliente.getEmprestimos().size(); i++){
                if (!cliente.getEmprestimos().get(i).getDataEmprestimo().equals(LocalDate.now())){
                    return false;
                }
            }
        }
        return true;
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

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", cliente=" + cliente +
                ", livro=" + livros +
                '}';
    }
}
