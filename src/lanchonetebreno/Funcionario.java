/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanchonetebreno;

import arquivo.Arquivo;
import java.util.Arrays;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

public class Funcionario extends Cliente {
    //atributos
    private double salario;

    //constructor
    public Funcionario(String nome, String telefone, String endereço, String cpf, String senha, Double salario) {
        super(nome, telefone, endereço, cpf, senha);
        this.salario = salario;
    }

    //getters and setters
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //metodos

    /**cadastrar funcionario
     *
     * @throws ParseException
     */
    public static void cadastrarFuncionario() throws ParseException {
        int criarFuncionario = 0;
        double salario;
        String nome, telefone, endereço, cpf, senha = null, historicoPedido = null;
        Funcionario[] vetorFuncionario = new Funcionario[15];
        vetorFuncionario = Arquivo.lerArqFuncionario();

        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja cadastrar um Funcionario? 1(sim), 2(nao)");
        criarFuncionario = input.nextInt();
        while (criarFuncionario == 1) {
            for (int i = 0; i < 15; i++) {
                System.out.println("Digite o salario do Funcionario: ");
                salario = input.nextDouble();
                System.out.println("Digite o nome do Funcionario: ");
                nome = input.next();
                System.out.println("Digite o telefone do Funcionario: ");
                telefone = input.next();
                System.out.println("Digite o endereco do Funcionario: ");
                endereço = input.next();
                System.out.println("Digite o cpf do Funcionario: ");
                cpf = input.next();
                System.out.println("Digite a senha do Funcionario: ");
                senha = input.next();

                Funcionario f1 = new Funcionario( nome, telefone, endereço, cpf, senha, salario);
                for (int j = 0; j < vetorFuncionario.length; j++) {
                    if (vetorFuncionario[j] == null) {
                        vetorFuncionario[j] = f1;
                        System.out.println("Funcionario cadastrado! " + vetorFuncionario[i]);
                        Arquivo.escreverArqFuncionario(vetorFuncionario);
                        break;
                    }
                }
                System.out.println("Deseja cadastrar um Funcionario? 1(sim), 2(nao)");
                criarFuncionario = input.nextInt();
                if (criarFuncionario == 2) {
                    break;
                }
            }
        }
    }

    /**
     * remover funcionario 
     * @throws ParseException
     */
    public static void removerFuncionario() throws ParseException {
        String search;
        int removeFuncionario;
        Funcionario[] vetorFuncionario = new Funcionario[15];
        vetorFuncionario = Arquivo.lerArqFuncionario();
        
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja remover um funcionario? 1(sim), 2(nao)");
        removeFuncionario = input.nextInt();
        while (removeFuncionario == 1) {
            System.out.println("Qual funcionario voce deseja remover? Digite o cpf dele(a) ");
            search = input.next();
            for (int i = 0; i < vetorFuncionario.length; i++) {
                Funcionario f2 = vetorFuncionario[i];
                if (vetorFuncionario[i] != null) {
                    if (vetorFuncionario[i].getCpf() == null ? search == null : vetorFuncionario[i].getCpf().equals(search)) {
                        vetorFuncionario[i] = null;
                        System.out.println("Funcionario removido");
                        Arquivo.escreverArqFuncionario(vetorFuncionario);
                        removeFuncionario = 2;
                    }
                }
            }
            removeFuncionario = 2;
        }
        System.out.println(Arrays.toString(vetorFuncionario));
    }

    /**
     * alterar atributos de funcionario
     * @throws ParseException
     */
    public static void alterarDadosFuncionario() throws ParseException {
        double salario;
        String search, cpf, nome, endereço, telefone, senha;
        int funcionario, set = 0;
        Funcionario[] vetorFuncionario = new Funcionario[15];
        vetorFuncionario = Arquivo.lerArqFuncionario();
        
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja alterar dados de um Funcionario? 1(sim), 2(nao)");
        funcionario = input.nextInt();
        while (funcionario == 1) {
            System.out.println("Qual funcionario voce deseja alterar os dados? Digite o cpf dele(a) ");
            search = input.next();
            for (Funcionario f2 : vetorFuncionario) {
                if (f2 != null) {
                    if (f2.getCpf().equals(search)) {
                        while (set != 7) {
                            System.out.println("Vai alterar o que? nome(1), telefone(2), endereço(3), cpf(4), salario(5), senha(6) ou CANCELAR(7)");
                            set = input.nextInt();
                            if (set == 1) {
                                System.out.println("Nome: ");
                                nome = input.next();
                                f2.setNome(nome);
                            }
                            if (set == 2) {
                                System.out.println("Telefone: ");
                                telefone = input.next();
                                f2.setTelefone(telefone);
                            }
                            if (set == 3) {
                                System.out.println("Endereço: ");
                                endereço = input.next();
                                f2.setEndereço(endereço);
                            }
                            if (set == 4) {
                                System.out.println("Cpf: ");
                                cpf = input.next();
                                f2.setCpf(cpf);
                            }
                            if (set == 5) {
                                System.out.println("salario: ");
                                salario = input.nextDouble();
                                f2.setSalario(salario);
                            }
                            if (set == 6) {
                                System.out.println("senha: ");
                                senha = input.next();
                                f2.setSenha(senha);
                            }
                            if (set == 7) {
                                funcionario = 2;
                                break;
                            }
                        }
                    }
                }
            }
            Arquivo.escreverArqFuncionario(vetorFuncionario);
            break;
        }
    }

    @Override
    public String toString() {
        return "Funcionario{" + ",nome=" + super.getNome() + ", telefone=" + super.getTelefone()
                + ", endereco=" + super.getEndereço() + "" + ", cpf=" + super.getCpf()
                + ", historicoPedido=" + super.getHistoricoPedido() + ", senha=" + super.getSenha() + '}';
    }

}
