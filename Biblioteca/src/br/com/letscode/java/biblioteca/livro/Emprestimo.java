package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.biblioteca.EmprestimoSimultaneoExcedidoException;
import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {

    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    protected Cliente cliente;
    protected Livro livro;

    public Emprestimo(){
    }

    public Emprestimo(Cliente cliente, Livro livro){
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = gerarDataDevolucao();
        this.livro = livro;
    }

    public void gerarEmprestimo(Cliente cliente, Livro livro) throws EmprestimoSimultaneoExcedidoException{
        boolean check =checarExistenciaEmprestimo();
        if (check == false) {
            setCliente(cliente);
            this.dataEmprestimo = LocalDate.now();
            this.dataDevolucao = gerarDataDevolucao();
        } else {
            throw new EmprestimoSimultaneoExcedidoException();
        }
    }

    public LocalDate gerarDataDevolucao() {
        int diasSomados = 0;
        int tempoEntrega;
        if (cliente instanceof ClienteAluno){
            tempoEntrega = 10;
        } else {
            tempoEntrega = 20;
        }
        dataDevolucao = dataEmprestimo;
        while (diasSomados < tempoEntrega){
            dataEmprestimo.plusDays(1);
            if (dataEmprestimo.getDayOfWeek() != DayOfWeek.SATURDAY && dataEmprestimo.getDayOfWeek() != DayOfWeek.SUNDAY){
                if(verificarFeriado(dataEmprestimo)) {
                    dataDevolucao = dataDevolucao.plusDays(1);
                    diasSomados++;
                }
            }
        }
        return dataDevolucao;
    }

    public boolean verificarFeriado(LocalDate data){
        //Feriados nacionais
        String[] feriados = {"01-01", "04-02", "04-21", "05-01", "09-07", "10-12",
                "11-02", "11-15", "12-25"};

        for(int i = 0; i < 9; i++){
            String compare = data.format(DateTimeFormatter.ofPattern("dd/MM"));
            if(compare == feriados[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checarExistenciaEmprestimo() {
        int checarCliente = 12345678;
        int indice = 0;

        return false;
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
