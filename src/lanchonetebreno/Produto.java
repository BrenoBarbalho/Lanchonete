/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanchonetebreno;

import arquivo.Arquivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 * atributos de produto
 * @author breno
 */
public class Produto {

    //atributos
    private int idProduto;
    private String descricao;
    private double valor;

    //constructor
    public Produto() {
    }

    public Produto(int idProduto, String descrição, double valor) {
        this.idProduto = idProduto;
        this.descricao = descrição;
        this.valor = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    //metodos
    public static void cadastrarProduto() throws ParseException, IOException {
        int criaProduto, idProduto;
        String descricao;
        double valor;
        ArrayList<Produto> listaProduto = new ArrayList<>();
        listaProduto = (ArrayList<Produto>) Arquivo.lerProdutos();

        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja cadastrar um Produto? 1(sim), 2(nao)");
        criaProduto = input.nextInt();
        while (criaProduto == 1) {
            System.out.println("Digite o id do produto: ");
            idProduto = input.nextInt();
            System.out.println("Digite o nome e descrição do produto: ");
            descricao = input.next();
            System.out.println("Digite o valor do produto: ");
            valor = input.nextDouble();

            Produto p1 = new Produto(idProduto, descricao, valor);
            listaProduto.add(p1);
            System.out.println("Produto cadastrado! " + listaProduto);
            Arquivo.escreverProduto(listaProduto);

            System.out.println("Deseja continuar? 1(sim) 2(nao) ");
            criaProduto = input.nextInt();
            //Certificando que o Usuario vai digitar 1 ou 2.
            if ((criaProduto != 1) && (criaProduto != 2)) {
                System.out.println("Opcao invalida ");
                System.out.println("Deseja continuar? 1(sim) 2(nao) ");
                criaProduto = input.nextInt();
            }
        }
    }

    public static void alterarDadosProduto() throws ParseException, IOException {
        double valor;
        String descricao;
        int search, produto, set = 0, idProduto;
        ArrayList<Produto> listaProduto = new ArrayList<>();
        listaProduto = (ArrayList<Produto>) Arquivo.lerProdutos();
        
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja alterar dados de um produto? 1(sim), 2(nao)");
        produto = input.nextInt();
        while (produto == 1) {
            System.out.println("Qual produto voce deseja alterar os dados? Digite o id dele(a) ");
            search = input.nextInt();
            for (int i = 0; i < listaProduto.size(); i++) {
                Produto p2 = listaProduto.get(i);
                if (p2.getIdProduto() == search) {
                    while (set != 4) {
                        System.out.println("Vai alterar o que? idProduto(1), descricao(2), valor(3) ou CANCELAR(4)");
                        set = input.nextInt();
                        if (set == 1) {
                            System.out.println("IdProduto: ");
                            idProduto = input.nextInt();
                            p2.setIdProduto(idProduto);
                        }
                        if (set == 2) {
                            System.out.println("Descricao: ");
                            descricao = input.next();
                            p2.setDescricao(descricao);
                        }
                        if (set == 3) {
                            System.out.println("valor: ");
                            valor = input.nextDouble();
                            p2.setValor(valor);
                        }
                        if (set == 4) {
                            produto += 1;
                            break;
                        }
                    }
                }
            }
            Arquivo.escreverProduto(listaProduto);
            break;
        }
    }

    public static void removerProduto() throws ParseException, IOException {
        int removeProduto, search;
        Scanner input = new Scanner(System.in);
        ArrayList<Produto> listaProduto = new ArrayList<>();
        listaProduto = (ArrayList<Produto>) Arquivo.lerProdutos();
        
        System.out.println("\nDeseja remover um produto? 1(sim), 2(nao)");
        removeProduto = input.nextInt();
        while (removeProduto == 1) {
            System.out.println("Qual produto voce deseja remover? Digite o id dele(a) ");
            search = input.nextInt();
            for (int i = 0; i < listaProduto.size(); i++) {
                Produto p2 = listaProduto.get(i);
                if (p2.getIdProduto() == search) {
                    listaProduto.remove(i);
                    System.out.println("Produto removido");
                    removeProduto = 2;
                }
            }
            Arquivo.escreverProduto(listaProduto);
            removeProduto = 2;
        }
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", descricao=" + descricao + ", valor=" + valor + '}';
    }

}
