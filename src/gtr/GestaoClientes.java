/*
 * PROJECTO DE POO 2021

 * DESEVOLVIDADERS:

 * MICHACK ANTÕNIO ODRIGUES CANIVE
 - Novais Kicunda Quibambo David
 - Patrício Wilder Barros Pedro
 - Isabel da Graça Catarina José
 */
package gtr;

import gtr2.textui.client.Cliente;
import javax.swing.JOptionPane;
import gtr2.textui.mobile.Telemoves;
import gtr2.textui.main.MenuEntry.Menugtr;


public class GestaoClientes {

    static String[] registodeconta = new String[40];

    public static void visualizar() {

        String activa = "1";
        String pegaTm = "";
        double divid = 0;
        String[] chave = new String[20];
        int cont = 0;
        // 1

        for (int i = 0; i < Cliente.getNumcli(); i++) {
            for (int j = 0; j < 9; j++) {
                if (Cliente.getChave(i) != null) {
                    if (cont > 0) {
                        break;
                    }
                    pegaTm = pegaTm + Cliente.getChave(i) + "\\";
                    pegaTm = pegaTm + Cliente.getNome(i) + "\\";
                    pegaTm = pegaTm + Cliente.getRegistodeCont(i) + "\\";
                    pegaTm = pegaTm + Telemoves.getSaldo(i, j) + "\\";
                    pegaTm = pegaTm + Cliente.getTipocli(i) + "\\ \n";
                }
                cont++;

            }
            cont = 0;
        }

        activa = JOptionPane.showInputDialog(""
                + " \n_______Visualizar [visualizar todos os clientes] ________\n"
                + pegaTm + "\n"
                + "1-Voltar\n");
        Menugtr.MenudeGestãodeClientes();
    }

    public static void Registarcli() {
        String cot = "1";
        int contint = Cliente.getNumcli(), a = Cliente.getA(), b = Cliente.getB(), c = Cliente.getC();
        String[] chave = new String[90];
        String[] nome = new String[90];
        String[] estado = new String[90];
        String[] tipocli = new String[90];

        for (int i = 0; i < Cliente.getNumcli(); i++) {
            tipocli[i] = Cliente.getTipocli(i);
        }

        for (int i = 0; i < Cliente.getNumcli(); i++) {
            chave[i] = Cliente.getChave(i);
        }

        for (int i = 0; i < Cliente.getNumcli(); i++) {
            nome[i] = Cliente.getNome(i);
        }

        //Repiticao
        // o cliente fica no estado Normal e com o registo de contactos falhados activo. 
        while (cot.equals("1")) {
            nome[contint] = JOptionPane.showInputDialog(""
                    + " \n______________________Registar [registar novo cliente ] ______________________\n\n"
                    + "1-Nome do Cliente\n"
                    + "6-Voltar\n");
            
            //estado[contint]="LIGADO";
            tipocli[contint] = "NORMAL";
            registodeconta[contint] = "ACTIVO";
            Cliente.setRegistodeCont(registodeconta);
            // Cliente.setEstado(estado);

            Cliente.setNome(nome);

            if (a > 8) {
                b = b + 1;
                a = 0;
            } else if (a < a + 1) {
                a = a + 1;
            } else if (b > 9) {
                c = c + 1;
                b = 0;
            } else if (b < b + 2) {
                b = b + 1;
                a = 0;
            }

            String p = "";
            p = "Cli" + c + b + a + "ao";
            chave[contint] = p;
            Cliente.setA(a);
            Cliente.setB(b);
            Cliente.setC(c);
            System.out.print(chave[contint]);
            contint++;
            Cliente.setTipocli(tipocli);
            Cliente.setChave(chave);
            Cliente.setNumcli(contint);

            //  super.setchave(g);
            cot = JOptionPane.showInputDialog(""
                    + " \n______________________Registar [registar novo cliente ] ______________________\n\n"
                    + "1-PRETENDES INSERIR MAIS:\n"
                    + "1-SIM \n"
                    + "2-NAO\n");

        } //fim do while
        Menugtr.MenudeGestãodeClientes();

    }

