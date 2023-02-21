/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cappi.gerenciabanco;
import java.util.Scanner;
/**
 *
 * @author Cappi
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Console.Verde("Bem-vindo ao gerenciamento bancário!");
        
        // Criação do objeto que guarda informações do usuário
        Usuario usuario = new Usuario();

        Console.AzulClaro("Informe seu nome: ",false);
        String nome = scanner.nextLine();
        usuario.setNome(nome);

        Console.AzulClaro("Informe seu sobrenome: ",false);
        String sobrenome = scanner.nextLine();
        usuario.setSobrenome(sobrenome);

        Console.AzulClaro("Informe seu CPF: ", false);
        String cpf = scanner.nextLine();
        usuario.setCpf(cpf);

        // Loop principal que permite que o usuário realize várias operações
        boolean continuarExecucao = true;
        do {
            exibirMenu();
            
            Console.AzulClaro("Qual opção deseja? ",false);
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    Console.Amarelo("Informe o valor do depósito: ", false);
                    double valorDeposito = scanner.nextDouble();
                    usuario.depositar(valorDeposito);
                    break;
                case 2:
                    Console.Amarelo("Informe o valor da retirada: ", false);
                    double valorRetirada = scanner.nextDouble();
                    usuario.retirar(valorRetirada);
                    break;
                case 3:
                    String mensagem = String.format("Seu saldo atual é R$ %.2f", usuario.getSaldo());
                    Console.Verde(mensagem);
                    break;
                    case 4:
                    exibirInformacoes(usuario);
                    break;
                case 5:
                    continuarExecucao = false;
                    break;
                default:
                    Console.Vermelho("Opção inválida, tente novamente.");
                    break;
            }
        } while (continuarExecucao);

         Console.Verde("Obrigado por usar o gerenciamento bancário, até mais!");
    }

    private static void exibirMenu() {
        System.out.println(); // Linha em branco
        System.out.println("===================================");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Depositar");
        System.out.println("2 - Retirar");
        System.out.println("3 - Consultar saldo");
        System.out.println("4 - Exibir Informações");
        Console.Vermelho("5", false);
        Console.Amarelo(" - Sair");
        System.out.println("===================================");
        System.out.println(); // Linha em branco
    }
    
    private static void exibirInformacoes(Usuario usuario) {
        System.out.println(); // Linha em branco
        System.out.println("===================================");
        System.out.printf("Nome Completo: %s %s\n", usuario.getNome(), usuario.getSobrenome());
        System.out.printf("CPF: %s\n", usuario.getCpf());
        System.out.printf("Saldo atual: R$ %.2f\n", usuario.getSaldo());
        System.out.println("===================================");
        System.out.println(); // Linha em branco
    }
    
}

class Usuario {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    // Construtor que inicializa o saldo em zero
    public Usuario() {
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            Console.Verde("Depósito efetuado com sucesso.");
        } else {
            Console.Vermelho("Valor inválido para depósito.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                Console.Verde("Retirada efetuada com sucesso.");
            } else {
                Console.Vermelho("Saldo insuficiente.");
            }
        } else {
            Console.Vermelho("Valor inválido para retirada.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

class Console {
    public static final String VERMELHO = "\033[31m";
    public static final String VERDE = "\033[32m";
    public static final String AMARELO = "\033[33m";
    public static final String BRANCO = "\033[37m";
    public static final String FUNDO_PRETO = "\033[40m";
    public static final String FUNDO_VERDE_TEXTO_PRETO = "\033[42;30m";
    public static final String RESETAR = "\033[0m";
    public static final String AZUL_CLARO = "\033[94m";
    
    //Para Exibir no Console sem uma linha em Branco passar uma Boleana False, Default True
    public static void AzulClaro(String texto, boolean... imprimirComPrintLn) {
        if (imprimirComPrintLn.length == 0 || imprimirComPrintLn[0]) {
            System.out.println(AZUL_CLARO + texto + RESETAR);
        } else {
            System.out.print(AZUL_CLARO + texto + RESETAR);
        }
    }
    
    //Para Exibir no Console sem uma linha em Branco passar uma Boleana False, Default True
    public static void Verde(String texto, boolean... imprimirComPrintLn) {
        if (imprimirComPrintLn.length == 0 || imprimirComPrintLn[0]) {
            System.out.println(VERDE + texto + RESETAR);
        } else {
            System.out.print(VERDE + texto + RESETAR);
        }
    }
    
    //Para Exibir no Console sem uma linha em Branco passar uma Boleana False, Default True
    public static void Vermelho(String texto, boolean... imprimirComPrintLn) {
        if (imprimirComPrintLn.length == 0 || imprimirComPrintLn[0]) {
            System.out.println(VERMELHO + texto + RESETAR);
        } else {
            System.out.print(VERMELHO + texto + RESETAR);
        }
    }
    
    //Para Exibir no Console sem uma linha em Branco passar uma Boleana False, Default True
    public static void Amarelo(String texto, boolean... imprimirComPrintLn) {
        if (imprimirComPrintLn.length == 0 || imprimirComPrintLn[0]) {
            System.out.println(AMARELO + texto + RESETAR);
        } else {
            System.out.print(AMARELO + texto + RESETAR);
        }
    }

}
