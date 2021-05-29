/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtr2.gestaoTelemoves;

import gtr.GestaoClientes;
import gtr2.textui.client.Cliente;
import gtr2.textui.main.MenuEntry.Menugtr;
import gtr2.textui.mobile.Telemoves;
import javax.swing.JOptionPane;

/**
 *
 * @author Larval Stage
 */
public class ConsultarActividades {
    public static void Consultartodasaschamadas()
    {       String consulta="";
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++){
                if(Telemoves.getActivedade(i, j)!=null){
                   consulta=consulta+Telemoves.getActivedade(i, j)+"\n";
                          }
                else{ 
                    break;
                    
                }
            }
         JOptionPane.showMessageDialog(null, consulta, "Consulta de todas as chamadas".toUpperCase(), 1);
         Menugtr.MenudeConsultas();
    }
    
    
    public static void Consultarchamadasdeumcliente (){
        
        String cliente = JOptionPane.showInputDialog(""
                + " \n_______ VISULIZAÇÃO DAS ACTIVIDADE DE UM CLIENTE ________\n"
                + "INSIRA A CHAVE DO CLIENTE \n"
                + "\n"
                + "1-Voltar\n");
           String mostra="";
       
        
        for(int i=0;i<20;i++){
                    for(int j=0;Telemoves.getActivedade(i, j)!=null;j++){
                      String[]  pega1 = Telemoves.getActivedade(i, j).split("/");
                        Double convert= new Double(pega1[2]);
                        Double convert1= new Double(pega1[3]);
                        Double convert2= new Double(pega1[1]);
                        
                        if(GestaoTelemoves.pesquisar_ChaveTm(convert.intValue())){ 
                            
                               System.out.println("Exite"+ GestaoTelemoves.pesquisar_ChaveTm(convert.intValue())+"--"+Cliente.getChave(Telemoves.getPosicaoi()));
                                }
                        
                        if(cliente.equals(Cliente.getChave(Telemoves.getPosicaoi()))){
                             mostra=mostra + cliente +"/"+pega1[1]+"/"+pega1[2]+"/"
                                     +pega1[3]+"/"+pega1[4]+"/"+pega1[5]+"/"+pega1[6]+"\n";
                        
                        }else{
                            JOptionPane.showMessageDialog(null, "NENHUM RESULTADO FOI ENCONTRADO VERIFIQUE A CHAVE DO CLIENTE INSERIDO !");
                            Menugtr.MenudeConsultas();
                        }
                       
                     
                    }
                     
                } 
 
        JOptionPane.showMessageDialog(null, mostra, "Consulta de todas as chamadas De um Cliente".toUpperCase(), 1);
                     Menugtr.MenudeConsultas();
                
    }
    
    public static void Consultartelemóveissemactividade(){
        String pegaTm = "";
        int pega;
        
        for(int i=0;i<20;i++){
                    for(int j=0;Telemoves.getActivedade(i, j)!=null;j++){
                      String[]  pega1 = Telemoves.getActivedade(i, j).split("/");
                        Double convert= new Double(pega1[2]);
                        pega=convert.intValue();
         for (int i1 = 0; i1 < Cliente.getNumcli(); i1++) {
            for (int j1 = 0; j1 < Telemoves.getNumTm(); j1++) {
                if (Telemoves.getChaveTm(i1, j1) != 0) {
               
                    if(pega!=Telemoves.getChaveTm(i1, j1)){
                        pegaTm=pegaTm+ "DE MOMENTO SEM ACTIVIDADES "+Telemoves.getChaveTm(i1, j1)+"\n";
                    
                    }
                  
                }

            }
        }
                      
                    }
        }
        
        JOptionPane.showMessageDialog(null, pegaTm, "NÚMEROS SEM ACTIVIDADES".toUpperCase(), 1);
                     Menugtr.MenudeConsultas();
        
         
        
    }
    public static void Consultartelemóveiscomsaldopositivo(){
        
          String pegaTm = "";
        
        
              for (int i1 = 0; i1 < Cliente.getNumcli(); i1++) {
            for (int j1 = 0; j1 < Telemoves.getNumTm(); j1++) {
                if (Telemoves.getChaveTm(i1, j1) != 0) {
               
                    if(0==Telemoves.getSaldo(i1, j1)){
                        pegaTm=pegaTm + Telemoves.getChaveTm(i1, j1)+"/SEU SALDO="+Telemoves.getSaldo(i1, j1)+"\n";
                    
                    }
                  
                }

            }
        
                      
                    
        }
        
        JOptionPane.showMessageDialog(null, pegaTm, "NÚMEROS COM SALDO NEGATIVO OU ZERO".toUpperCase(), 1);
                     Menugtr.MenudeConsultas();
     } 
    
    
    
}
