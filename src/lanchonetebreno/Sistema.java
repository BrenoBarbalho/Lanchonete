/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lanchonetebreno;

import arquivo.Arquivo;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.json.simple.parser.ParseException;

/**
 *
 * @author breno
 */
public class Sistema {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {

        Login.logar();

    }

    /**
     * pega a quantidade instancias da classe Cliente
     *
     * @return
     */
    public static int getNumeroDeClientes() {
        return 0;//Cliente.count;
    }

    /**
     * realizar pedido do cliente
     *
     * @throws ParseException
     * @throws IOException
     */
    public static void pedir() throws ParseException, IOException {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        ArrayList<Pedido> listaPedido = new ArrayList<>();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        int criarPedido = 0, idPedido = 0, idProduto, escolha;
        double totalPedido = 0;
        String data = null, horarioPedido = null, status = "EM ANDAMENTO", valorTotal = null, idAdicionais = null, valor = null, cpf = null;
        String nome = null, telefone = null, endereço = null, historicoPedido = null, senha = null;
        Scanner input = new Scanner(System.in);
        listaPedido = (ArrayList<Pedido>) Arquivo.lerArqPedido();

        System.out.println("Deseja pedir? 1(sim), 2(nao)");
        criarPedido = input.nextInt();
        while (criarPedido == 1) {
            Random gerador = new Random(); //numero randomico
            Date now = new Date(); //data no momento
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm:ss");
            String dataFormat = dataFormatada.format(now);
            String horaFormat = horaFormatada.format(now);
            Produto prodLanche = new Produto();
            Produto prodBebida = new Produto();
            idPedido = gerador.nextInt();//Gera um Id produto.
            data = dataFormat;
            horarioPedido = horaFormat;
            ArrayList<Produto> listaProdutos = new ArrayList<>();
            listaProdutos = (ArrayList<Produto>) Arquivo.lerProdutos();

            System.out.println("CPF do cliente: ");
            cpf = input.next();
            System.out.println(Arquivo.lerProdutos());
            System.out.println("Escolha seu lanche, selecionando o id dele");
            escolha = input.nextInt();
            if (escolha == 11) {
                for (Produto obj : listaProdutos) {
                    if (obj.getIdProduto() == escolha) {
                        listaProduto.add(obj);
                    }
                }
                totalPedido += 17.99;
            }
            if (escolha == 12) {
                for (Produto obj : listaProdutos) {
                    if (obj.getIdProduto() == escolha) {
                        listaProduto.add(obj);
                    }
                }
                totalPedido += 16.99;
            }
            if (escolha == 13) {
                for (Produto obj : listaProdutos) {
                    if (obj.getIdProduto() == escolha) {
                        listaProduto.add(obj);
                    }
                }
                totalPedido += 14.99;
            }
            if (escolha == 31) {
                for (Produto obj : listaProdutos) {
                    if (obj.getIdProduto() == escolha) {
                        listaProduto.add(obj);
                    }
                }
                totalPedido += 7.99;
            }
            if (escolha == 32) {
                for (Produto obj : listaProdutos) {
                    if (obj.getIdProduto() == escolha) {
                        listaProduto.add(obj);
                    }
                }
                totalPedido += 6.99;
            }
            if (escolha == 33) {
                for (Produto obj : listaProdutos) {
                    if (obj.getIdProduto() == escolha) {
                        listaProduto.add(obj);
                    }
                }
                totalPedido += 4.99;
            }
            valorTotal = Double.toString(totalPedido);
            System.out.println("Deseja continuar? 1(sim) 2(nao) ");
            criarPedido = input.nextInt();
        }
        Pedido pedido = new Pedido(cpf, idPedido, data, horarioPedido, status, valorTotal);
        Cliente cliente = new Cliente(nome, telefone, endereço, cpf, senha);
        pedido.setListaProduto(listaProduto);
        listaPedido.add(pedido);
        Arquivo.escreverPedido(listaPedido);

        cliente.setHistoricoPedido(listaPedido);
        listaCliente = (ArrayList<Cliente>) Arquivo.lerArqCliente();
        for (Cliente c : listaCliente) {
            if (c.getCpf() == null ? cpf == null : c.getCpf().equals(cpf)) {
                c.setHistoricoPedido(listaPedido);
            }
        }
        Arquivo.escreverArqCliente(listaCliente);
    }

