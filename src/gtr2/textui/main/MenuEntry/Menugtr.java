package gtr2.textui.main.MenuEntry;

import javax.swing.JOptionPane;
import gtr2.gestaoTelemoves.GestaoTelemoves;
import gtr.GestaoClientes;
import gtr2.gestaoTelemoves.ConsultarActividades;
import gtr2.textui.mobile.Telemoves;
import gtr2.gestaoTelemoves.GestaodotelemovelNN;
import gtr2.textui.mobile.UnknownKeyException.ErrosTelemoves;
import gtr2.textui.oneMobile.MenuEntry.MenudeEntradaTelemove;

/**
 *
 * @author Elisandro Pombo
 */
public class Menugtr {

    private static String opt;

    public static void Menugtr() {

        String e = JOptionPane.showInputDialog(""
                + " \n_________Menu Principal_________\n\n"
                + "1-Criar \n"
                + "2-Abrir \n"
                + "3-Guardar \n"
                + "4-Menu de Operação \n"
                + "5-SAIR\n");
        Menugtr.opt = e;

        switch (Menugtr.opt) {
            /////////////////////////////////////////////////////////
            case "1":
                //String fale1=criar(e);
                break;
            ////////////////////////////////////////////////////
            case "2":
                // String fale2=abrir(e);
                break;
            ////////////////////////////////////////////////////
            case "3":
                // String fale3=guardar(e);  
                break;
            /////////////////////////////////////////////////////
            case "4":
                menudeoperacao();
                break;
            case "5":

                break;

            default:
        }

    }

//Criar Ficheiro
    public String criar(String d) {
        String fale = JOptionPane.showInputDialog(""
                + " \n_________Criar Ficheiro_________\n\n"
                + "\n\n");

        return fale;
    }

    //Abrir Ficheir
    public String abrir() {
        String fale2 = null;

        return fale2;
    }

    //Guardar Ficheiro
    public String guardar() {
        String fale3 = JOptionPane.showInputDialog(""
                + " \n_________Guardar Ficheiro_________\n\n"
                + "\n\n");
        return fale3;
    }

