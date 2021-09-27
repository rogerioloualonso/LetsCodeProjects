package br.com.letscode.java;

import br.com.letscode.java.classes.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {

    final static int TAM = 100;

    static int contPF;
    static int contPJ;
    static int cpfExport;
    static int cnpjExport;
    static int nConta;
    static BigDecimal saldoExport;


    public int getCPF(){
        int cpf = cpfExport;
        return cpf;
    }

    public int getCNPJ(){
        int cnpj = cnpjExport;
        return cnpj;
    }

    public static int getnConta() {
        return nConta;
    }

    public static BigDecimal getSaldoExport() {
        return saldoExport;
    }

    public static int acharConta(int numConta, Conta vetor[], int tam){

        for(int i = 0; i < tam; i++){
            if(vetor[i].getNumConta() == numConta){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int key = 0;
        int numConta, numAgencia, tipo, opcao, indice, aux;
        BigDecimal valor;
        Scanner sc = new Scanner(System.in);

        Pessoa[] pessoas = new PessoaFisica[TAM];
        pessoas[0] = new PessoaFisica(123578718, "Roger", 12547845, "Rua Zé 1");
        pessoas[1] = new PessoaFisica(545599874, "Stephania", 96257845, "Rua Zé 2");
        pessoas[2] = new PessoaFisica(123654258, "Marcus", 1255727845, "Rua Zé 3");
        pessoas[3] = new PessoaFisica(589754815, "Luiz", 74542545, "Rua Zé 4");
        pessoas[4] = new PessoaFisica(598751569, "Lucas", 57521845, "Rua Zé 5");
        pessoas[5] = new PessoaFisica(321457845, "Maria", 12277845, "Rua Zé 6");
        pessoas[6] = new PessoaFisica(125478452, "César", 59547289, "Rua Zé 7");
        pessoas[7] = new PessoaFisica(236985475, "Roberta", 15877845, "Rua Zé 8");
        pessoas[8] = new PessoaFisica(125478953, "Jean", 82587845, "Rua Zé 9");
        pessoas[9] = new PessoaFisica(145788854, "Antonio", 15947845, "Rua Zé 10");
        pessoas[10] = new PessoaJuridica(558488955, "Wpp", 75755185, "Rua Maria 1");
        pessoas[11] = new PessoaJuridica(174784545, "Linkedin", 58749185, "Rua Maria 2");
        pessoas[12] = new PessoaJuridica(264785455, "Facebook", 15453055, "Rua Maria 3");
        pessoas[13] = new PessoaJuridica(124785557, "Twitter", 55252185, "Rua Maria 4");
        pessoas[14] = new PessoaJuridica(525747752, "TikTok", 25426185, "Rua Maria 5");
        pessoas[15] = new PessoaJuridica(365784871, "Lets Code", 154885745, "Rua Maria 6");
        pessoas[16] = new PessoaJuridica(214589232, "Sinqia", 152385185, "Rua Maria 7");
        pessoas[17] = new PessoaJuridica(124578845, "Telemar", 52145185, "Rua Maria 8");
        pessoas[18] = new PessoaJuridica(369857845, "Petrobras", 58755185, "Rua Maria 9");
        pessoas[19] = new PessoaJuridica(321457859, "Carrefour", 424285185, "Rua Maria 10");
        int contPessoas = 20;

        //Dados conta

        Conta[] contas = new Conta[TAM];
        contas[0] = new ContaPoupanca(123578718, 2470, 13, new BigDecimal(10000), 1);
        contas[1] = new ContaPoupanca(145788854, 2471, 12, new BigDecimal(90000), 1);
        contas[2] = new ContaPoupanca(125478953, 2472, 13, new BigDecimal(3000), 1);
        contas[3] = new ContaPoupanca(545599874, 2473, 10, new BigDecimal(1000), 1);
        contas[4] = new ContaPoupanca(123654258, 2474, 11, new BigDecimal(100), 1);
        contas[5] = new ContaInvestimento(598751569, 2340, 13, new BigDecimal(50000), 2);
        contas[6] = new ContaInvestimento(123654258, 2341, 10, new BigDecimal(500000), 2);
        contas[7] = new ContaInvestimento(145788854, 2342, 11, new BigDecimal(10000), 2);
        contas[8] = new ContaCorrente(125478953, 2210, 11, new BigDecimal(5000), 0);
        contas[9] = new ContaCorrente(525747752, 2211, 10, new BigDecimal(7000), 0);
        contas[10] = new ContaCorrente(321457845, 2212, 13, new BigDecimal(1500), 0);
        contas[11] = new ContaCorrente(525747752, 2213, 11, new BigDecimal(500), 0);
        contas[12] = new ContaCorrente(365784871, 2214, 12, new BigDecimal(0), 0);
        contas[13] = new ContaCorrente(589754815, 2215, 10, new BigDecimal(90000), 0);
        int contConta = 14;



        do {
            //Menu do app
            System.out.println("**** Let's Bank ****");
            System.out.println("Escolha a operação:");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Investir");
            System.out.println("6 - Consultar saldo");
            System.out.println("7 - Encerrar aplicativo");

            System.out.printf("\nDigite a opçã́o:");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    System.out.printf("\nVocê escolheu abrir conta");
                    System.out.println("Conta para PF ou PJ?");
                    System.out.println("1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    System.out.println("R: ");
                    tipo = sc.nextInt();
                    if(tipo == 1){
                        System.out.println("Você escolheu Pessoa física");
                        //Cadastro pessoa física
                        PessoaFisica pf = new PessoaFisica();
                        pessoas[contPessoas] = pf.cadastroPf();
                        cpfExport = ((PessoaFisica)pessoas[contPessoas]).getCpf();
                        contPF++;

                        System.out.println("\nQual tipo de conta?");
                        System.out.println("1 - Conta poupança");
                        System.out.println("2 - Conta corrente");
                        System.out.println("3 - Conta investimento");
                        tipo = sc.nextInt();
                        if(tipo == 1){
                            //Abrir conta Poupança para Pessoa física
                            ContaPoupanca cp = new ContaPoupanca();
                            contas[contConta] = cp.Cadastro();
                            contConta++;
                            nConta++;

                        }else if(tipo == 2){
                            //Abrir conta corrente para pessoa física
                            ContaCorrente cc = new ContaCorrente();
                            contas[contConta] = cc.Cadastro();
                            contConta++;
                            nConta++;

                        }else if(tipo == 3){
                            //Abrir conta investimento para pessoa física
                            ContaInvestimento ci = new ContaInvestimento();
                            contas[contConta] = ci.Cadastro();
                            contConta++;
                            nConta++;

                        }else{
                            System.out.println("\nOpção inválida!");
                        }
                    }else if(tipo == 2){
                        System.out.println("Você escolheu Pessoa jurídica");
                        //Cadastro pessoa juridica
                        PessoaJuridica pj = new PessoaJuridica();
                        pessoas[contPJ] = pj.cadastroPj();
                        cnpjExport = ((PessoaJuridica)pessoas[contPJ]).getCnpj();
                        contPJ++;

                        System.out.println("\nQual tipo de conta?");
                        System.out.println("1 - Conta corrente");
                        System.out.println("2 - Conta investimento");
                        tipo = sc.nextInt();

                        if(tipo == 1){
                            //Abrir conta corrente para pessoa jurídica
                            ContaCorrente cc = new ContaCorrente();
                            contas[contConta] = cc.CadastroJuridico();
                            contConta++;
                            nConta++;

                        }else if(tipo == 2){
                            //Abrir conta investimento para pessoa jurídica
                            ContaInvestimento ci = new ContaInvestimento();
                            contas[contConta] = ci.CadastroJuridico();
                            contConta++;
                            nConta++;

                        }else{
                            System.out.println("\nOpção inválida!");
                        }
                    }else{
                        System.out.println("\nOpção inválida!");
                    }
                    break;

                case 2:
                    System.out.println("Você escolheu sacar");
                    System.out.println("\nQual o número da conta? R:");
                    numConta = sc.nextInt();
                    System.out.println("Qual a agência? R:");
                    numAgencia = sc.nextInt();
                    //Validar conta?
                    System.out.println("Qual o valor para sacar?");
                    valor = sc.nextBigDecimal();
                    //Deveríamos usar bigDecimal

                    //Chamar o método para sacar este valor da conta retornando uma mensagem
                    break;

                case 3:
                    System.out.println("Você escolheu depositar");
                    System.out.println("\nQual o número da conta? R:");
                    numConta = sc.nextInt();
                    System.out.println("Qual o valor para depositar?");
                    valor = sc.nextBigDecimal();

                    indice = acharConta(numConta, contas, contConta);

                    aux = contas[indice].getTipo();

                    if(aux == 0){
                        ((ContaCorrente)contas[indice]).depositarCC(((ContaCorrente) contas[indice]),
                                ((ContaCorrente)contas[indice]).getSaldo());
                    }else if(aux == 1){
                        ((ContaPoupanca)contas[indice]).depositarCP(((ContaPoupanca) contas[indice]),
                                ((ContaPoupanca)contas[indice]).getSaldo());
                    }else if (aux == 2){
                        ((ContaInvestimento)contas[indice]).depositarCI(((ContaInvestimento) contas[indice]),
                                ((ContaInvestimento)contas[indice]).getSaldo());
                    }
                    break;

                case 4:
                    System.out.println("Você escolheu transferir");
                    System.out.println("\nQual o número da sua conta? R:");
                    numConta = sc.nextInt();
                    System.out.println("Qual a sua agência? R:");
                    numAgencia = sc.nextInt();
                    //Validar conta?
                    System.out.println("\nQual o número da conta de destino? R:");
                    int numContaDestino = sc.nextInt();
                    System.out.println("Qual a agência da conta de destino? R:");
                    int numAgenciaDestino = sc.nextInt();
                    //Validar conta?
                    System.out.println("Qual o valor para depositar?");
                    valor = sc.nextBigDecimal();
                    //Deveríamos usar bigDecimal

                    //Chamar o método para transferir este valor retornando uma mensagem
                    break;

                case 5:
                    System.out.println("Você escolheu investir");
                    System.out.println("\nQual o número da sua conta investimento? R:");
                    numConta = sc.nextInt();
                    System.out.println("Qual o valor para investir?");
                    valor = sc.nextBigDecimal();

                    indice = acharConta(numConta, contas, contConta);

                    aux = contas[indice].getTipo();

                    if(aux == 2){
                        ((ContaInvestimento)contas[indice]).depositarCI(((ContaInvestimento) contas[indice]),
                                ((ContaInvestimento)contas[indice]).getSaldo());
                    }else{
                        System.out.println("\nEsta não é uma conta para investimento.");
                    }
                    break;

                case 6:
                    System.out.println("Você escolheu Consultar saldo");
                    System.out.println("\nQual o número da sua conta? R:");
                    numConta = sc.nextInt();
                    System.out.println("Qual a sua agência? R:");
                    numAgencia = sc.nextInt();
                    //Validar conta?

                    //Chamar o método para consultar este valor retornando uma mensagem
                    saldoExport = contas[contConta].getSaldo();
                case 7:
                    System.out.println("\nAplicativo encerrado!");
                    key = 1;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (key == 0);



    }



}