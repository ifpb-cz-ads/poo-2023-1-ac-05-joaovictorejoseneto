package view;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Endereco;
import model.PessoaFisica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                List<Conta> contas = new ArrayList<>();
                List<Cliente> clientes = new ArrayList<>();

                System.out.println(
                                "\n Informe: \n (1) para criar conta poupança \n (2) para criar conta corrente \n (3) para acessar conta \n (4) para sair");
                int choose = sc.nextInt();

                while (choose != 4) {

                        switch (choose) {
                                case 1:
                                        // Cadastro do usuário
                                        System.out.println("Informe o nome da sua rua: ");
                                        String rua = sc.nextLine();

                                        System.out.println("Informe o numero da casa: ");
                                        int numero = sc.nextInt();

                                        System.out.println("Informe a cidade onde voce mora: ");
                                        String cidade = sc.nextLine();

                                        System.out.println("Informe seu limite de credito: ");
                                        double limite = sc.nextDouble();

                                        System.out.println("Informe seu limite de credito: ");
                                        String cpf = sc.nextLine();

                                        System.out.println("Informe seu nome: ");
                                        String nome = sc.nextLine();

                                        System.out.println("Informe sua data de nascimento: ");
                                        String idade = sc.nextLine();

                                        String[] parts = idade.split("/");
                                        LocalDate dataNascimento = LocalDate.of(Integer.parseInt(parts[2]),
                                                        Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));

                                        Endereco endereco = new Endereco(rua, numero, cidade);
                                        Cliente novoCliente = new PessoaFisica(limite, endereco, cpf, nome,
                                                        dataNascimento);

                                        /// Cadastro da conta

                                        double saldo = 0;
                                        LocalDate dataAbertura = LocalDate.now();
                                        double taxaJuros = 0;

                                        System.out.println("Informe o número da agencia: ");
                                        int agencia = sc.nextInt();

                                        System.out.println("Informe o numero da conta: ");
                                        int numeroConta = sc.nextInt();

                                        ContaPoupanca contaPoupanca = new ContaPoupanca(agencia, numeroConta, saldo,
                                                        dataAbertura, novoCliente, taxaJuros);

                                        clientes.add(novoCliente);
                                        contas.add(contaPoupanca);                
                                        break;

                                case 2:
                                        // Cadastro do usuário
                                        System.out.println("Informe o nome da sua rua: ");
                                        String ruaCliente = sc.nextLine();

                                        System.out.println("Informe o numero da casa: ");
                                        int numeroCliente = sc.nextInt();

                                        System.out.println("Informe a cidade onde voce mora: ");
                                        String cidadeCliente = sc.nextLine();

                                        System.out.println("Informe seu limite de credito: ");
                                        double limiteCliente = sc.nextDouble();

                                        System.out.println("Informe seu limite de credito: ");
                                        String cpfCliente = sc.nextLine();

                                        System.out.println("Informe seu nome: ");
                                        String nomeCliente = sc.nextLine();

                                        System.out.println("Informe sua data de nascimento: ");
                                        String idadeCliente = sc.nextLine();

                                        String[] partes = idadeCliente.split("/");
                                        LocalDate dataNascimentoCliente = LocalDate.of(Integer.parseInt(partes[2]),
                                                        Integer.parseInt(partes[1]), Integer.parseInt(partes[0]));

                                        Endereco novoEndereco1 = new Endereco(ruaCliente, numeroCliente, cidadeCliente);
                                        Cliente novoCliente1 = new PessoaFisica(limiteCliente, novoEndereco1,
                                                        cpfCliente, nomeCliente,
                                                        dataNascimentoCliente);

                                        /// Cadastro da conta

                                        double saldoConta = 0;
                                        LocalDate dataAberturaConta = LocalDate.now();
                                        double taxaJurosConta = 0;

                                        System.out.println("Informe o número da agencia: ");
                                        int agenciaConta = sc.nextInt();

                                        System.out.println("Informe o numero da conta: ");
                                        int numeroConta1 = sc.nextInt();

                                        ContaCorrente contaCorrente = new ContaCorrente(agenciaConta, numeroConta1,
                                                        saldoConta, dataAberturaConta, novoCliente1, numeroConta1);

                                        clientes.add(novoCliente1);
                                        contas.add(contaCorrente);

                                        break;

                                
                                case 3:

                                        while (true) {
                                                System.out.println("Informe o numero da conta: ");
                                                int ruaCliente = sc.nextInt();

                                                contas.forEach( (Conta conta) -> {
                                                        if (conta.)
                                                });
                                        }

                        }


                                        // System.out.println("\n Informe: \n (1) para depositar \n (2) para sacar \n (0) para sair ");
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
                                        //         }

                                        //         System.out.println(
                                        //                         "\n Informe: \n (1) para criar conta poupança \n (2) para criar conta corrente \n (3) para acessar conta \n (4) para sair");
                                        //         choose = sc.nextInt();

                                        // }

                
                                        }
                                }
}
