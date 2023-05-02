
package Domini;
import Domini.Paraula;
import java.util.ArrayList;

/**
 * Classe feta per Edgar
 */
public class Frase {
    private ArrayList<Paraula> frase; //Lista de paraules de la frase.
    private String fraseCompleta; //Contingut de la frase en String.

    public Frase() {
        frase = new ArrayList<Paraula>();
        fraseCompleta = "";
    }

    public ArrayList<Paraula> getFrase() {

        return frase;
    }

    /**
     *
     * @return torna la frase en forma de string
     */
    public String getFraseCompleta() {
        return fraseCompleta;
    }

    /**
     *
     * @param frase torna la frase en forma de ArrayList de paraulas
     */
    public void setFrase(ArrayList<Paraula> frase) {
        this.frase = frase;
    }

    /**
     *
     * @param fraseCompleta string que es vol que sigui la frase
     * @throws Exception
     */
    public void setFraseCompleta(String fraseCompleta) throws Exception {
        this.fraseCompleta = fraseCompleta;
        if (!fraseCompleta.isEmpty()) toArrayP();
    }

    /**
     * imprimeix la frase amb el string
     */
    public void imprimirFraseCompleta() {
        System.out.println(fraseCompleta);
    }

    /**
     * imprimeix la frase amb el ArrayList
     */
    public void imprimirFraseLLista() {
        for(Paraula p : frase) {
            p.imprimirParaula();
        }
    }

    /**
     *
     * @return torna la mida de la frase
     */
    public int getSize() {
        return frase.size();
    }

    /**
     *
     * @param p faraula a afegir a la frase
     */
    public void afegir(Paraula p) {
        frase.add(p);
        fraseCompleta += " ";
        fraseCompleta = fraseCompleta.concat(p.getParaula());
    }


    public void imprimir(){
        for (int i = 0 ; i < frase.size() ; ++i) {
            frase.get(i).imprimirParaula();
        }
    }

    /**
     *  transforma el string de la frase en el ArrayList de paraulas
     * @throws Exception
     */
    public void toArrayP() throws  Exception{
        String[] partes = fraseCompleta.split("[[ ]*|[,]*|[.]*|[:]*|[?!]*|[\n]*|[!]*|[?]*|[+]*]+");

        for(String s : partes) {
            s.replaceAll("[-(),!¿?¡;./|ªº{}<>=+*'%&¬#@:_\n ]", "");
            if(!s.equals(" ") && !s.equals("") && !s.equals(null) && !s.equals("\n")) {
                Paraula par = new Paraula();
                s.replace("\n","");
                par.setParaula(s);
                frase.add(par);
            }
        }
    }
}



