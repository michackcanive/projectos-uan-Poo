
package gtr2.textui.main;
import gtr2.textui.main.MenuEntry.Menugtr;
import javax.swing.JOptionPane;
/**
 *
 * @author Elisandro Pombo
 */
public class Gtr2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String control="1";
         while(control.equals("1")){
              Menugtr.Menugtr();
            control=JOptionPane.showInputDialog(""
                     + " \n_______PRETENDES MESMO SAIR ?________\n\n\n"
                     +"               1-NÃO          "
                     +"2-SIM\n\n\n"); 
   
         }

        
       
        
    }
    
}
