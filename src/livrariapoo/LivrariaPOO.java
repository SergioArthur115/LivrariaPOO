/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livrariapoo;

import controller.CCliente;
import controller.CEditora;
import controller.CLivro;
import controller.CVendaLivro;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Cliente;
import util.Validadores;

/**
 *
 * @author 182120042
 */
public class LivrariaPOO {

    public static CCliente cadCliente = new CCliente();
    public static CEditora cadEditora = new CEditora();
    public static CLivro cadLivro = new CLivro();
    public static CVendaLivro cadVendaLivro = new CVendaLivro();
    public static Scanner ler = new Scanner(System.in);

    /*
    public static int lerNum() {
        Scanner ler = new Scanner(System.in);
        try {
            return ler.nextInt();
        } catch (Exception e) {
            System.out.println("Tente novamente!");
            lerNum();
        }
        return 0;
    }*/
    public static int leiaNumGPT() {
        int num = 99;
        boolean leu = false;
        Scanner lerNum = new Scanner(System.in);
        while (!leu) {
            try {
                num = lerNum.nextInt();
                leu = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, tente novamente!");
                ler.nextLine();
            }
        }
        return num;
    }

    public static void menuP() {
        System.out.println("|Livraria|");
        System.out.println("1 - Gerenciar Clientes");
        System.out.println("2 - Gerenciar Editoras");
        System.out.println("3 - Gerenciar Livros");
        System.out.println("4 - Venda Livro");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void subMenu(int op) {
        String tipoCad = null;
        switch (op) {
            case 1:
                tipoCad = "Cliente";
                break;
            case 2:
                tipoCad = "Editora";
                break;
            case 3:
                tipoCad = "Livro";
                break;
        }
        System.out.println("| Gerenciar " + tipoCad + " |");
        System.out.println("1 - Cadastrar " + tipoCad);
        System.out.println("2 - Editar " + tipoCad);
        System.out.println("3 - Listar " + tipoCad + "s");
        System.out.println("4 - Deletar " + tipoCad);
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarCliente() {
        int idCliente;
        String nomeCliente;
        String cpf;
        String cnpj = null;
        String endereco;
        String telefone;

        System.out.println("|Cadastro de Cliente|");
        System.out.print("Informe o CPF:");
        boolean cpfis;
        int opCPF;
        do {
            cpf = ler.nextLine();
            cpfis = Validadores.isCPF(cpf);
            if (!cpfis) {
                System.out.println("CPF Inválido" + "\nDeseja tentar novamente? 1- Sim | 2 - Não");
                opCPF = leiaNumGPT();

                if (opCPF == 1) {
                    System.out.print("Informe o CPF:");
                } else if (opCPF == 2) {
                    System.out.println("Cadastro cancelado pelo usuário");
                    break;
                }
            }
        } while (!Validadores.isCPF(cpf));
        if (cadCliente.getClienteCPF(cpf) != null) {
            System.out.println("Cliente já cadastrado!");
        } else {
            System.out.println("Informe o nome:");
            nomeCliente = ler.nextLine();
            System.out.println("Informe o telefone:");
            telefone = ler.nextLine();
            System.out.println("Informe o endereço:");
            endereco = ler.nextLine();
            idCliente = cadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            cadCliente.addCliente(cli);
            System.out.println("Cliente cadastrado com sucesso!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cadCliente.mockClientes();
        cadEditora.mockEditoras();
        cadLivro.mockLivros();
        cadVendaLivro.mockVendaLivros();

        int opM;
        do {
            menuP();
            opM = leiaNumGPT();
            switch (opM) {
                case 1:
                case 2:
                case 3:
                    int opSM;
                    do {
                        subMenu(opM);
                        opSM = leiaNumGPT();
                        switch (opSM) {
                            case 1:
                                System.out.println("|Cadastrar|");
                                cadastrarCliente();
                                break;
                            case 2:
                                System.out.println("|Editar|");
                                break;
                            case 3:
                                System.out.println("|Listar|");
                                System.out.println(cadCliente.getClientes().toString());
                                break;
                            case 4:
                                System.out.println("|Deletar|");
                            case 0:
                                System.out.println("|Menu Principal|");
                                break;
                            default:
                                System.out.println("ERROR 404!!!");
                                break;
                        }

                    } while (opSM != 0);
                    break;
                case 4:
                    System.out.println("|Venda Livro|");
                    break;
                default:
                    System.out.println("Entrada inválida, tente novamente!");
                    break;
            }
        } while (opM != 0);

    }

}
