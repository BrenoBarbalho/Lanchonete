/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanchonetebreno;

import arquivo.Arquivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 * atributos e metodos de adm
 * @author breno
 */
public class Adm extends Funcionario {

    //constructors
    public Adm(String nome, String telefone, String endereço, String cpf, String senha, Double salario) {
        super(nome, telefone, endereço, cpf, senha, salario);
    }

    //metodos

    /**
     * cadastrar adm
     * @throws ParseException
     * @throws IOException
     */
    public static void cadastrarAdm() throws ParseException, IOException {
        int criarAdm = 0;
        double salario;
        String nome, telefone, endereço, cpf, senha = null, historicoPedido = null;
        List<Adm> listaAdm = new ArrayList<>();
        listaAdm = Arquivo.lerArqAdm();

        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja cadastrar um Adm? 1(sim), 2(nao)");
        criarAdm = input.nextInt();
        while (criarAdm == 1) {
            System.out.println("Digite o salario do Adm: ");
            salario = input.nextDouble();
            System.out.println("Digite o nome do Adm: ");
            nome = input.next();
            System.out.println("Digite o telefone do Adm: ");
            telefone = input.next();
            System.out.println("Digite o endereco do Adm: ");
            endereço = input.next();
            System.out.println("Digite o cpf do Adm: ");
            cpf = input.next();
            System.out.println("Digite a senha do Adm: ");
            senha = input.next();

            Adm a1 = new Adm(nome, telefone, endereço, cpf, senha, salario);
            listaAdm.add(a1);
            System.out.println(listaAdm);
            Arquivo.escreverArqAdm(listaAdm);

            System.out.println("\nDeseja cadastrar um Adm? 1(sim), 2(nao)");
            criarAdm = input.nextInt();
            if (criarAdm == 2) {
                break;
            }
        }
    }

    /**
     * alterar dados de adm
     * @throws ParseException
     * @throws IOException
     */
    public static void alterarDadosAdm() throws ParseException, IOException {
        double salario;
        String search, cpf, nome, endereço, telefone, senha;
        int Adm, set = 0;
        List<Adm> listaAdm = new ArrayList<>();
        listaAdm = Arquivo.lerArqAdm();
        
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja alterar dados de um Adm? 1(sim), 2(nao)");
        Adm = input.nextInt();
        while (Adm == 1) {
            System.out.println("Qual adm voce deseja alterar os dados? Digite o cpf dele(a) ");
            search = input.next();
            for (int i = 0; i < listaAdm.size(); i++) {
                Adm a2 = listaAdm.get(i);
                if (a2.getCpf().equals(search)) {
                    while (set != 7) {
                        System.out.println("Vai alterar o que? nome(1), telefone(2), endereço(3), cpf(4), salario(5), senha(6) e CANCELAR(7)");
                        set = input.nextInt();
                        if (set == 1) {
                            System.out.println("Nome: ");
                            nome = input.next();
                            a2.setNome(nome);
                        }
                        if (set == 2) {
                            System.out.println("Telefone: ");
                            telefone = input.next();
                            a2.setTelefone(telefone);
                        }
                        if (set == 3) {
                            System.out.println("Endereço: ");
                            endereço = input.next();
                            a2.setEndereço(endereço);
                        }
                        if (set == 4) {
                            System.out.println("Cpf: ");
                            cpf = input.next();
                            a2.setCpf(cpf);
                        }
                        if (set == 5) {
                            System.out.println("salario: ");
                            salario = input.nextDouble();
                            a2.setSalario(salario);
                        }
                        if (set == 6) {
                            System.out.println("senha");
                            senha = input.next();
                            a2.setSenha(senha);
                        }
                        if (set == 7) {
                            break;
                        }
                    }
                }
            }
            Arquivo.escreverArqAdm(listaAdm);
            break;
        }
    }

    /**
     * remover adm
     * @throws ParseException
     * @throws IOException
     */
    public static void removerAdm() throws ParseException, IOException {
        String search;
        int removeAdm;
        List<Adm> listaAdm = new ArrayList<>();
        listaAdm = Arquivo.lerArqAdm();
        
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja remover um Adm? 1(sim), 2(nao)");
        removeAdm = input.nextInt();
        listaAdm = (ArrayList<Adm>) Arquivo.lerArqAdm();
        while (removeAdm == 1) {
            System.out.println("Qual adm voce deseja remover? Digite o cpf dele(a) ");
            search = input.next();
            for (int i = 0; i < listaAdm.size(); i++) {
                Adm a2 = listaAdm.get(i);
                if (a2.getCpf().equals(search)) {
                    listaAdm.remove(i);
                    System.out.println("Adm removido");
                    removeAdm = 2;
                    Arquivo.escreverArqAdm(listaAdm);
                }
            }
            removeAdm = 2;
        }
    }

    @Override
    public String toString() {
        return "Adm{" + "nome=" + super.getNome() + ", telefone=" + super.getTelefone() + ", endereco=" + super.getEndereço() + ""
                + ", cpf=" + super.getCpf() + ", historicoPedido=" + super.getHistoricoPedido() + ", senha=" + super.getSenha() + '}';
    }
}
