package gtr2.gestaoTelemoves;

import gtr2.textui.client.Cliente;
import gtr.GestaoClientes;
import gtr2.textui.main.MenuEntry.Menugtr;
import gtr2.textui.mobile.Telemoves;
import gtr2.textui.mobile.UnknownKeyException.ErrosTelemoves;
import javax.swing.JOptionPane;

public class GestaoChamadas {
    
    

    public static void chamadDeVoz(int telchamodor, String tipodechamada, String amigo) {
        
            Double aux1 = new Double(amigo);
        if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("DESLIGADO")) {
            
            JOptionPane.showMessageDialog(null, " O TELEFONE " + aux1.intValue() + " QUE PRETENDES CONTACTAR ESTA DESLIGADO");
            Telemoves.setDuracaoChamada(0);
        } else if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("SILENCIO")) {
            
            JOptionPane.showMessageDialog(null, " O TELEFONE " + aux1.intValue() + " QUE PRETENDES CONTACTAR ESTA EM SILENCIO MAIS PODES ENVIAR SMS");
                        
            

        } else if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("LIGADO"))
        {
            String c = "";
            c = JOptionPane.showInputDialog(""
                    + " \n_______DURAÇÃO DA CHAMADA DE VOZ ________\n"
                    + "INSIRA A DURAÇÃO DA CHAMADA"
                    + "\n1-Voltar\n");
            if(ErrosTelemoves.verifica(c)){
                Double aux = new Double(c); 
            Telemoves.setTipoestado("EFECTIVO");
            Telemoves.setTelchamador(telchamodor);
            timeReq(aux.intValue(),telchamodor, amigo);
            }else{
            JOptionPane.showMessageDialog(null, "INSIRA DURAÇÃO VALIDO POR FAVOR ");
            chamadDeVoz( telchamodor,tipodechamada,  amigo);
            
            }
            
           
            
            

        }

    }

    public static void chamadDeSms(int telchamodor, String tipodechamada, String amigo) {
        
        
         Double aux1 = new Double(amigo);
        if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("DESLIGADO")) {
            
            JOptionPane.showMessageDialog(null, " O TELEFONE " + aux1.intValue() + " QUE PRETENDES CONTACTAR ESTA DESLIGADO");
            Telemoves.setDuracaoChamada(0);
        } 
        else if (Telemoves.getEstadoTm(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()).equals("LIGADO"))
        {
            String c = "";
            c = JOptionPane.showInputDialog(""
                    + " \n_______INSIRA O TEXTO PARA SER ENVIADO  ________\n"
                    + "INVIAR O TEXTO"
                    + "\n1-Voltar\n");
            
             
            Telemoves.setTipoestado("EFECTIVO");
            Telemoves.setTelchamador(telchamodor);
            charRq(c,telchamodor,amigo);
            
            
           
            
            

        }

        
        
        

    }

    public static void timeReq(int tempo, int telchamodor, String telchamado) {

        int result = 0;
        int custo=0;
        int[][] pegaSaldo = new int[40][40];

        if (GestaoTelemoves.pesquisar_ChaveTm(telchamodor)) {

            if (GestaoTelemoves.pesquisar_amigos(telchamado)) {

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientNormal())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * (20 / 2);
                    custo=tempo*20/2;
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientGold())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * (10 / 2);
                    custo=tempo * (10 / 2);
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientPlatine())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * (10 / 2);
                    custo=tempo * (10 / 2);
                }

            } else {

                if (Cliente.getTipocli(Telemoves.getPosicaoi()).equals(GestaoClientes.clientNormal())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * 20;
                     custo=tempo * 20;
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientGold())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * 10;
                    custo=tempo*10;
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientPlatine())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * 10;
                    custo=tempo*10;
                }
            }
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    pegaSaldo[i][j] = Telemoves.getSaldo(i, j);
                }
            }

            int cont = result + Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj());

            pegaSaldo[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] = result;
            if (Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) == 0 || Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) < 0) {
                JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE PARA FAZER A CHAMADA DE VOZ");
            } else {
                //if(cont<result+Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj())
                
                 Telemoves.setSaldo(pegaSaldo);
                JOptionPane.showMessageDialog(null, "CHAMADA FEITA COM SUCESSO");
                 costofMessage(custo);
                 
                 Double aux1=new Double(telchamado);
                
                Telemoves.setDuracaoChamada(tempo);
                Telemoves.setCustochamda(custo);
                Telemoves.setTelchamodo(aux1.intValue());
                Telemoves.setTipocham("VOZ");
                 Telemoves.setIdculta(1);
           
                //GTNN-estabelecer_ligacao-Telemoves.setTelchamador()
                String agrupa=""; 
               String[][] carrga=new String[90][90];
               
                for(int i=0;i<20;i++){
                    for(int j=0;Telemoves.getActivedade(i, j)!=null;j++){
                        String[] pega1 = Telemoves.getActivedade(i, j).split("/");
                        Double convert= new Double(pega1[2]);
                        Double convert1= new Double(pega1[3]);
                        Double convert2= new Double(pega1[1]);
                        
                        
                        if( convert.intValue()==Telemoves.getTelchamador()&&convert1.intValue()==Telemoves.getTelchamodo()){
                            Telemoves.setIdculta(convert2.intValue()+1);
                          
                        }
                    }
                }
               
                //CARREGA IMFORMACOES
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        carrga[i][j]=Telemoves.getActivedade(i, j);
                    }
                }
                
                           
                            
                         agrupa=agrupa+"/"+Telemoves.getIdculta()+"/"+Telemoves.getTelchamador()+"/"
                        +Telemoves.getTelchamodo()+"/"+Telemoves.getTipocham()+"/"
                        +Telemoves.getDuracaoChamada()+"/"+Telemoves.getCustochamda()+"/"
                        +Telemoves.getTipoestado();
                
                    if(GestaoTelemoves.pesquisar_ChaveTm(Telemoves.getTelchamador())){
                        for(int i=0;i<20;i++){
                            if(Telemoves.getActivedade(Telemoves.getPosicaoj(), i)==null){
                            carrga[Telemoves.getPosicaoj()][i]=agrupa;
                            break;}
                }
                    }
                    System.out.println(" Actividade "+ agrupa);
                Telemoves.setActivedade(carrga);
                Menugtr.MenudeGestaodoTelemovelNNN(telchamodor,telchamodor);
 
                //carrega aque  
            }
            }

        
        else{
            if(!GestaoTelemoves.pesquisar_ChaveTm(Telemoves.getTelchamador()))
        JOptionPane.showMessageDialog(null, "ESTE NUMERO NÃO PERTENCE NO SISTEMA");}
    }
    //DESCONTO DE MENSAGENS
    public static void charRq(String tamanho, int telchamodor, String telchamado) {
        
        
        int result = 0;
        int custo=0;
        int[][] pegaSaldo = new int[40][40];
        int tempo=tamanho.length();

        if (GestaoTelemoves.pesquisar_ChaveTm(telchamodor)) {

            if (GestaoTelemoves.pesquisar_amigos(telchamado)) {

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientNormal())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * (20 / 2);
                    custo=tempo*20/2;
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientGold())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * (10 / 2);
                    custo=tempo * (10 / 2);
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientPlatine())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * (10 / 2);
                    custo=tempo * (10 / 2);
                }

            } else {

                if (Cliente.getTipocli(Telemoves.getPosicaoi()).equals(GestaoClientes.clientNormal())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * 20;
                     custo=tempo * 20;
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientGold())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * 10;
                    custo=tempo*10;
                }

                if (Cliente.getTipocli(Cliente.getPosicao()).equals(GestaoClientes.clientPlatine())) {
                    result = Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) - tempo * 10;
                    custo=tempo*10;
                }
            }
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    pegaSaldo[i][j] = Telemoves.getSaldo(i, j);
                }
            }

            int cont = result + Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj());

            pegaSaldo[Telemoves.getPosicaoi()][Telemoves.getPosicaoj()] = result;
            if (Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) == 0 || Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj()) < 0) {
                JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE PARA FAZER O ENVIU DA SMS ");
            } else {
                //if(cont<result+Telemoves.getSaldo(Telemoves.getPosicaoi(), Telemoves.getPosicaoj())
                
                 Telemoves.setSaldo(pegaSaldo);
                JOptionPane.showMessageDialog(null, "SMS ENVIADA COM SUCESSO");
                 costofMessage(custo);
                 Double aux1=new Double(telchamado);
                
                Telemoves.setDuracaoChamada(tempo);
                Telemoves.setCustochamda(custo);
                Telemoves.setTelchamodo(aux1.intValue());
                Telemoves.setTipocham("SMS");
                 Telemoves.setIdculta(1);
           
                //GTNN-estabelecer_ligacao-Telemoves.setTelchamador()
                String agrupa=""; 
               String[][] carrga=new String[90][90];
               
                for(int i=0;i<20;i++){
                    for(int j=0;Telemoves.getActivedade(i, j)!=null;j++){
                        String[] pega1 = Telemoves.getActivedade(i, j).split("/");
                        Double convert= new Double(pega1[2]);
                        Double convert1= new Double(pega1[3]);
                        Double convert2= new Double(pega1[1]);
                        
                        
                        if( convert.intValue()==Telemoves.getTelchamador()&&convert1.intValue()==Telemoves.getTelchamodo()){
                            Telemoves.setIdculta(convert2.intValue()+1);
                          
                        }
                    }
                }
               
                //CARREGA IMFORMACOES
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        carrga[i][j]=Telemoves.getActivedade(i, j);
                    }
                }
                
                           
                            
                         agrupa=agrupa+"/"+Telemoves.getIdculta()+"/"+Telemoves.getTelchamador()+"/"
                        +Telemoves.getTelchamodo()+"/"+Telemoves.getTipocham()+"/"
                        +Telemoves.getDuracaoChamada()+"/"+Telemoves.getCustochamda()+"/"
                        +Telemoves.getTipoestado();
                
                    if(GestaoTelemoves.pesquisar_ChaveTm(Telemoves.getTelchamador())){
                        for(int i=0;i<20;i++){
                            if(Telemoves.getActivedade(Telemoves.getPosicaoj(), i)==null){
                            carrga[Telemoves.getPosicaoj()][i]=agrupa;
                            break;}
                }
                    }
                 System.out.println(" Actividade "+ agrupa);
                Telemoves.setActivedade(carrga);
                Menugtr.MenudeGestaodoTelemovelNNN(telchamodor,telchamodor);
 
                //carrega aque  
            }
            }

        
        else{
            if(!GestaoTelemoves.pesquisar_ChaveTm(Telemoves.getTelchamador()))
        JOptionPane.showMessageDialog(null, "ESTE NUMERO NÃO PERTENCE NO SISTEMA");}
        

    }

    public static  void costofMessage(int duracao) {
      JOptionPane.showMessageDialog(null, "O CUSTO FOI DE "+duracao);
        
   }

}
