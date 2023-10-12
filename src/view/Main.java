package view;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
                Scanner numbers = new Scanner(System.in);

                List<Conta> contas = new ArrayList<>();
                List<Cliente> clientes = new ArrayList<>();

                System.out.println("\n Informe: \n (1) para criar conta poupança \n (2) para criar conta corrente \n (3) para acessar conta \n (4) para sair");
                int choose = numbers.nextInt();

                while (choose != 4) {

                    switch (choose) {

                        case 1 -> {
                            // Tipo de cliente a ser cadastrado

                            System.out.println("\n Informe: \n (1) para criar conta pessoa fisica \n (2) para criar conta pessoa juridica \n");
                            int tipoPessoa = numbers.nextInt();

                            if  (tipoPessoa != 1 && tipoPessoa != 2){
                                System.out.println("Opção inválida");
                                break;
                            }

                            // Informações referente ao endereço
                            System.out.println("Informe o numero da casa: ");
                            int numero = numbers.nextInt();

                            System.out.println("Informe o nome da sua rua: ");
                            String rua = input.nextLine();

                            System.out.println("Informe a cidade onde você mora: ");
                            String cidade = input.nextLine();

                            // Valores default
                            double saldo = 0;
                            LocalDate dataAbertura = LocalDate.now();
                            double taxaJuros = 0;
                            double limitCred = 0;

                            // Informações sobre a conta

                            System.out.println("Informe o número da agencia: ");
                            int agencia = numbers.nextInt();

                            System.out.println("Informe o numero da conta: ");
                            int numeroConta = numbers.nextInt();

                            // Ser for pessoa fisica
                            if (tipoPessoa == 1){
                                System.out.println("Informe seu cpf: ");
                                String cpf = input.nextLine();

                                System.out.println("Informe seu nome: ");
                                String nome = input.nextLine();

                                System.out.println("Informe sua data de nascimento: ");
                                String idade = input.nextLine();

                                String[] parts = idade.split("/");
                                LocalDate dataNascimento = LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));

                                Endereco endereco = new Endereco(rua, numero, cidade);
                                PessoaFisica clienteFisico = new PessoaFisica(limitCred, endereco, cpf, nome, dataNascimento);

                                ContaPoupanca contaPoupanca = new ContaPoupanca(agencia, numeroConta, saldo, dataAbertura, clienteFisico, taxaJuros);

                                clientes.add(clienteFisico);
                                contas.add(contaPoupanca);

                            // Se for pessoa juridica
                            } else if (tipoPessoa == 2) {
                                System.out.println("Informe seu cnpj: ");
                                String cnpj = input.nextLine();

                                System.out.println("Informe sua razão social: ");
                                String razaoSocial = input.nextLine();

                                Endereco endereco = new Endereco(rua, numero, cidade);
                                PessoaJuridica clienteJuridico = new PessoaJuridica(limitCred, endereco, cnpj, razaoSocial);

                                ContaPoupanca contaPoupanca = new ContaPoupanca(agencia, numeroConta, saldo, dataAbertura, clienteJuridico, taxaJuros);

                                clientes.add(clienteJuridico);
                                contas.add(contaPoupanca);
                            }
                        }
                        case 2 -> {
                            // Tipo de cliente a ser cadastrado
                            System.out.println("\n Informe: \n (1) para criar conta pessoa fisica \n (2) para criar conta pessoa juridica \n");
                            int tipoPessoa = numbers.nextInt();

                            if  (tipoPessoa != 1 && tipoPessoa != 2){
                                System.out.println("Opção inválida");
                                break;
                            }

                            // Informações referente ao endereço
                            System.out.println("Informe o numero da casa: ");
                            int numeroCasa = numbers.nextInt();

                            System.out.println("Informe o nome da sua rua: ");
                            String rua = input.nextLine();

                            System.out.println("Informe a cidade onde você mora: ");
                            String cidade = input.nextLine();

                            // Valores default
                            double saldo = 0;
                            LocalDate dataAbertura = LocalDate.now();
                            double taxaManuntencao = 0;
                            double limitCred = 0;

                            // Informações sobre a conta
                            System.out.println("Informe o número da agencia: ");
                            int agencia = numbers.nextInt();

                            System.out.println("Informe o numero da conta: ");
                            int numeroConta = numbers.nextInt();

                            // Ser for pessoa fisica
                            if (tipoPessoa == 1){
                                System.out.println("Informe seu cpf: ");
                                String cpf = input.nextLine();

                                System.out.println("Informe seu nome: ");
                                String nome = input.nextLine();

                                System.out.println("Informe sua data de nascimento: ");
                                String idade = input.nextLine();

                                String[] parts = idade.split("/");
                                LocalDate dataNascimento = LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));

                                Endereco endereco = new Endereco(rua, numeroCasa, cidade);
                                PessoaFisica clienteFisico = new PessoaFisica(limitCred, endereco, cpf, nome, dataNascimento);

                                ContaCorrente contaCorrente = new ContaCorrente(agencia, numeroConta, saldo, dataAbertura, clienteFisico, taxaManuntencao);

                                clientes.add(clienteFisico);
                                contas.add(contaCorrente);

                                // Ser for pessoa juridica
                            } else if (tipoPessoa == 2) {
                                System.out.println("Informe seu cnpj: ");
                                String cnpj = input.nextLine();

                                System.out.println("Informe sua razão social: ");
                                String razaoSocial = input.nextLine();

                                Endereco endereco = new Endereco(rua, numeroCasa, cidade);
                                PessoaJuridica clienteJuridico = new PessoaJuridica(limitCred, endereco, cnpj, razaoSocial);

                                ContaCorrente contaCorrente = new ContaCorrente(agencia, numeroConta, saldo, dataAbertura, clienteJuridico, taxaManuntencao);

                                clientes.add(clienteJuridico);
                                contas.add(contaCorrente);
                            }

                        }
                        case 3 -> {

                            contas.forEach((conta -> {
                                System.out.println(conta.getCliente());
                            }));

                        }
                    }

                    System.out.println("\n Informe: \n (1) para criar conta poupança \n (2) para criar conta corrente \n (3) para acessar conta \n (4) para sair");
                    choose = numbers.nextInt();


                        // System.out.println("\n Informe: \n (1) para depositar \n (2) para sacar \n
                        // (0) para sair ");
                        // int choose = sc.nextInt();

                        // while (choose != 0){

                        // switch (choose) {
                        // case 1:
                        // System.out.println("Informe o valor que deseja depositar na conta: ");
                        // float valor = sc.nextInt();
                        // contaA.depositar(valor);
                        // System.out.printf("\n O saldo da conta eh: R$%.2f reais \n",
                        // contaA.getSaldo());
                        // break;

                        // case 2:
                        // System.out.println("Informe o valor que deseja sacar da conta: ");
                        // valor = sc.nextFloat();

                        // if (contaA.sacar(valor)){
                        // System.out.printf("\n Saque realizado com sucesso \n");
                        // System.out.printf("\n O saldo da conta eh: R$%.2f reais \n",
                        // contaA.getSaldo());
                        // } else {
                        // System.out.printf("\n Saque não efetuado \n");
                        // }
                        // break;

                        // case 0:
                        // break;
                        // }

                        // System.out.println("\n Informe: \n (1) para depositar \n (2) para sacar \n
                        // (0) para sair: ");
                        // choose = sc.nextInt();

                        // }
                        // }

                        // System.out.println(
                        // "\n Informe: \n (1) para criar conta poupança \n (2) para criar conta
                        // corrente \n (3) para acessar conta \n (4) para sair");
                        // choose = sc.nextInt();

                        // }

                }
        }
}
