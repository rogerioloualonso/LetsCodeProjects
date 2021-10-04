package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.biblioteca.ClienteSuspensoException;
import br.com.letscode.java.biblioteca.EmprestimoSimultaneoException;
import br.com.letscode.java.biblioteca.LimiteDeEmprestimoExcedidoException;
import br.com.letscode.java.biblioteca.clientes.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        this.dataDevolucao = dataDevolucao;
        this.livros = livros;
    }

    public void gerarEmprestimo(ClienteDefault cliente) throws Exception {

        validarLimiteEmprestimo(cliente);
        validarComPenalidade(cliente);
        validarEmprestimoSimultaneo(cliente);

        if (cliente.getCarrinho().size() > 0){
            setCliente(cliente);
            ArrayList<Livro> livros = cliente.getCarrinho();
            setLivros(livros);
            this.dataEmprestimo = LocalDate.now();
            this.dataDevolucao = gerarDataDevolucao();
            System.out.println(this.getCliente().getNome() + " realizou o emprestimo dos livros:\n " + cliente.getCarrinho()
                        + " \nNo dia " + getDataEmprestimo() + " com data de devolução para o dia " + getDataDevolucao());
            Emprestimo emprestimo = new Emprestimo(cliente, dataEmprestimo, dataDevolucao, livros);
            cliente.getEmprestimos().add(emprestimo);
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

    public void validarLimiteEmprestimo(ClienteDefault cliente){

        if(cliente instanceof ClienteAluno){
            if (cliente.getCarrinho().size() == 3){
                throw new LimiteDeEmprestimoExcedidoException();
            }
        }

        if(cliente instanceof ClienteProfessor){
            if (cliente.getCarrinho().size() == 5){
                throw new LimiteDeEmprestimoExcedidoException();
            }
        }

    }


    public void validarComPenalidade(ClienteDefault cliente){
        if(cliente.consultaPenalidade(cliente)){
            throw new ClienteSuspensoException();
        }
    }

    public void validarEmprestimoSimultaneo(ClienteDefault cliente){
        if (cliente instanceof ClienteAluno){
            for (int i = 0; i < cliente.getEmprestimos().size(); i++){
                if (cliente.getEmprestimos().get(i) != null){
                    throw new EmprestimoSimultaneoException();
                }
            }
        }else{
            for (int i = 0; i < cliente.getEmprestimos().size(); i++){
                if (cliente.getEmprestimos().get(i) != null){
                    throw new EmprestimoSimultaneoException();
                }
            }
        }
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
