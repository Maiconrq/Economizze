/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Carrinho;

/**
 *
 * @author lucas
 */
public class CarrinhoControl {
    public static boolean SalvarCarrinho(String nome,String quantiade,String preco){
        Carrinho f = new Carrinho(nome,quantiade,preco);
        return f.Perdurar();       
        }
    public static ArrayList<String[]> getCarrinhos(){
        
        ArrayList<String[]> Carrinhos = new ArrayList();
        
        ArrayList<Carrinho> F = Carrinho.getCarrinhos();
        if(F!=null){
        for(int i=0;i<F.size();i++){
            String f[]= new String[5];
            f[0]=F.get(i).getNome();
            f[1]=F.get(i).getQuantiade();
            f[2]=F.get(i).getPreco();

            Carrinhos.add(f);
        }
        }
        return Carrinhos; 
  }   
}
