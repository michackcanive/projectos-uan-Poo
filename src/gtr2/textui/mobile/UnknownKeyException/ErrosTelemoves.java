/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtr2.textui.mobile.UnknownKeyException;

import javax.swing.JOptionPane;

/**
 *
 * @author Larval Stage
 */
public class ErrosTelemoves {
    
    
    public static boolean verifica(String c){
    try{
        Double conervt=new Double(c);
        
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "INSIRA UMA NUMERO VALIDO");
        return false;
    }
    
    
    
   
         
    return true;}
    
    
     public static boolean verificaNumero(String c){
    try{
        Double conervt=new Double(c);
        
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "INSIRA UMA NUMERO VALIDO");
        return false;
    }
    
    
    
   
         
    return true;}
    
    
    
    
}
