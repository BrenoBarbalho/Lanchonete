/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanchonetebreno;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * atributos de pedido
 * @author breno
 */
public class Pedido implements Comparator<Pedido>{
     //atributos,
    private String cpf;
    private int idPedido;
    private String data;
    private String horarioPedido;
    private String status;
    private String valorTotal;
    ArrayList<Produto> listaProduto = new ArrayList<>();
    
    //constructor
    public Pedido(){}
    
    
    public Pedido(String cpf, int idPedido, String data, String horarioPedido, String status, String valorTotal) {
        this.cpf = cpf;
        this.idPedido = idPedido;
        this.data = data;
        this.horarioPedido = horarioPedido;
        this.status = status;
        this.valorTotal = valorTotal;
    }
    
    //getters and setters
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioPedido() {
        return horarioPedido;
    }

    public void setHorarioPedido(String horarioPedido) {
        this.horarioPedido = horarioPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    //métodos

    @Override
    public String toString() {
        return "Pedido{" + "cpf=" + cpf + ", idPedido=" + idPedido + ", data=" + data + ", horarioPedido=" + horarioPedido  
                + ", status=" + status + ", valorTotal=" + valorTotal + ", listaProduto=" + listaProduto + '}';
    }   

    @Override
    public int compare(Pedido o1, Pedido o2) {
        return o1.getData().compareTo(o2.getData());
    }

}
