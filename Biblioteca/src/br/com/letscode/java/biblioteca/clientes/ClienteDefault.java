package br.com.letscode.java.biblioteca.clientes;

import br.com.letscode.java.biblioteca.LimiteDeEmprestimoExcedidoException;
import br.com.letscode.java.biblioteca.LivroJaEmprestadoException;
import br.com.letscode.java.biblioteca.livro.Emprestimo;
import br.com.letscode.java.biblioteca.livro.Livro;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ClienteDefault implements Cliente{

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    protected String nome;
    protected String email;
    protected int matricula;
    protected TipoCliente tipoCliente;
    protected LocalDate dataDevolucao;
    protected ArrayList<Livro> carrinho = new ArrayList<>();

    public ClienteDefault() {
    }

    public ClienteDefault(String nome, String email, int matricula, TipoCliente tipoCliente) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.tipoCliente = tipoCliente;
    }


    @Override
    public boolean consultaPenalidade(ClienteDefault cliente) {
        int numOcorrencias = 0;
        for (int i = 0; i < cliente.getEmprestimos().size(); i++) {
            if ((LocalDate.now()).isAfter(cliente.getEmprestimos().get(i).getDataDevolucao())) {
                numOcorrencias++;
            }
        }
        if (numOcorrencias > 0) {
            return true;
        } else {
            return false;
        }
    }


    public void adicionarCarrinho(ClienteDefault cliente, Livro livro) throws LivroJaEmprestadoException {
        if (livro.isDisponivel()){
            cliente.getCarrinho().add(livro);
            livro.setDisponivel(false);
        } else {
            try {
                //System.err.println("O livro " + livro + "não está disponível");
                //getExceptionCarrinho(cliente, livro);
            } catch (LivroJaEmprestadoException e) {
                throw new LivroJaEmprestadoException();
            }
        }
    }

    @Override
    public String toString() {
        return "ClienteDefault{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", matricula=" + matricula +
                ", tipoCliente=" + tipoCliente +
                '}';
    }

    public ArrayList<Livro> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Livro> carrinho) {
        this.carrinho = carrinho;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getMatricula() {
        return matricula;
    }

    protected void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}
