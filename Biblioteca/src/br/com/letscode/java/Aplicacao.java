package br.com.letscode.java;

import br.com.letscode.java.biblioteca.clientes.ClienteAluno;
import br.com.letscode.java.biblioteca.clientes.ClienteProfessor;
import br.com.letscode.java.biblioteca.clientes.TipoCliente;

public class Aplicacao {

    public static void main(String[] args) {
        String tpCliente = "Aluno";
        switch (tpCliente) {
            case "Aluno":
                ClienteAluno clienteA = new ClienteAluno("joao", "jao123@gmail.com", 12345678, TipoCliente.CLIENTE_ALUNO);


                break;
            case "Professor":
                ClienteProfessor clienteP = new ClienteProfessor("kleber", "klb123@gmail.com", 87654321, TipoCliente.CLIENTE_PROFESSOR);


                break;
        }
    }
}
