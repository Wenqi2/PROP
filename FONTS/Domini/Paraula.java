package Domini;

import java.io.IOException;

/**
 * Classe feta per Joban
 */
public class Paraula {
    private String p;

    /**
     * @constructor  Crea una instancia de classe paraula buida.
     */
    public Paraula(){

    }

    public void exc(String s) throws Exception {
        System.out.println(s);
        throw new Exception();
    }

    /**
     *
     * @return Retorna una paruala assignada previament.
     */
    public String getParaula() {
        return p;
    }

    /**
     *
     * @param par Un string amb la paraula que es vol assignar.
     * @throws Exception Salta excepció si la paraula śe buida.
     */

    public void setParaula(String par) throws Exception{
        this.p = par;
    }

    /**
     * Imprimeix la paraula assignada.
     */
    public void imprimirParaula(){
        System.out.println(p);
    }

    public void error() throws Exception {
       throw new Exception();
    }
}