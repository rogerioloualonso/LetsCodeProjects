package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteDefault;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {

    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    protected Cliente cliente;
    protected Livro livro;

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
                this.dataEmprestimo = LocalDate.now();
                this.dataDevolucao = gerarDataDevolucao();
                livro.setDisponivel(false);
                System.out.println(this.getCliente().getNome() + " realizou o emprestimo do livro " + livro.getTitulo()
                        + " no dia " + getDataEmprestimo() + " com data de devolução para o dia " + getDataDevolucao());
                Emprestimo emprestimo = new Emprestimo(this.cliente, dataEmprestimo, dataDevolucao, livro);
                cliente.getEmprestimos().add(emprestimo);
            } else {
                System.out.println("O livro " + livro.getTitulo() + " está indisponível");//puxar exception
            }
        } else {
            System.out.println("Esta pessoa não pode fazer empréstimo");//puxar exception
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

    //Aguardando esclarecimento do enunciado
    /*public boolean checarExistenciaEmprestimo(ClienteDefault cliente) {
        int indice = 0;
        Aplicacao aplicacao = new Aplicacao();
        /*ArrayList<Emprestimo> emprestimos = aplicacao.getEmprestimos();
        for (int i = 0; i < (emprestimos.size()); i++) {
            if ((emprestimos.get(i).getCliente().getMatricula()) == checarCliente) {
                indice = i;
            }//Consertar o getMatricula
        }
        if (emprestimos.get(indice).getLivro() != null) {
            return true;
        } else {
            return false;
        }
        return true;
    }*/

    public boolean validarEmprestimo(ClienteDefault cliente){
        if (cliente instanceof ClienteAluno){
            if ((cliente.getEmprestimos().size() == 3 || cliente.consultaPenalidade(cliente))){
                return false;
            }
        } else {
            if ((cliente.getEmprestimos().size() == 5 || cliente.consultaPenalidade(cliente))){
                return false;
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
