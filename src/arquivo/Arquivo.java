/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arquivo;

import com.google.gson.Gson;
import lanchonetebreno.Cliente;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lanchonetebreno.Adm;
import lanchonetebreno.Funcionario;
import lanchonetebreno.Pedido;
import lanchonetebreno.Produto;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author breno
 */
public class Arquivo {

    private static String stringJSON;
    private static String stringArray;
    private static Gson gson = new Gson();
    private static JSONArray array = new JSONArray();
    private static final JSONParser parser = new JSONParser();
    List<String> listaJson = new ArrayList<>();

    /**
     * escreva a lista de clientes cadastrados em arquivo json
     * @param cliente
     * @throws IOException
     * @throws ParseException
     */
    public static void escreverArqCliente(List<Cliente> cliente) throws IOException, ParseException {
        array.clear();//Limpa a memoria de array, para evitar repetições do json ja salvo.
        gson = new Gson();
        for (Cliente obj : cliente) {
            array.add(obj);// Salva todos os Objetos de cliente em array.
        }
        stringJSON = gson.toJson(array);// Converte Array de Obejots em formato JSON.
        FileWriter writer = new FileWriter("./src/arquivo/listaCliente.json");
        try {//Escreve Json convertido em arquivo chamado "listaCliente.json"
            writer.write(stringJSON);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//Finaliza o arquivo em caso de lançamento de excessão.
            writer.close();
        }
    }
    
    /**
     * le o arquivo json que contem uma lista de clientes cadastrados
     * @return lista de clientes
     * @throws ParseException
     */

