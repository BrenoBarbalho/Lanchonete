/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lanchonetebreno;

import arquivo.Arquivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.json.simple.parser.ParseException;
import java.util.Collections;

/**
 *
 * @author breno
 */
public class Login {

    /**
     * validar o aceeso do adm ou funcionario no sitema da lachonete
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String logar() throws ParseException, IOException {
        int cont = 0;
        String cpf, senha;
        ArrayList<Adm> listaAdm = new ArrayList();
        Funcionario[] vetorFuncionario = new Funcionario[15];
        
        System.out.println("Bem vindo a Lanchonete orientada ao cliente");
        System.out.println("Por favor faca seu login");
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu cpf: ");
        cpf = input.next();
        System.out.println("Digite sua senha: ");
        senha = input.next();

        listaAdm = (ArrayList<Adm>) Arquivo.lerArqAdm();
        for (int i = 0; i < listaAdm.size(); i++) {
            Adm a2 = listaAdm.get(i);
            if (a2.getCpf().equals(cpf)) {
                System.out.println("Bem vindo Adm " + a2.getNome());
                cont++;
                Sistema.menuAdm();
                break;
            }
        }
        if (cont == 0) {
            vetorFuncionario = Arquivo.lerArqFuncionario();
            for (int i = 0; i < vetorFuncionario.length; i++) {
                Funcionario f2 = vetorFuncionario[i];
                if (vetorFuncionario[i] != null) {
                    if (vetorFuncionario[i].getCpf().equals(cpf) & vetorFuncionario[i].getSenha().equals(senha)) {
                        System.out.println("Bem vindo Funcionario " + vetorFuncionario[i].getNome());
                        cont++;
                        Sistema.menuFunc();
                        break;
                    } else {
                        System.out.println("Cpf ou senha errado, tente novamente!");
                        Login.logar();
                    }
                }
            }
        }
        
       
        return cpf;
        
    }
}