    //Menu de Operação
    public static String menudeoperacao() {
        String OPTMOP = JOptionPane.showInputDialog(""
                + " \n__________________Menu de Operação ________________\n\n"
                + "1-Menu de Gestão de Clientes \n"
                + "2-Menu de Gestão de Telemóveis\n"
                + "3-Menu de Consultas \n"
                + "4-Ver Saldo Global\n"
                + "5-Menu de Gestão do Telemóvel NNNNNN\n"
                + "6-Voltar\n");
        switch (OPTMOP) {
            case "1":
                MenudeGestãodeClientes();
                break;

            case "2":
                MenudeGestãodeTelemoveis();
                break;

            case "3":
                MenudeConsultas();
                break;

            case "4":
                VerSaldoGlobal();
                break;
            case "5":
                  String n = JOptionPane.showInputDialog(""
                        + " \n_______INSIRA UM NÚMERO REGISTRADO ________\n"
                        + "INSERIR O NUMERO"
                        + "\n1-Voltar\n");
                int pega = 0;
                if(ErrosTelemoves.verifica(n)){  
                 Double convert = new Double(n);
                if (GestaoTelemoves.pesquisar_ChaveTm(convert.intValue())) {
                    pega = Telemoves.getChaveTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj());
                    MenudeGestaodoTelemovelNNN(pega,convert.intValue());
                }
                else {
                    if(n.equals("1")){ 
                   menudeoperacao();
                    }
                    else{ 
                    JOptionPane.showMessageDialog(null, "O NÚMERO INSERIDO NÃO É REGISTRADO");
                     MenudeGestãodeTelemoveis();}
                }
                
                }
                break;
            case "6":
                Menugtr();
                break;

            default:
                JOptionPane.showMessageDialog(null, "O PERAÇÃO INVALIDA");
                menudeoperacao();
        }
        return OPTMOP;
    }

    public static void MenudeGestãodeClientes() {
        String OP1 = JOptionPane.showInputDialog(""
                + " \n______________________Menu de Gestão de Clientes ______________________\n\n"
                + "1-Visualizar [visualizar todos os clientes] \n"
                + "2-Registar [registar novo cliente ] \n"
                + "3-Activar [ activar recepção de contactos falhados ]\n"
                + "4-Desactivar [ desactivar recepção de contactos falhados ] \n"
                + "5-Calcular saldo [ calcular o saldo referente a todos os telemóveis de um cliente ] \n"
                + "6-Voltar\n");
        switch (OP1) {
            case "1":
                GestaoClientes.visualizar();
                break;

            case "2":
                GestaoClientes.Registarcli();
                break;

            case "3":
                GestaoClientes.Activar();
                break;

            case "4":
                GestaoClientes.Desactivar();
                break;
                
                case "5":
                GestaoClientes.Calcularsaldo();
                break;
            case "6":
                menudeoperacao();
                break;

            default:
        }
    }

    public static void MenudeGestãodeTelemoveis() {
        String OP2 = JOptionPane.showInputDialog(""
                + " \n____________Menu de Gestão de Telemóveis _____________\n\n"
                + "1-Visualizar [ visualizar todos os telemóveis ] \n"
                + "2-Registar [ registar novo telemóvel ] \n"
                + "3-Gestão do telemóvel NNNNNN [ entrar no menu de gestão do telemóvel com o número NNNNNN ] \n"
                + "4-Voltar\n");

        switch (OP2) {
            case "1":
                GestaoTelemoves.VisualizarTm();
                break;

            case "2":
                GestaoTelemoves.registotm();
                break;

            case "3":
                 String n = JOptionPane.showInputDialog(""
                        + " \n_______INSIRA UM NÚMERO REGISTRADO ________\n"
                        + "INSERIR O NUMERO"
                        + "\n1-Voltar\n");
                int pega = 0;
                if(ErrosTelemoves.verifica(n)){  
                 Double convert = new Double(n);
                if (GestaoTelemoves.pesquisar_ChaveTm(convert.intValue())) {
                    pega = Telemoves.getChaveTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj());
                    MenudeGestaodoTelemovelNNN(pega,convert.intValue());
                }
                else {
                    if(n.equals("1")){ 
                   menudeoperacao();
                    }
                    else{ 
                    JOptionPane.showMessageDialog(null, "O NÚMERO INSERIDO NÃO É REGISTRADO");
                     MenudeGestãodeTelemoveis();}
                }
                
                }
                
                break;

            case "4":
                menudeoperacao();
                break;

            default:
                JOptionPane.showMessageDialog(null, "OPERAÇÃO INVALIDA");
                MenudeGestãodeTelemoveis();
        }
    }

    public static void MenudeConsultas() {
        String OP3 = JOptionPane.showInputDialog(""
                + " \n_____________Menu de Consultas _____________\n\n"
                + "1-Consultar todas as chamadas [informação relativa a chamadas ]\n"
                + "2-Consultar chamadas de um cliente [informação relativa a chamadas ]\n"
                + "3-Consultar telemóveis sem actividade [informação relativa a telemóveis ] \n"
                + "4-Consultar telemóveis com saldo positivo [ informação relativa a telemóveis ] \n"
                + "\n"
                + "5-Voltar\n");
        switch (OP3) {
            case "1":
                ConsultarActividades.Consultartodasaschamadas();
                break;
                
            case "2":
                ConsultarActividades.Consultarchamadasdeumcliente();
                break;

            case "3":
                ConsultarActividades.Consultartelemóveissemactividade();
                break;

            case "4":
                ConsultarActividades.Consultartelemóveiscomsaldopositivo();
                break;
            case "5":
                menudeoperacao();
                break;

            default:
                JOptionPane.showMessageDialog(null, "OPERAÇÃO INVALIDA");
                MenudeConsultas();
        }

    }

    public static void VerSaldoGlobal() {
       
        int pega=0;
                for(int i=0;i<Telemoves.getNumTm();i++)
                    for(int j=0;j<Telemoves.getNumTm();j++)
                        pega=pega+Telemoves.getSaldo(i, j);
                JOptionPane.showMessageDialog(null, pega, " SALDO GLOBAL DA GTR", 0);
             
               MenudeConsultas();
       
    }

    public static void MenudeGestaodoTelemovelNNN(int pego,int numerot) {
        String OP5 = MenudeEntradaTelemove.MenudeGestaodoTelemovelNNN(pego, numerot);

        switch (OP5) {
            case "1":
                GestaodotelemovelNN.Ligar_telemovel(pego,numerot);
                break;

            case "2":
                GestaodotelemovelNN.Colocar_telemovel_silencio(pego,numerot);
                break;

            case "3":
                GestaodotelemovelNN.Desligar_telemovel(pego,numerot);
                break;

            case "4":
                GestaodotelemovelNN.Adicionar_amigo(pego,numerot);
                break;

            case "5":
                GestaodotelemovelNN.Retirar_amigo(pego, numerot);
                break;

            case "6":
                GestaodotelemovelNN.Pagamento(pego, numerot);
                break;

            case "7":
                GestaodotelemovelNN.consutalsaldo(pego , numerot);

                break;

            case "8":
                GestaodotelemovelNN.estabelecer_ligacao(pego, numerot);
                break;
            case "9":
                menudeoperacao();
                break;

            default:
               JOptionPane.showMessageDialog(null, "OPERAÇÃO INVALIDA");
                MenudeGestaodoTelemovelNNN(pego,numerot);
        }
    }

}