    public static void Activar() {

        /*O sistema pede o identificador do cliente. Se 
                o registo de contactos falhados já estava activo,
                o cliente não é alterado e é enviada a mensagem alreadyMessageActive()*/
        String cot = JOptionPane.showInputDialog(""
                + " \n_____________________[ACTIVAR  CLIENTE ] ______________________\n\n"
                + "1-INSERA O IDENTIFICADOR:\n"
                + "2-VOLTAR\n");

        if (pesquisar_Chave(cot)) {
           
            if (cot.equals(Cliente.getChave(Cliente.getPosicao()))) {
                if (Cliente.getRegistodeCont(Cliente.getPosicao()).equals("ACTIVO")) {
                    alreadyMessageActive();
                } else {
                    if (Cliente.getRegistodeCont(Cliente.getPosicao()).equals("INATIVO")) {
                        registodeconta[Cliente.getPosicao()] = "ACTIVADO";
                        Cliente.setRegistodeCont(registodeconta);
                        JOptionPane.showMessageDialog(null, "ACTIVADO COM SUCESSAO");

                    }

                }

            }
        }
        Menugtr.MenudeGestãodeClientes();
    }

    public static void Desactivar() {
        String cot = JOptionPane.showInputDialog(""
                + " \n______________________[DESACTIVAR CLIENTE ] ______________________\n\n"
                + "1-INSERA O IDENTIFICADOR:\n"
                + "2-VOLTAR\n");
        if (pesquisar_Chave(cot)) {
            if (cot.equals(Cliente.getChave(Cliente.getPosicao()))) {
                if (Cliente.getRegistodeCont(Cliente.getPosicao()).equals("INACTIVO")) {
                   alreadyMessageInactive();
                } else {
                    if (Cliente.getRegistodeCont(Cliente.getPosicao()).equals("ACTIVO")) {
                        registodeconta[Cliente.getPosicao()] = "INACTIVO";
                        Cliente.setRegistodeCont(registodeconta);
                        JOptionPane.showMessageDialog(null, "DESATIVADO COM SUCESSAO");

                    }

                }

            }
        }
        Menugtr.MenudeGestãodeClientes();
    }

    public static void Calcularsaldo() {
         String cot = JOptionPane.showInputDialog(""
                    + " \n______________________[SALDO INDIVIDUAL DO CLIENTE ] ______________________\n\n"
                    + "1-INSERIR O IDENTIFICADOR DO CLIENTE:\n"
                    + " \n"
                    + "\n");
         int pega=0;
        if(GestaoClientes.pesquisar_Chave(cot))
       for(int i=0;i<20;i++){
          pega=pega+Telemoves.getSaldo(Cliente.getPosicao(), i);
                
       }else
            if(GestaoClientes.pesquisar_Chave(cot)==false){
        JOptionPane.showMessageDialog(null, "IDENTIFICADORE NÃO FOI ENCONTRADO");
        Menugtr.MenudeGestãodeClientes();
         }
        JOptionPane.showMessageDialog(null, pega);
        Menugtr.MenudeGestãodeClientes();
    }
    

    public static boolean pesquisar_Chave(String chavedepesq) {
        if (chavedepesq == null) {
            return false;
        } else {

            for (int i = 0; i < Cliente.getNumcli(); i++) {
                if (chavedepesq.equals(Cliente.getChave(i))) {
                    Cliente.setPosicao(i);
                    return true;
                }
            }
        }

        return false;
    }

    
    
  public static void alreadyMessageInactive(){
   JOptionPane.showMessageDialog(null, "JÁ SE ENCONTRA DESACTIVADO");
   }
   public static void  alreadyMessageActive(){
    JOptionPane.showMessageDialog(null, "JÁ SE ENCONTRA ACITVADO");
   }
   
    public static String clientNormal(){
        
        return "NORMAL";
}
    public static String clientGold(){
        
        return "OURO";
}
    public static String clientPlatine(){
        
        return "PLATINA";
}
    
}