    public static List<Cliente> lerArqCliente() throws ParseException {
        List<Cliente> listaCliente = new ArrayList<>();
        Gson gson = new Gson();
        String stringJSON;
        try {
            FileReader leitura = new FileReader("./src/arquivo/listaCliente.json");
            array = (JSONArray) parser.parse(leitura);
           
            for (int i = 0; i < array.size(); i++) {
                stringJSON = array.get(i).toString();
                Cliente novoCliente = new Gson().fromJson(stringJSON, Cliente.class);//pega arquivo json e passa pra objeto tipo cliente
                listaCliente.add(novoCliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCliente;
    }

    /**
     * escreva a lista de funcionarios cadastrados em arquivo json
     * @param vetorFuncionario
     * @throws ParseException
     */
    public static void escreverArqFuncionario(Funcionario[] vetorFuncionario) throws ParseException {
        array.clear();//Limpa a memoria de array, para evitar repetições do json ja salvo.
        List<String> listaJson = new ArrayList<>();
        for (Funcionario c : vetorFuncionario) {
            stringJSON = gson.toJson(c);
            listaJson.add(stringJSON);// Salva todos os Objetos em vetor
        }
        try ( FileWriter escrita = new FileWriter("./src/arquivo/vetorFuncionario.json")) {
            escrita.write(listaJson.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * le o arquivo json que contem uma lista de funcionarios cadastrados
     * @return lista de funcionarios
     * @throws ParseException
     */
    public static Funcionario[] lerArqFuncionario() throws ParseException {
        Funcionario[] vetorFuncionario = new Funcionario[15];
        try {
            FileReader reader = new FileReader("./src/arquivo/vetorFuncionario.json");
            array = (JSONArray) parser.parse(reader);
            for (int i = 0; i < array.size(); i++) {
                if(array.get(i) != null){
                    
                stringJSON = array.get(i).toString();
                Funcionario novoFuncionario = new Gson().fromJson(stringJSON, Funcionario.class);//pega arquivo json e passa pra objeto tipo cliente
                vetorFuncionario[i] = novoFuncionario;
                }
            }
            //System.out.print("\n" + Arrays.toString(vetorFuncionario));
        } catch (IOException e) {
        }
        return vetorFuncionario;
    }

    /**
     * le o arquivo json que contem uma lista de adms cadastrados
     * @return lista de adm
     * @throws ParseException
     */
    public static List<Adm> lerArqAdm() throws ParseException {
        ArrayList<Adm> listaAdm = new ArrayList<>();
        Gson gson = new Gson();
        String stringJSON;
        try {
            FileReader leitura = new FileReader("./src/arquivo/listaAdm.json");
            array = (JSONArray) parser.parse(leitura);
            for (int i = 0; i < array.size(); i++) {
                stringJSON = array.get(i).toString();
                Adm novoAdm = new Gson().fromJson(stringJSON, Adm.class);//pega arquivo json e passa pra objeto tipo cliente
                listaAdm.add(novoAdm);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAdm;
    }

    /**
     *escreva a lista de adms cadastrados em arquivo json
     * @param adm
     * @throws IOException
     */
    public static void escreverArqAdm(List<Adm> adm) throws IOException {
      
        array.clear();//Limpa a memoria de array, para evitar repetições do json ja salvo.
        gson = new Gson();

        for (Adm obj : adm) {
            array.add(obj);// Salva todos os Objetos de cliente em array.
        }
        stringJSON = gson.toJson(array);// Converte Array de Obejots em formato JSON.
        FileWriter writer = new FileWriter("./src/arquivo/listaAdm.json");
        try {//Escreve Json convertido em arquivo chamado "listaCliente.json"
            writer.write(stringJSON);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//Finaliza o arquivo em caso de lançamento de excessão.
            writer.close();

        }
    }

    /**
     *le os produtos cadastrados no arquivo json
     * @return lista de Produto
     * @throws ParseException
     */
    public static List<Produto> lerProdutos() throws ParseException {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        Gson gson = new Gson();
        String stringJSON;
        try {
            FileReader leitura = new FileReader("./src/arquivo/listaProduto.json");
            array = (JSONArray) parser.parse(leitura);
            for (int i = 0; i < array.size(); i++) {
                stringJSON = array.get(i).toString();
                Produto produto = new Gson().fromJson(stringJSON, Produto.class);//pega arquivo json e passa pra objeto tipo cliente
                listaProduto.add(produto);
            }            
        } catch (IOException e) {
        }
        return listaProduto;
    }
    
    /**
     * escreve a lista de produto no aquivo json
     * @param produto
     * @throws IOException
     */
    public static void escreverProduto(List<Produto> produto) throws IOException {
        array.clear();//Limpa a memoria de array, para evitar repetições do json ja salvo.
        gson = new Gson();

        for (Produto obj : produto) {
            array.add(obj);// Salva todos os Objetos de cliente em array.
        }
        stringJSON = gson.toJson(array);// Converte Array de Obejots em formato JSON.
        FileWriter writer = new FileWriter("./src/arquivo/listaProduto.json");
        try {//Escreve Json convertido em arquivo chamado "listaCliente.json"
            writer.write(stringJSON);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//Finaliza o arquivo em caso de lançamento de excessão.
            writer.close();
        }
    }

    /**
     * le json da lista de pedidos 
     * @return
     * @throws ParseException
     */
    public static List<Pedido> lerArqPedido() throws ParseException {
        ArrayList<Pedido> listaPedido = new ArrayList<>();
        Gson gson = new Gson();
        String stringJSON;
        try {
            FileReader leitura = new FileReader("./src/arquivo/listaPedido.json");
            array = (JSONArray) parser.parse(leitura);
            for (int i = 0; i < array.size(); i++) {
                stringJSON = array.get(i).toString();
                Pedido novoPedido = new Gson().fromJson(stringJSON, Pedido.class);//pega arquivo json e passa pra objeto tipo cliente
                listaPedido.add(novoPedido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPedido;
    }
    
    /**
     * escreva a lista de pedidos cadastrados em arquivo json
     * @param pedido
     * @throws IOException
     */
    public static void escreverPedido(List<Pedido> pedido) throws IOException {
        array.clear();//Limpa a memoria de array, para evitar repetições do json ja salvo.
        gson = new Gson();

        for (Pedido obj : pedido) {
            array.add(obj);// Salva todos os Objetos de cliente em array.
        }
        stringJSON = gson.toJson(array);// Converte Array de Obejots em formato JSON.
        FileWriter writer = new FileWriter("./src/arquivo/listaPedido.json");
        try {//Escreve Json convertido em arquivo chamado "listaCliente.json"
            writer.write(stringJSON);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//Finaliza o arquivo em caso de lançamento de excessão.
            writer.close();
        }
    }
    
    @Override
    public String toString() {
        return "Arquivo{" + "listaJson=" + listaJson + '}';
    }
    
}
