package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.ArrayList;
import json.JSONArray;
import json.JSONObject;
import util.Arquivo;
/**
 *
 * @author Maicon
 */
public class Carrinho {
    private String nome;
    private String quantiade;
     private String preco;
    
  

    public Carrinho() {
    }

    public Carrinho(String nome, String quantiade, String preco) {
        this.nome = nome;
        this.quantiade = quantiade;
        this.preco = preco;
    }
public Carrinho(JSONObject json) {
        this.nome = json.getString("Nome");
        this.quantiade = json.getString("Quantidade:");
        this.preco = json.getString("Preço:");
        
    }
 
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the quantiade
     */
    public String getQuantiade() {
        return quantiade;
    }

    /**
     * @param quantiade the quantiade to set
     */
    public void setQuantiade(String quantiade) {
        this.quantiade = quantiade;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }
    
     public JSONObject toJson(){
      JSONObject json = new JSONObject();
      json.put("Nome",this.nome);
      json.put("Quantidade",this.quantiade);
      json.put("Preço",this.preco);
      return json;
    }
 public boolean Perdurar(){
        JSONObject json=this.toJson();
        String banco = Arquivo.Read();
        JSONArray jF = new JSONArray();
        if(!banco.isEmpty() && banco.length()>5)
               jF = new JSONArray(banco);
       
             jF.put(json);
        Arquivo.Write(jF.toString());
        return true;
    }
 public static ArrayList<Carrinho>getCarrinhos(){
        ArrayList<Carrinho>carrinhos=new ArrayList();
        String banco = Arquivo.Read();
        if(banco.isEmpty()|| banco.length()<5)
            return null;
        JSONArray jF = new JSONArray(banco);
        for(int i=0;i<jF.length();i++){
            Carrinho F = new Carrinho(jF.getJSONObject(i));
            carrinhos.add(F);
        }
        return carrinhos;
        
    }
    /**
     * @return the ListaDeCompras
     */
   

    /**
     * @param ListaDeCompras the ListaDeCompras to set
     */
    /*public void setListaDeCompras(ArrayList<Produto> ListaDeCompras) {
        this.ListaDeCompras = ListaDeCompras;
    }*/
    
    
    

    /**
     *
     * @param nome
     * @param quantiade
     * @param preco
     * @param ListaDeCompras
     */
    
   
   
           

    
    
}
