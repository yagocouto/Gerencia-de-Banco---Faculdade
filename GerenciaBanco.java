/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;
import java.util.Scanner;

/**
 *
 * @author yago1
 */
public class GerenciaBanco {
    private String nomeCompleto;
    private long cpf;
    private double saldo = 0;

    // Construtor
    public GerenciaBanco(String nomeCompleto, long cpf) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.printf("Depósito de R$%.2f realizado com sucesso!\n", valor);
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.printf("Saque de R$%.2f efetuado com sucesso!\n", valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$%.2f\n", saldo);
    }

    public void exibirDados() {
        System.out.println("\n=== Dados do Cliente ===");
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("CPF: " + cpf);
        System.out.printf("Saldo: R$%.2f\n", saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um usuário
        System.out.print("Digite seu nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF (apenas numeros): ");
        long cpf = scanner.nextLong();

        GerenciaBanco usuario = new GerenciaBanco(nome, cpf);

        int opcao;
        do {
            System.out.println("\n=== Menu Bancario ===");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Exibir Dados da Conta");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    usuario.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor do deposito: ");
                    double deposito = scanner.nextDouble();
                    usuario.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double saque = scanner.nextDouble();
                    usuario.sacar(saque);
                    break;
                case 4:
                    usuario.exibirDados();
                    break;
                case 5:
                    System.out.println("\nObrigado por usar nosso banco! Até a próxima.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}