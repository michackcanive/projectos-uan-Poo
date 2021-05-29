/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtr2.textui.mobile;



/**
 *
 * @author Larval Stage
 */
public class Telemoves {
   private static String[][] estadoTm=new String[90][90];
   private static String[][] amigoTm=new String[90][90];
   private static int[][] chaveTm=new int[90][90];
   private static int[][] saldo =new int[90][90];
   private  static int posicao;
   private  static int posicaoj;
   private  static int posicaoi;
   private  static int contint;
   private  static int numamigo;
   private static String [][] activedade=new String[90][90];
   
   private  static String tipocham ;
   private  static String tipoestado;
   private  static int idculta;
   private  static int telchamador;
   private  static int telchamodo;
   private  static int custochamda;
    private  static int duracaoChamada;

    public static int getDuracaoChamada() {
        return duracaoChamada;
    }

    public static String getTipocham() {
        return tipocham;
    }

    public static String getTipoestado() {
        return tipoestado;
    }

    public static int getIdculta() {
        return idculta;
    }

    public static int getTelchamador() {
        return telchamador;
    }

    public static int getTelchamodo() {
        return telchamodo;
    }

    public static int getCustochamda() {
        return custochamda;
    }
   

    
    
    public static String getActivedade(int f,int g) {
        return activedade[f][g];
    }
  
     public static int getSaldo(int f,int g) {
        return saldo[f][g];
    }

    public static int getNumamigo() {
        return numamigo;
    }
     
      public static  String getEstadoTm(int f, int g) {
        return estadoTm[f][g];
    }

    public static int getChaveTm(int f,int g) {
        return chaveTm[f][g];
    }

    public static int getPosicao() {
        return posicao;
    }
     public static int getNumTm() {
        return contint;
    }

    public static int getPosicaoj() {
        return posicaoj;
    }

    public static int getPosicaoi() {
        return posicaoi;
    }

    public static String getAmigoTm(int f, int g) {
        return amigoTm[f][g];
    }
     
     
    //////////////////set
     
     
     public static void setActivedade(String[][] activedade) {
        Telemoves.activedade = activedade;
    }

    public static void setNumTm(int contint) {
        Telemoves.contint = contint;
    }
    public static void setSaldo(int[][] saldo) {
        Telemoves.saldo = saldo;
    }
    public static void setEstadoTm(String[][] estadoTm) {
        Telemoves.estadoTm = estadoTm;
    }

     public static void setChaveTm(int[][] chave) {
        Telemoves.chaveTm = chave;
    }

    public static void setPosicao(int posicao) {
       Telemoves.posicao = posicao;
    }

    public static void setPosicaoj(int posicaoj) {
        Telemoves.posicaoj = posicaoj;
    }

    public static void setPosicaoi(int posicaoi) {
        Telemoves.posicaoi = posicaoi;
    }

    public static void setAmigoTm(String[][] amigoTm) {
        Telemoves.amigoTm = amigoTm;
    }

    public static void setNumamigo(int numamigo) {
        Telemoves.numamigo = numamigo;
    }

    public static void setTipocham(String tipocham) {
        Telemoves.tipocham = tipocham;
    }

    public static void setTipoestado(String tipoestado) {
        Telemoves.tipoestado = tipoestado;
    }

    public static void setIdculta(int idculta) {
        Telemoves.idculta = idculta;
    }

    public static void setTelchamador(int telchamador) {
        Telemoves.telchamador = telchamador;
    }

    public static void setTelchamodo(int telchamodo) {
        Telemoves.telchamodo = telchamodo;
    }

    public static void setCustochamda(int custochamda) {
        Telemoves.custochamda = custochamda;
    }

    public static void setDuracaoChamada(int duracaoChamada) {
        Telemoves.duracaoChamada = duracaoChamada;
    }

   
    
}
