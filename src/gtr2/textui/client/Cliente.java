
package gtr2.textui.client;


/**
 *
 * @author Elisandro Pombo
 */
public class Cliente  {

   private static String[] nome=new String[90];
   private static String[] chave=new String[90];
   private static String[] tipocli=new String[90];
   private static String[] estado=new String[90];
   private static String[] registodeCont=new String[90];
   private static int contint;
   private static int posicao,a,b,c;
   
  

    public Cliente() {
       
    }

    public static int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static int getC() {
        return c;
    }

    
    public static String getTipocli(int g) {
        return tipocli[g];
    }

    public static void setTipocli(String[] tipocli) {
        Cliente.tipocli = tipocli;
    }
        
    
    
    public static int getPosicao() {
        return posicao;
    }

    
    
    public static String getNome(int f) {
        return nome[f];
    }

    public static String getChave(int f) {
        return chave[f];
    }

    public static String getEstado(int f) {
        return estado[f];
    }

    public static String getRegistodeCont(int f) {
        return registodeCont[f];
    }

  

    
/////////////////////////////SET
  

    

    public static void setRegistodeCont(String[] registodeCont) {
        Cliente.registodeCont = registodeCont;
    }

    public static void setNome(String[] nome) {
        Cliente.nome = nome;
    }

     public static void setChave(String[] chave) {
        Cliente.chave = chave;
    }

     public static void setEstado(String[] estado) {
        Cliente.estado = estado;
    }

     public static int getNumcli() {
        return contint;
    }

     public static void setNumcli(int contint) {
        Cliente.contint = contint;
    }

     public static void setPosicao(int posicao) {
        Cliente.posicao = posicao;
        
    }

    public static void setA(int a) {
        Cliente.a = a;
    }

    public static void setB(int b) {
        Cliente.b = b;
    }

    public static void setC(int c) {
        Cliente.c = c;
    }

   
   
}
