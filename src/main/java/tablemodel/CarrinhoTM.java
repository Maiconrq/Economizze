/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author  Maicon
 */
public class CarrinhoTM extends AbstractTableModel{
     private List<String[]> linhas;
     private String[] colunas = new String[]{"Nome","Quantidade","Preço"};
      public CarrinhoTM(){
        linhas = new ArrayList<String[]>();
    }
    public CarrinhoTM(List<String[]>lista){
        linhas = new ArrayList<String[]>(lista);
    }
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String p[]=linhas.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return p[0];
            case 1:
                return p[1];
            case 2:
                return p[2];
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
                
        }
    }
    public void setValueAT(Object fValue, int rowIndex, int columnIndex){
            String p[]= linhas.get(rowIndex);
            
            switch(columnIndex){
                case 0:
                    p[0]=fValue.toString();
                    break;
                case 1:
                    p[1]=fValue.toString();
                    break;
                case 2:
                    p[2]=fValue.toString();
                case 3:
                    p[3]=fValue.toString();
                case 4:
                    p[4]=fValue.toString();
                default:
                                  
            }
            
            fireTableCellUpdated(rowIndex, columnIndex);
        }
          public void setValueAt (String fValue[], int rowIndex){
           String p[]=linhas.get(rowIndex);
           
           p[0]= fValue[0];
           p[1]=fValue[1];
           p[2]=fValue[2];
           p[3]=fValue[3];
           p[4]=fValue[4];
         fireTableCellUpdated(rowIndex,0);
         fireTableCellUpdated(rowIndex, 1);
         fireTableCellUpdated(rowIndex, 2);
         fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
       }
           @Override
    
    public boolean isCellEditable(int rowIndex,int columnIndex){
    return false;    
    }
     public String[] getCarrinho(int indiceLinha){
        
        return linhas.get(indiceLinha);
    }
     
     public void addCarrinho(String f[]){
        
        linhas.add(f);
        int ultimoIndice= getRowCount()-1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
      public void remove(int indiceLinha){
       
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        
    }
    public void addLista(List<String[]>f){
        int tamanhoAntigo = getRowCount();
        
        linhas.addAll(f);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);       
    }
   public void limpar(){
       linhas.clear();
       fireTableDataChanged();
   }   
   
   public boolean isEmpty(){
         return linhas.isEmpty();
   }
    
        
    
}
