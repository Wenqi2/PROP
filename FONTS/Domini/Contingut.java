package Domini;


import java.util.ArrayList;
import Domini.Frase;

/**
 * Classe feta per Arnau
 */
public class Contingut {

    private ArrayList<Frase> contingut;
    private String text;
    //constructora base


    public void exc (String s) throws Exception {
        System.out.println(s);
        throw new Exception();
    }

    /**
     *
     * @constructor Crea una instancia de la clase Contingut
     */
    public Contingut () {
        contingut = new ArrayList<Frase>();
        text = new String();
    }

    /**
     *
     * @return Un string amb el contingut.
     */
    public String getStringContingut() {
        return text;
    }

    /**
     *
     * @return Un ArrayList amb el contingut separat en frases.
     */
    public ArrayList<Frase> getFrases() {
        return contingut;
    }

    /**
     *
     * @return True si el contingut esta buit.
     */
    public boolean buit() {
        return text.length() == 0;
    }

    /**
     *
     * @param nou passa a ser el nou contingut, es guarda com a string i es divideix per frases.
     * @throws Exception Si la divisio de frases es incorrecta.
     */
    //el parametre es el nou contingut
    public void modificarContingut(String nou) throws Exception {
        text = nou;
        contingut = new ArrayList<>();
        dividirText();
    }

    /**
     * Imprimeix el contingut.
     */
    public void imprimirContingutString() {
        System.out.println(text);
    }

    /**
     * separa el string en frases, i les afegeix al arraylist contingut.
     * @throws Exception Si la frase no es correcta.
     */
    private void dividirText() throws Exception {
        String[] partes = text.split("[[.]*|[!]*|[?]*]+");
        for(String s : partes) {
            Frase f = new Frase();
            f.setFraseCompleta(s);
            contingut.add(f);
        }
    }

}

