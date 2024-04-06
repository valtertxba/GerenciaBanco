/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;
import java.util.Scanner;

/**
 *
 * @author Valter
 */
public class GerenciaBanco {
    static class Cliente {
        private String nome;
        private String sobrenome;
        private String cpf;
        private double saldo;

        public Cliente(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = 0.0;
        }

        public void consultarSaldo() {
            System.out.println("Saldo Atual: R$" + saldo);
            System.out.println();
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque de R$ " + valor + " realizado.");
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Gerenciador Bancario!");

        System.out.println("Informe seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Informe o Sobrenome:");
        String sobrenome = scanner.nextLine();
        System.out.println("Informe o CPF:");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, cpf);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("1- Consultar saldo");
            System.out.println("2- Fazer deposito");
            System.out.println("3- Fazer saque");
            System.out.println("4- Encerrar aplicao\n");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                case 2:
                    System.out.println("Informe o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("Informe o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(valorSaque);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Obrigado por usar o Gerenciador Bancario. Ate mais!");
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
