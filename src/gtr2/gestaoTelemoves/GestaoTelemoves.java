package gtr2.gestaoTelemoves;

//import javax.swing.JOptionPane;
import gtr.GestaoClientes;
import gtr2.textui.client.Cliente;
import gtr2.textui.main.MenuEntry.Menugtr;
import gtr2.textui.main.Message.Messagens;
import gtr2.textui.mobile.Telemoves;
import gtr2.textui.mobile.UnknownKeyException.ErrosTelemoves;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisandro Pombo
 */
public class GestaoTelemoves {

    static String estado = "LIGADO";
    static int[] amigos = new int[90];
    static int[] telemove = new int[90];

    public static String mobileOn() {
        return GestaoTelemoves.estado = "LIGADO";
    }

    public static String mobileOff() {
        return GestaoTelemoves.estado = "DESLIGADO";
    }

    public static String mobileSilence() {
        return GestaoTelemoves.estado = "SILENCIO";
    }

    public static void registotm() {
        int[][] numerotm = new int[90][90];
        String[] chaveid = new String[90];
        String[][] estadopega = new String[90][90];
        String n = null;
        String c = null;
        int cont = 0;
        boolean log = true;

        if (Telemoves.getNumTm() > 0 && Cliente.getNumcli() > 0) {
            for (int i = 0; i < Cliente.getNumcli(); i++) {
                for (int j = 0; j < Telemoves.getNumTm(); j++) {
                    numerotm[i][j] = Telemoves.getChaveTm(i, j);
                    estadopega[i][j] = Telemoves.getEstadoTm(i, j);
                }
            }
        }
        while (log) {
            n = JOptionPane.showInputDialog(""
                    + " \n_______Registar [ registar novo telemóvel ] ________\n"
                    + "INSERIR O NUMERO  DO TELEMOVE"
                    + "\n1-Voltar\n");
            if (log = n.length() > 6 || log == n.length() < 6) {
                Messagens.numeromair();
            }
        }
        c = JOptionPane.showInputDialog(""
                + " \n_______[ IDENTIFICADOR ] ________\n"
                + "INSERIR O IDENTIFICADOR DO TELEMOVE(Clixxxao)"
                + "\n1-Voltar\n");
        if (ErrosTelemoves.verifica(n)) {
            Double convert = new Double(n);
            if (pesquisar_ChaveTm(convert.intValue()) && GestaoClientes.pesquisar_Chave(c)) {
                Messagens.duplicateMobile();
            }

            if (GestaoClientes.pesquisar_Chave(c)&& !pesquisar_ChaveTm(convert.intValue())) {
                for (int j = 0; j < 90; j++) {
                    if (Telemoves.getChaveTm(Cliente.getPosicao(), j) == 0) {

                        numerotm[Cliente.getPosicao()][j] = convert.intValue();
                        estadopega[Cliente.getPosicao()][j] = "LIGADO";

                        Telemoves.setChaveTm(numerotm);
                        cont = Telemoves.getNumTm() + 1;
                        Telemoves.setEstadoTm(estadopega);
                        Telemoves.setNumTm(cont);

                        break;
                    }
                }
            } else {
                if(!GestaoClientes.pesquisar_Chave(c))
                JOptionPane.showMessageDialog(null, "ESTE CLIENTE NÃO EXISTE");
            }
        }

        Menugtr.MenudeGestãodeTelemoveis();

    }

    public static void VisualizarTm() {
        String pegaTm = "", pegaamigo = "";
        int divid = 0;
        //TELEMOVEL|número|cliente| estado|saldo|telemóveisAmigos

        for (int i = 0; i < Cliente.getNumcli(); i++) {
            for (int j = 0; j < Telemoves.getNumTm(); j++) {
                if (Telemoves.getChaveTm(i, j) != 0) {
                    pegaTm = pegaTm + Telemoves.getChaveTm(i, j) + "\\";
                    pegaTm = pegaTm + Cliente.getChave(i) + "\\";
                    pegaTm = pegaTm + Telemoves.getEstadoTm(i, j) + "\\";
                    pegaTm = pegaTm + Telemoves.getSaldo(i, j) + "\\";
                    pegaTm = pegaTm + Telemoves.getAmigoTm(i, j) + "\\ \n";
                }

            }
        }

        String numerotm = JOptionPane.showInputDialog(""
                + " \n_______ VISULIZAÇÃO DOS NUMEROS ________\n"
                + "NUMEROS DE TELEMOVE REGISTRADOS\n"
                + pegaTm + "\n"
                + "1-Voltar\n");
        Menugtr.MenudeGestãodeTelemoveis();

    }

    //////DEVOLVE SE JÀ EXISTE E GUARDA A POSICAO
    public static boolean pesquisar_ChaveTm(int chaveTmdepesq) {
        if (chaveTmdepesq == 0) {
            JOptionPane.showMessageDialog(null, "INSIRA UM VALOR VALIDO");
            return false;
        } else {

            for (int i = 0; i <= Cliente.getNumcli(); i++) {
                for (int j = 0; j < Telemoves.getNumTm(); j++) {
                    if (Telemoves.getChaveTm(i, j) == chaveTmdepesq) {
                        Telemoves.setPosicao(i);
                        Telemoves.setPosicaoi(i);
                        Telemoves.setPosicaoj(j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean pesquisar_amigos(String chaveTmdepesq) {
        if (chaveTmdepesq == null || chaveTmdepesq.equals(" ")) {
            JOptionPane.showMessageDialog(null, "INSIRA UM VALOR VALIDO");
            return false;
        } else {
            for (int j = 0; j < Telemoves.getNumamigo(); j++) {
                if (Telemoves.getAmigoTm(Telemoves.getPosicaoi(), j).equals(chaveTmdepesq)) {
                    Telemoves.setPosicaoj(j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void gestaodeTmNN() {
    }

    public static void typeReq(int telchamador, String tipodechamada, String telchamado) {

        if (tipodechamada.equals("VOZ")) {
            Telemoves.setTipocham("VOZ");
            GestaoChamadas.chamadDeVoz(telchamador, tipodechamada, telchamado);
            

        } else if (tipodechamada.equals("SMS")) {
            Telemoves.setTipocham("SMS");

            GestaoChamadas.chamadDeSms(telchamador, tipodechamada, telchamado);
            
        } else{
            JOptionPane.showMessageDialog(null, "O TIPO DE CHAMADA INSERIDO É INVALIDA");
            String tipodechamad = JOptionPane.showInputDialog(""
                    + " \n_______POR FAVOR INSIRA UMA INVALIDA DESTA VEZ !________\n"
                    + "INFORMA O TIPO CHAMADA QUE PRETENDES EFECTUAR"
                    + "\n1-Voltar\n");
            if(tipodechamad.equals("1")){
            GestaodotelemovelNN.estabelecer_ligacao( telchamador, telchamador);
            }else{ 
            typeReq(telchamador, tipodechamad, telchamado);
            }
            
        }
        

    }

}
