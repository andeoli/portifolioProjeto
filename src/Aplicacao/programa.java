package Aplicacao; // Desenvolvido por Anderson Oliveira Souza

import java.util.Locale;
import java.util.Scanner;
import Classes.Cliente;
import Classes.ContaBancaria;
import Classes.PessoaFisica;
import Classes.PessoaJuridica;

public class programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bem-vindo ao sistema bancário!");


		System.out.println("Você é Pessoa Física ou Jurídica? (1 para Física, 2 para Jurídica)");
        int tipoCliente = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Digite o nome do cliente:");
        String nome = sc.nextLine();

        System.out.println("Digite o número da conta:");
        String numeroConta = sc.nextLine();

        Cliente cliente;
        if (tipoCliente == 1) {
            System.out.println("Digite o CPF:");
            String cpf = sc.nextLine();
            cliente = new PessoaFisica(nome, cpf);
        } else {
            System.out.println("Digite o CNPJ:");
            String cnpj = sc.nextLine();
            cliente = new PessoaJuridica(nome, cnpj);
        }
      
        
        ContaBancaria conta = new ContaBancaria(cliente, numeroConta);

        while (true) {
            System.out.println("\nEscolha uma operação: 1-Depositar, 2-Sacar, 3-Transferir, 4-Consultar Saldo, 5-Encerrar");
            int operacao = sc.nextInt();

            switch (operacao) {
                case 1:
                    System.out.println("Digite o valor para depósito:");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor para saque:");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Digite o valor para transferência:");
                    double valorTransferencia = sc.nextDouble();
                    sc.nextLine(); 
                    
                    System.out.println("Digite o nome do destinatário:");
                    String nomeDestinatario = sc.nextLine();
                    
                    System.out.println("Digite o número da conta do destinatário:");
                    String numeroContaDestinatario = sc.nextLine();
                    
                    Cliente destinatario = tipoCliente == 1 ? new PessoaFisica(nomeDestinatario, numeroContaDestinatario) : new PessoaJuridica(nomeDestinatario, numeroContaDestinatario);
                    ContaBancaria contaDestino = new ContaBancaria(destinatario, numeroContaDestinatario);
                    conta.transferir(contaDestino, valorTransferencia);
                    break;
                case 4:
                    System.out.println("Saldo atual: " + String.format("%.2f", conta.getSaldo()));
                    break;
                case 5:
                    System.out.println("Encerrando o sistema. Obrigado por usar nosso banco!");
                    sc.close();
                    return;
                default:
                    System.out.println("Operação inválida. Tente novamente.");
            }
        }
    }
}