    /**
     * mudar o pedido
     *
     * @throws ParseException
     * @throws IOException
     */
    public static void editarPedido() throws ParseException, IOException {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        ArrayList<Pedido> listaPedido = new ArrayList<>();
        int idPedido = 0, idProduto, search, IDpedido, pedido, set = 0, idProduto2, novoId;
        double totalPedido = 0;
        listaPedido = (ArrayList<Pedido>) Arquivo.lerArqPedido();
        double salario;
        String status = null, senha, valorTotal = null, data = null, horarioPedido = null;

        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja alterar dados de um pedido? 1(sim), 2(nao)");
        pedido = input.nextInt();
        while (pedido == 1) {
            System.out.println("Qual pedido voce deseja alterar os dados? Digite o ID do pedido ");
            search = input.nextInt();
            for (int i = 0; i < listaPedido.size(); i++) {
                Pedido a2 = listaPedido.get(i);
                if (a2.getIdPedido() == search) {
                    while (set != 4) {
                        System.out.println("Vai alterar o que? ID pedido(1), status(2), remover algum produto de pedido(3) e CANCELAR(4)");
                        set = input.nextInt();
                        if (set == 1) {
                            System.out.println("ID pedido: ");
                            IDpedido = input.nextInt();
                            a2.setIdPedido(IDpedido);
                        }
                        if (set == 2) {
                            System.out.println("Status: ");
                            status = input.next();
                            a2.setStatus(status);
                        }
                        if (set == 3) {
                            for (Pedido obj : listaPedido) {
                                ArrayList<Pedido> l = new ArrayList<>();
                                ArrayList<Pedido> l2 = new ArrayList<>();
                                l.addAll(listaPedido);
                                
                                
                                System.out.println(obj.getListaProduto());
                                System.out.println("ID produto que deseja excluir: ");
                                idProduto = input.nextInt();
                                for (Produto listaProduto1 : obj.getListaProduto()) {
                                    ArrayList<Produto> newgetListaProduto = new ArrayList<>();
                                    Produto p1 = new Produto();
                                    newgetListaProduto.addAll(obj.getListaProduto());
                                    for (Produto obj1 : newgetListaProduto) {
                                        if (obj1.getIdProduto() == idProduto) {
                                            newgetListaProduto.remove(obj1);
                                            System.out.println(newgetListaProduto);
                                            
                                            obj.getListaProduto().clear();
                                            obj.setListaProduto(newgetListaProduto);
                                            System.out.println(obj.getListaProduto());
                                            System.out.println(listaPedido);
                                            Arquivo.escreverPedido(listaPedido);
                                            break;
                                        }
                                    }

                                }

                            }
                        }
                        if (set == 4) {
                            break;
                        }
                    }
                }
            }
            Arquivo.escreverPedido(listaPedido);
            break;
        }
    }

    public static void removerPedido() throws ParseException, IOException {
        int pedido, search;
        ArrayList<Pedido> listaPedido = new ArrayList<>();
        ArrayList<Pedido> l = new ArrayList<>();
        listaPedido = (ArrayList<Pedido>) Arquivo.lerArqPedido();
        l.addAll(listaPedido);

        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja remover um pedido? 1(sim), 2(nao)");
        pedido = input.nextInt();
        while (pedido == 1) {
            System.out.println("Qual pedido voce deseja alterar os dados? Digite o ID do pedido ");
            search = input.nextInt();
            for (int i = 0; i < l.size(); i++) {
                Pedido p = l.get(i);
                if (p.getIdPedido() == search) {
                    l.remove(i);
                    Arquivo.escreverPedido(l);
                    pedido = 2;
                    break;
                }

            }
        }
    }

