package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteDefault;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Emprestimo {

    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    protected Cliente cliente;
    protected Livro livro;
    protected Livro livro2;
    protected Livro livro3;

    public Emprestimo(){
    }

    public Emprestimo(Cliente cliente, LocalDate dataEmprestimo, LocalDate dataDevolucao, Livro livro){
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
        this.livro = livro;
    }

    public void gerarEmprestimo(ClienteDefault cliente, Livro livro){
        if (validarEmprestimo(cliente)) {
            if (livro.isDisponivel()) {
                setCliente(cliente);
                setLivro(livro);
                this.dataEmprestimo = LocalDate.now();
                this.dataDevolucao = gerarDataDevolucao();
                livro.setDisponivel(false);
                System.out.println(this.getCliente().getNome() + " realizou o emprestimo do livro " + livro.getTitulo()
                        + " no dia " + getDataEmprestimo() + " com data de devolução para o dia " + getDataDevolucao());
                Emprestimo emprestimo = new Emprestimo(cliente, dataEmprestimo, dataDevolucao, livro);
                cliente.getEmprestimos().add(emprestimo);
            } else {
                System.err.println("O livro " + livro.getTitulo() + " está indisponível");//puxar exception
            }
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
