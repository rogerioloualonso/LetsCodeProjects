package br.com.letscode.java;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {

        int key = 0;
        int numConta, numAgencia, tipo, opcao;
        Double valor;
        Scanner sc = new Scanner(System.in);

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
                    valor = sc.nextDouble();
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
                    valor = sc.nextDouble();
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
                    valor = sc.nextDouble();
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
                    valor = sc.nextDouble();
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