    /**
     * menu de metodos do adm
     *
     * @throws ParseException
     * @throws IOException
     */
    public static void menuAdm() throws ParseException, IOException {
        int escolha;
        Scanner input = new Scanner(System.in);
        List<Adm> listaAdm = new ArrayList<>();
        Funcionario[] vetorFuncionario = new Funcionario[15];
        ArrayList<Produto> listaProduto = new ArrayList<>();

        System.out.println("Escolha um dos metodos: ");
        System.out.println("(1) Cadastrar um Adm");
        System.out.println("(2) Alterar dados de um Adm");
        System.out.println("(3) Remover um Adm");
        System.out.println("(4) Cadastrar um funcionario");
        System.out.println("(5) Alterar dados de um funcionario");
        System.out.println("(6) Remover um funcionario");
        System.out.println("(7) Cadastrar um produto");
        System.out.println("(8) Alterar dados de um produto");
        System.out.println("(9) Remover um produto");
        System.out.println("(10) Sair do Sistema");
        escolha = input.nextInt();
        if (escolha == 1) {
            Adm.cadastrarAdm();
            Sistema.menuAdm();
        }
        if (escolha == 2) {
            Adm.alterarDadosAdm();
            Sistema.menuAdm();
        }
        if (escolha == 3) {
            Adm.removerAdm();
            Sistema.menuAdm();
        }
        if (escolha == 4) {
            Funcionario.cadastrarFuncionario();
            Sistema.menuAdm();
        }
        if (escolha == 5) {
            Funcionario.alterarDadosFuncionario();
            Sistema.menuAdm();
        }
        if (escolha == 6) {
            Funcionario.removerFuncionario();
            Sistema.menuAdm();
        }
        if (escolha == 7) {
            Produto.cadastrarProduto();
            Sistema.menuAdm();
        }
        if (escolha == 8) {
            Produto.alterarDadosProduto();
            Sistema.menuAdm();
        }
        if (escolha == 9) {
            Produto.removerProduto();
            Sistema.menuAdm();
        }
        if (escolha == 10) {
            System.out.println("Tchau");
        }
    }

    /**
     * menu de metodos do funcionario
     *
     * @throws ParseException
     * @throws IOException
     */
    public static void menuFunc() throws ParseException, IOException {
        int escolha;
        Scanner input = new Scanner(System.in);
        Funcionario[] vetorFuncionario = new Funcionario[15];
        ArrayList<Cliente> listaCliente = new ArrayList<>();

        System.out.println("Escolha um dos metodos: ");
        System.out.println("(1) Pedir");
        System.out.println("(2) Editar pedido");
        System.out.println("(3) Remover pedido");
        System.out.println("(4) Cadastrar cliente");
        System.out.println("(5) Alterar dados de cliente");
        System.out.println("(6) Remover cliente");
        System.out.println("(7) Alterar dados de um funcionario");
        System.out.println("(8) Estatistica de vendas no dia");
        System.out.println("(9) Pesquisar pedidos de clientes");
        System.out.println("(10) Sair do Sistema");
        escolha = input.nextInt();
        if (escolha == 1) {
            Sistema.pedir();
            Sistema.menuFunc();
        }
        if (escolha == 2) {
            Sistema.editarPedido();
            Sistema.menuFunc();
        }
        if (escolha == 3) {
            Sistema.removerPedido();
            Sistema.menuFunc();
        }
        if (escolha == 4) {
            Cliente.cadastraCliente();
            Sistema.menuFunc();
        }
        if (escolha == 5) {
            Cliente.alterarDadosCliente();
            Sistema.menuFunc();
        }
        if (escolha == 6) {
            Cliente.removerCliente();
            Sistema.menuFunc();
        }
        if (escolha == 7) {
            Funcionario.alterarDadosFuncionario();
            Sistema.menuFunc();
        }
        if (escolha == 8) {
            Sistema.estatisticaVenda();
            Sistema.menuFunc();
        }
        if (escolha == 10) {
            System.out.println("Tchau");
        }
    }

    /**
     * mostra quantos pedidos no dia
     *
     * @throws ParseException
     */
    public static void estatisticaVenda() throws ParseException {
        ArrayList<Pedido> l = new ArrayList<>();
        l = (ArrayList<Pedido>) Arquivo.lerArqPedido();
        String search;
        int count = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Dia da venda(ex: 01-01-2023): ");
        search = input.next();
        for (Pedido o : l) {
            System.out.println(o.getData());
            if (search.equals(o.getData())) {
                count = count + 1;
            }
        }
        System.out.println("Tem " + count + " pedidos neste dia");
    }

    public static void pesquisarProduto() throws ParseException {
        ArrayList<Pedido> l = new ArrayList<>();
        l = (ArrayList<Pedido>) Arquivo.lerArqPedido();
        String dia1, dia2, hora1, hora2;
        int count = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Dia do comeco da venda(ex: 01-01-2023): ");
        dia1 = input.next();
        System.out.println("Dia do fim da venda(ex: 01-01-2023): ");
        dia2 = input.next();
        System.out.println("Hora do comeco da venda(ex: 17:10:44): ");
        hora1 = input.next();
        System.out.println("Hora do fim da venda(ex: 17:10:44): ");
        hora2 = input.next();
        for (Pedido o : l) {
            //for(int i=0; i < ){}
            if (dia1.equals(o.getData())) {
                count = count + 1;
            }
        }
        System.out.println("Tem " + count + " pedidos neste dia");
    }

}
