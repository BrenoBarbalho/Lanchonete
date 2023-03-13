/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanchonetebreno;

import arquivo.Arquivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 *
 * @author breno
 */
public class Cliente implements Comparator<Cliente>{
    //atributos
    private String nome;
    private String telefone;
    private String endereço;
    private String cpf;
    ArrayList<Pedido> historicoPedido = new ArrayList<>();
    private String senha;
    private static int inst1;// contador estático da quantidades de clientes
    protected int inst2;// contador estático e protected da quantidades de clientes
    private static int count = 0;// questao 11 

    //constructor   
    public Cliente(String nome, String telefone, String endereço, String cpf, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereço = endereço;
        this.cpf = cpf;
        this.senha = senha;
        inst1 += inst1;
        inst2 += inst2;
        count++;
    }

    //getters and setters    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Pedido> getHistoricoPedido() {
        return historicoPedido;
    }

    public void setHistoricoPedido(ArrayList<Pedido> historicoPedido) {
        this.historicoPedido = historicoPedido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
    public int getInst1() {
        return inst1;//retorna o contador estático da quantidades de clientes
    }

    public void setInst1(int inst1) {
        this.inst1 = inst1;
    }
    
    public int getInst2() {
        return inst2;//retorna o contador estático e protected da quantidades de clientes
    }
    
    //metodos

    /**
     * cadstrar cliente na lanchoente
     * @throws ParseException
     * @throws IOException
     */
    
    public static void cadastraCliente() throws ParseException, IOException {
        int criaCliente = 0;
        String nome, telefone, endereço, cpf, historicoPedido = null, senha = null;
        List<Cliente> listaCliente = new ArrayList<>();
        listaCliente = Arquivo.lerArqCliente();

        Scanner input = new Scanner(System.in);
        System.out.println("Deseja cadastrar um cliente? 1(sim), 2(nao)");
        criaCliente = input.nextInt();
        while (criaCliente == 1) {
            System.out.println("Digite o nome do cliente: ");
            nome = input.next();
            System.out.println("Digite o telefone do cliente: ");
            telefone = input.next();
            System.out.println("Digite o endereço do cliente: ");
            endereço = input.next();
            System.out.println("Digite o cpf do cliente: ");
            cpf = input.next();

            Cliente c1 = new Cliente(nome, telefone, endereço, cpf, senha);
            listaCliente.add(c1);
            System.out.println("Cliente cadastrado! " + listaCliente);
            Arquivo.escreverArqCliente(listaCliente);

            System.out.println("Deseja continuar? 1(sim) 2(nao) ");
            criaCliente = input.nextInt();
            //Certificando que o Usuario vai digitar 1 ou 2.
            if ((criaCliente != 1) && (criaCliente != 2)) {
                System.out.println("Opcao invalida ");
                System.out.println("Deseja continuar? 1(sim) 2(nao) ");
                criaCliente = input.nextInt();
            }
        }
    }
    
    /**
     * alterar dados do cliente cadastrado
     * @throws ParseException
     * @throws IOException
     */
    public static void alterarDadosCliente() throws ParseException, IOException {
        String search, cpf, nome, endereço, telefone;
        int criaCliente, set = 0, cancelar;
        List<Cliente> listaCliente = new ArrayList<>();
        listaCliente = Arquivo.lerArqCliente();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja alterar um cliente? 1(sim), 2(nao)");
        criaCliente = input.nextInt();
        while (criaCliente == 1) {
            System.out.println("Qual cliente voce deseja alterar? Digite o cpf dele(a) ");
            search = input.next();
            for (int i = 0; i < listaCliente.size(); i++) {
                Cliente c2 = listaCliente.get(i);
                if (c2.getCpf().equals(search)) {
                    while (set != 5) {
                        System.out.println("Vai alterar o que? nome(1), telefone(2), endereço(3), cpf(4) CANCELAR(5)");
                        set = input.nextInt();
                        if (set == 1) {
                            System.out.println("Nome: ");
                            nome = input.next();
                            c2.setNome(nome);
                        }
                        if (set == 2) {
                            System.out.println("Telefone: ");
                            telefone = input.next();
                            c2.setTelefone(telefone);
                        }
                        if (set == 3) {
                            System.out.println("Endereço: ");
                            endereço = input.next();
                            c2.setEndereço(endereço);
                        }
                        if (set == 4) {
                            System.out.println("Cpf: ");
                            cpf = input.next();
                            c2.setCpf(cpf);
                        }
                        if (set == 5) {
                            break;
                        }
                    }
                }
            }
            Arquivo.escreverArqCliente(listaCliente);
            break;
        }
    }

    /**
     * remove cliente cadastrado
     * @throws ParseException
     * @throws IOException
     */
    public static void removerCliente() throws ParseException, IOException {
        String search;
        int criaCliente;
        List<Cliente> listaCliente = new ArrayList<>();
        listaCliente = Arquivo.lerArqCliente();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja remover um cliente? 1(sim), 2(nao)");
        criaCliente = input.nextInt();
        while (criaCliente == 1) {
            System.out.println("Qual cliente voce deseja remover? Digite o cpf dele(a) ");
            search = input.next();
            for (int i = 0; i < listaCliente.size(); i++) {
                Cliente c2 = listaCliente.get(i);
                if (c2.getCpf().equals(search)) {
                    System.out.println(c2.getCpf());
                    listaCliente.remove(i);
                    System.out.println("Cliente removido");
                    criaCliente = 2;
                }
            }
            Arquivo.escreverArqCliente(listaCliente);
            criaCliente = 2;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", telefone=" + telefone + 
                ", endereco=" + endereço + ", cpf=" + cpf + ", historicoPedido=" + historicoPedido + ", senha=" + senha +'}';
    }  
    
    /**
     * compara o nome de cliente, seé diferente ou igual
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Cliente o1, Cliente o2) {
        if(o1.getNome() == null ? (o2.getNome()) == null : o1.getNome().equals(o2.getNome())){
            System.out.println("Cpf iguais");
            return 0;
        }
        else{
            System.out.println("Cpf diferentes");
            return 1;
        }
    }
    
}
