/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtr2.gestaoTelemoves;

import gtr2.textui.client.Cliente;
import gtr2.gestaoTelemoves.*;
import static gtr2.textui.main.MenuEntry.Menugtr.MenudeGestaodoTelemovelNNN;
import gtr2.textui.mobile.Telemoves;
import gtr2.textui.mobile.UnknownKeyException.ErrosTelemoves;
import javax.swing.JOptionPane;

/**
 *
 * @author Larval Stage
 */
public class GestaodotelemovelNN {

    public static void consutalsaldo(int pega, int numerot) {
        String sms = "";
        if (GestaoTelemoves.pesquisar_ChaveTm(pega)) {
            sms = "O SEU SALDO É IGUAL A " + Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) + "\n\n";
            JOptionPane.showMessageDialog(null, sms);
        }

        MenudeGestaodoTelemovelNNN(pega, numerot);
    }

    public static void Pagamento(int recebe, int numerot) {
        int pegaSaldo[][] = new int[20][20];
        int paga = paymentValue();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                pegaSaldo[i][j] = Telemoves.getSaldo(i, j);
            }
        }

        if (GestaoTelemoves.pesquisar_ChaveTm(recebe)) {
            pegaSaldo[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] = pegaSaldo[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] + paga;
            Telemoves.setSaldo(pegaSaldo);
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL FAZER O PAGAMENTO EM " + recebe);
        }
        MenudeGestaodoTelemovelNNN(recebe, numerot);
    }

    public static void Adicionar_amigo(int pega, int numerot) {
        String[][] amigos = new String[20][20];
        String add = "";
        int cont = Telemoves.getNumamigo();
        add = JOptionPane.showInputDialog(""
                + " \n_______INSIRA O NUMERO DO AMIGO ________\n"
                + "INSERA O NUMERO DE AMIGO"
                + "\n1-Voltar\n");
        Double n = new Double(add);
        for (int j = 0; j < 20; j++) {
            if (Telemoves.getAmigoTm(Telemoves.getPosicaoi(), j) != null) {
                amigos[Telemoves.getPosicaoi()][j] = Telemoves.getAmigoTm(Telemoves.getPosicaoi(), j);
            } else {
                GestaoTelemoves.pesquisar_ChaveTm(n.intValue());
                amigos[Telemoves.getPosicaoi()][j] = add;
                System.out.print(amigos[Telemoves.getPosicaoi()][j] + "Amigos" + Telemoves.getPosicaoi() + "--" + j);
                break;
            }
        }
        cont++;
        Telemoves.setAmigoTm(amigos);
        Telemoves.setNumamigo(cont);
        MenudeGestaodoTelemovelNNN(pega, numerot);
    }

    public static void Retirar_amigo(int pega, int numerot) {
        String[][] amigos = new String[20][20];
        String add = "";
        add = JOptionPane.showInputDialog(""
                + " \n_______REMOVER AMIGO DA LISTA________\n"
                + "INSERA O NUMERO A REMOVER "
                + "\n1-Voltar\n");
        if (GestaoTelemoves.pesquisar_amigos(add)) {
            for (int j = 0; j < Telemoves.getNumamigo(); j++) {
                amigos[Telemoves.getPosicaoi()][j] = Telemoves.getAmigoTm(Telemoves.getPosicaoi(), j);
            }
            String g = "";
            System.out.print("Amigo " + amigos[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()]);
            g = amigos[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()];

            amigos[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] = "--";
            g = "O AMIGO-" + g + "-FOI REMOVIDO DA LISTA DE AMIGO";
            System.out.print("LIMPO " + amigos[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] + " posicao " + Telemoves.getPosicaoi() + " " + Telemoves.getPosicaoj());
            JOptionPane.showMessageDialog(null, g);

        } else {
            JOptionPane.showMessageDialog(null, "ESTE NUMERO NÃO FAZ PARTE NOS AMIGOS");
        }
        MenudeGestaodoTelemovelNNN(pega, numerot);
    }

    public static void Desligar_telemovel(int pega, int numerot) {
        String[][] estadopega = new String[20][20];
        if (pega == 0) {
            JOptionPane.showMessageDialog(null, "Não foi possivel Desligar");
        } else {
            if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("DELIGADO")) {
                JOptionPane.showMessageDialog(null, "alreadyOff()");
            } else if (Telemoves.getNumTm() > 0 && Cliente.getNumcli() > 0) {
                for (int i = 0; i < Cliente.getNumcli(); i++) {
                    for (int j = 0; j < Telemoves.getNumTm(); j++) {
                        estadopega[i][j] = Telemoves.getEstadoTm(i, j);
                    }
                }
            }
            estadopega[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] = "DESLIGADO";
            Telemoves.setEstadoTm(estadopega);
        }
    }

    public static void Colocar_telemovel_silencio(int pega, int numerot) {
        String[][] estadopega = new String[20][20];
        if (pega == 0) {
            JOptionPane.showMessageDialog(null, "Não foi possivel Deixar no Silencio");
        } else {
            if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("SELENCIO")) {
                JOptionPane.showMessageDialog(null, " alreadySilent()");
            } else if (Telemoves.getNumTm() > 0 && Cliente.getNumcli() > 0) {
                for (int i = 0; i < Cliente.getNumcli(); i++) {
                    for (int j = 0; j < Telemoves.getNumTm(); j++) {
                        estadopega[i][j] = Telemoves.getEstadoTm(i, j);
                    }
                }
            }
            estadopega[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] = "SILENCIO";
            Telemoves.setEstadoTm(estadopega);

        }
        MenudeGestaodoTelemovelNNN(pega, numerot);
    }

    public static void Ligar_telemovel(int pega, int numerot) {
        String[][] estadopega = new String[20][20];
        if (pega == 0) {
            JOptionPane.showMessageDialog(null, "Não foi possivel Ligar o TELEVOME ");
        } else {
            if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("LIGADO")) {
                JOptionPane.showMessageDialog(null, "alreadyOn()");
            } else if (Telemoves.getNumTm() > 0 && Cliente.getNumcli() > 0) {
                for (int i = 0; i < Cliente.getNumcli(); i++) {
                    for (int j = 0; j < Telemoves.getNumTm(); j++) {
                        estadopega[i][j] = Telemoves.getEstadoTm(i, j);
                    }
                }
            }
            estadopega[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] = "LIGADO";
            Telemoves.setEstadoTm(estadopega);

        }
        MenudeGestaodoTelemovelNNN(pega, numerot);
    }

    public static void estabelecer_ligacao(int telchamador, int numerot) {

        String telchamodo = JOptionPane.showInputDialog(""
                + " \n_______ESTABELECER LIGAÇÃO [EFECTUAR CHAMADA  ] ________\n"
                + "INSERIR O IDENTIFICADOR DO TELEFONE A CONTACTAR"
                + "\n1-Voltar\n");
                if(ErrosTelemoves.verifica(telchamodo)) { 
                Double converte = new Double(telchamador);
                if (GestaoTelemoves.pesquisar_ChaveTm(converte.intValue())) {
                String tipodechamada = JOptionPane.showInputDialog(""
                    + " \n_______CHAMADA ________\n"
                    + "TIPO DE CHAMADA QUE PRETENDES EFECTUAR"
                    + "\n1-Voltar\n");
            Telemoves.setTelchamador(telchamador);
            GestaoTelemoves.typeReq(telchamador, tipodechamada, telchamodo);
            

        }else{
                    if(telchamodo.equals("1")){ 
                        MenudeGestaodoTelemovelNNN( telchamador,numerot);
                        }
                    else{ 
               JOptionPane.showMessageDialog(null, "O NÚMERO INSERIDO NÃO É REGISTRADO"); 
               estabelecer_ligacao(telchamador,numerot);
                            }
                }
                
        }else{  
                estabelecer_ligacao(telchamador, numerot);
                }
                
    }

    public static int paymentValue() {
        String a = "";
        int preso=0;
        a = JOptionPane.showInputDialog(""
                + " \n_______PAGAMENTO ________\n"
                + "INSIRA O VALOR DO PAGAMENTO"
                + "\n1-Voltar\n");
        if(a.equals("1")){
        
        }
            if(ErrosTelemoves.verifica(a)){ 
                Double convert = new Double(a);
                preso=convert.intValue();

            }else{
            
            }
        
        return preso;
    }

}
