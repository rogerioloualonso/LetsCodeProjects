package br.com.letscode.java;

import br.com.letscode.java.classes.PessoaFisica;
import br.com.letscode.java.classes.PessoaJuridica;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {

    final static int TAM = 100;

    public static void main(String[] args) {

        int key = 0;
        int numConta, numAgencia, tipo, opcao;
        BigDecimal valor;
        Scanner sc = new Scanner(System.in);

        //Dados de Pessoa Física

        PessoaFisica[] PF = new PessoaFisica[TAM];
        PF[0] = new PessoaFisica(123578718, "Roger", 12547845, "Rua Zé 1");
        PF[1] = new PessoaFisica(545599874, "Stephania", 96257845, "Rua Zé 2");
        PF[2] = new PessoaFisica(123654258, "Marcus", 1255727845, "Rua Zé 3");
        PF[3] = new PessoaFisica(589754815, "Luiz", 74542545, "Rua Zé 4");
        PF[4] = new PessoaFisica(598751569, "Lucas", 57521845, "Rua Zé 5");
        PF[5] = new PessoaFisica(321457845, "Maria", 12277845, "Rua Zé 6");
        PF[6] = new PessoaFisica(125478452, "César", 59547289, "Rua Zé 7");
        PF[7] = new PessoaFisica(236985475, "Roberta", 15877845, "Rua Zé 8");
        PF[8] = new PessoaFisica(125478953, "Jean", 82587845, "Rua Zé 9");
        PF[9] = new PessoaFisica(145788854, "Antonio", 15947845, "Rua Zé 10");

        int contPF = 10;

        //Dados de pessoa Jurídica

        PessoaJuridica[] PJ = new PessoaJuridica[TAM];
        PJ[0] = new PessoaJuridica(558488955, "Wpp", 75755185, "Rua Maria 1");
        PJ[0] = new PessoaJuridica(174784545, "Linkedin", 58749185, "Rua Maria 2");
        PJ[0] = new PessoaJuridica(264785455, "Facebook", 15453055, "Rua Maria 3");
        PJ[0] = new PessoaJuridica(124785557, "Twitter", 55252185, "Rua Maria 4");
        PJ[0] = new PessoaJuridica(525747752, "TikTok", 25426185, "Rua Maria 5");
        PJ[0] = new PessoaJuridica(365784871, "Lets Code", 154885745, "Rua Maria 6");
        PJ[0] = new PessoaJuridica(214589232, "Sinqia", 152385185, "Rua Maria 7");
        PJ[0] = new PessoaJuridica(124578845, "Telemar", 52145185, "Rua Maria 8");
        PJ[0] = new PessoaJuridica(369857845, "Petrobras", 58755185, "Rua Maria 9");
        PJ[0] = new PessoaJuridica(321457859, "Carrefour", 424285185, "Rua Maria 10");

        int contPJ = 10;

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
                            System.out.println("\nQual tipo de conta?");
                            System.out.println("1 - Conta poupança");
                            System.out.println("2 - Conta corrente");
                            System.out.println("3 - Conta investimento");
                            tipo = sc.nextInt();
                                if(tipo == 1){
                                    //Abrir conta Poupança para Pessoa física
                                    //Chamar o método

                                }else if(tipo == 2){
                                    //Abrir conta corrente para pessoa física
                                    //Chamar o método
                                }else if(tipo == 3){
                                    //Abrir conta investimento para pessoa física
                                    //Chamar o método
                                }else{
                                    System.out.println("\nOpção inválida!");
                                }
                        }else if(tipo == 2){
                            System.out.println("Você escolheu Pessoa jurídica");
                            System.out.println("\nQual tipo de conta?");
                            System.out.println("1 - Conta corrente");
                            System.out.println("2 - Conta investimento");
                            tipo = sc.nextInt();

                            if(tipo == 1){
                                //Abrir conta corrente para pessoa jurídica
                                //Chamar o método
                            }else if(tipo == 2){
                                //Abrir conta investimento para pessoa jurídica
                                //Chamar o método
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
                    System.out.println("Qual a agência? R:");
                    numAgencia = sc.nextInt();
                        //Validar conta?
                    System.out.println("Qual o valor para depositar?");
                    valor = sc.nextBigDecimal();
                    //Deveríamos usar bigDecimal

                    //Chamar o método para depositar este valor na conta retornando uma mensagem
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
                    System.out.println("Qual a sua agência? R:");
                    numAgencia = sc.nextInt();
                        //Validar conta?
                    System.out.println("Qual o valor para investir?");
                    valor = sc.nextBigDecimal();
                    //Deveríamos usar bigDecimal

                    //Chamar o método para investir este valor retornando uma mensagem
                    //Tratei a função investir como se fosse um depósito na conta investimento
                    break;

                case 6:
                    System.out.println("Você escolheu Consultar saldo");
                    System.out.println("\nQual o número da sua conta? R:");
                    numConta = sc.nextInt();
                    System.out.println("Qual a sua agência? R:");
                    numAgencia = sc.nextInt();
                    //Validar conta?

                    //Chamar o método para consultar este valor retornando uma mensagem

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