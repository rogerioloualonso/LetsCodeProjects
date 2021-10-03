package br.com.letscode.java.biblioteca.livro;

import br.com.letscode.java.Aplicacao;
import br.com.letscode.java.biblioteca.clientes.Cliente;
import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteDefault;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public void gerarEmprestimo(ClienteDefault cliente, Livro livro){
        if (validarEmprestimo() == true) {
            if (livro.isDisponivel()) {
                setCliente(cliente);
                this.dataEmprestimo = LocalDate.now();
                this.dataDevolucao = gerarDataDevolucao();
                livro.setDisponivel(false);
                System.out.println(this.getCliente().getNome() + " realizou o emprestimo do livro " + livro.getTitulo()
                        + " no dia " + getDataEmprestimo() + " com data de devolução para o dia " + getDataDevolucao());
                if (cliente.getTipoCliente() == TipoCliente.CLIENTE_ALUNO) {
                    ClienteAluno  = new Aplicacao();
                }
                Emprestimo emprestimo = new Emprestimo(this.cliente, dataEmprestimo, dataDevolucao, livro);

            /*ArrayList<Livro> listaLivros = aplicacao.getListaLivros();
            int indice = 0;
            String nomeLivro = "God of War";
            for (int i = 0; i < (listaLivros.size()); i++) {
                if ((listaLivros.get(i).getTitulo()) == nomeLivro) {
                    indice = i;
                }
            }
            Livro livro = listaLivros.get(indice);
            ArrayList<Emprestimo> emprestimos = aplicacao.getEmprestimos();*/
                //Emprestimo emprestimo = new Emprestimo(this.cliente, dataEmprestimo, dataDevolucao, livro);
                //emprestimos.add(emprestimo);
            } else {
                System.out.println("O livro " + livro.getTitulo() + " está indisponível");//puxar exception
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

    public boolean checarExistenciaEmprestimo(ClienteDefault cliente) {
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
        }*/
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
