package Domini;

import java.util.*;
import javax.swing.DefaultListModel;

/**
 * Classe feta per Joban
 */
public class ctrlExpressio {

    private ArrayList<String> cjtExp;

    /**
     * @constructor  Crea una instància de la classe ctrlExpressió buida.
     */
    public ctrlExpressio() {
        cjtExp = new ArrayList<String>();
    }
    
    public ctrlExpressio(ArrayList<String> a) {
        this.cjtExp = a;
    }
    
    /**
     *
     * @return Retorna l'arraylist amb el cjt d'expressions guardades.
     */
    public ArrayList<String> getArrayExp() {
        return cjtExp;
    }
    
    public void exc(String s) throws Exception {
        //System.out.println(s);
        throw new Exception(s);
    }

    /**
     * Agageix una expressió.
     * @param exp String amb l'expressió a afegir.
     */
    public void afageixExp(String exp) throws Exception{
      if (exp.isEmpty()) exc("Expressio buida");
      else {
          int mida = cjtExp.size();
          Boolean t = false;
          //ExpressioBooleana e;
          String s;
          for (int i = 0; i < mida; i++) {            
              s = cjtExp.get(i);
              //if (exp.compareTo(s) == 1) {
              if (exp.contentEquals(s)) {
                  t = true;
                  //System.out.println("--------------------------------");
                  exc("Expressio a inserir ja existeix");
                  //throw new Exception("prueba");
              }
          }

          if (!t) {
              cjtExp.add(exp);
              //System.out.println("--------------------------------");
              //System.out.println("Expressio guardada correctament");
          }
      }
    }

    /**
     * Elimina una expressió guardada.
     * @param i Índex de l'expressió a eliminar.
     */
    public void eliminaExp(int i)throws Exception {
        if (i == -1) exc("Escull una expressió");
        else {
            cjtExp.remove(i);
            //System.out.println("--------------------------------");
            //System.out.println("Expressio elimiada");
        }

    }

    /**
     * Modifica una expressió guardada.
     * @param in Índex de l'expressió a modificar.
     * @param e1 String amb l'expressió substituta.
     */
    public void modificaExp(int in, String e1) throws Exception{
        if (in == -1) exc("Escull una expressió");
        cjtExp.set(in, e1);
        //System.out.println("--------------------------------");
        //System.out.println("Expressio modificada");
    }
    
    
    /**
     * Imprimeix les expressions guardades
     */
    public void imprimeixExp() {
       int mida = cjtExp.size();
       int i = 0;
       String s = "";
       while (i < mida) {
           s = cjtExp.get(i);
           System.out.println(i+1 + ". " + s);
           i++;
       }
    }

    /**
     * Aconseguir l'expressió amb l'índex i.
     * @param i Índex de l'expressió que es vol obtenir
     * @return Retorna un string amb l'expressió guardada a l'índex i.
     */
    public String getExpressio(int i) {
        String s ="";
        if (i >= cjtExp.size() || i < 0) System.out.println("Número incorrecto");
        else s = cjtExp.get(i);
        return s;
    }
    
    //___________visatas________________
    
    public DefaultListModel vistaimprimeixExp() {
      DefaultListModel listModel = new DefaultListModel();
      int mida = cjtExp.size();
      for (int i = 0; i < mida; i++) {
          listModel.addElement(cjtExp.get(i));
      }
      return listModel;
    }
    
    /*
    public void modificaExp(String mod, String select) {
        int mida = cjtExp.size();
        //System.out.println(mida);
        for (int i = 0; i < mida; i++) {
            String s = cjtExp.get(i);
            System.out.println("select: " + select + " cjt: " + s);
            if (select.compareTo(s) == 1) {
                cjtExp.set(i, mod);
                System.out.println("he entrado aqui");
            }
        }
    }
    */
    /*
    public void eliminaExp(String select) {
        int mida = cjtExp.size();
        for (int i = 0; i < mida; i++) {
            String s = cjtExp.get(i);
            //System.out.println("select: " + select + " cjt: " + s);
            if (select.compareTo(s) == 1) {
                cjtExp.remove(i+1);
                //cjtExp.remove(s);
            
                //System.out.println("he entrado aqui");
            }
        }
    }
    */

}
