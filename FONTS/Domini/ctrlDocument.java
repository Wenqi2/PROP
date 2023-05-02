package Domini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;


/**
 * Classe feta per Arnau i Wenqi
 */
public class ctrlDocument {
    private static HashMap<Pair<String, String>, Document> Documents;

    /**
     * @constructor Torna un Document buit
     */
    //constructor
    public ctrlDocument() {
        Documents = new HashMap<Pair<String, String>, Document>();
    }

    /**
     *  Donar Alta un Document al conjut de document
     * @param titol titol del document
     * @param autor autor del document
     * @param contingut contingut del document
     * @throws Exception
     */

    /* __________OPERACIO___________ */
    public void altaDocument (String titol, String autor, Contingut contingut) throws Exception{
        Pair <String,String> id = new Pair<>(titol, autor);
        if(titol.length() < 1 || autor.length() < 1){
            System.out.println("El nom del titol i autor ha de tenir com minim un nombre");}
        else if (Documents.containsKey(id)) {
            System.out.println("Doc ya existeix");}
        else {
            Document d1 = new Document(titol, autor, contingut);
            Documents.put(id,d1);
            this.actualitzar_Totdocument();
        }
    }

    /**
     *  comprova si un document existeix
     * @param titol titol del document
     * @param autor autor del document
     * @return true si existeix
     */
    
    public boolean ExisteixDoc(String titol, String autor) {
        Pair <String,String> id = new Pair<>(titol, autor);
        return Documents.containsKey(id);
    }

    /**
     * dona d'alta un document buit
     * @param titol titol del document
     * @param autor autor del document
     * @throws Exception
     */
    public void altaDocumentBuit (String titol, String autor) throws Exception{
        Pair <String,String> id = new Pair<String,String>(titol, autor);
        if(titol.length() < 1 || autor.length() < 1){
            System.out.println("El nom del titol i autor ha de tenir com minim un nombre");}
        else if (Documents.containsKey(id)) {
            System.out.println("Document ja existeix");}
        else {
            Document d1 = new Document(titol, autor);
            Documents.put(id,d1);
        }
    }

    /**
     *  Eliminar un Document del conjut de Document
     * @param titol titol del document
     * @param autor autor del document
     * @throws Exception
     */
    public void bajaDocument(String titol, String autor) throws Exception{
        Pair <String,String> id = new Pair <>(titol, autor);
        if (!Documents.containsKey(id)) {
            System.out.println("Doc no existeix");
        } else {
            this.Documents.remove(id);
            this.actualitzar_Totdocument();
            System.out.println("--------------------------------");
            System.out.println("Document eliminat");
        }
    }

    /**
     * Modifica el Contingut de document
     * @param titol titol del document
     * @param autor autor del document
     * @param contingut que vol modificar
     */
    public void modifDocument (String titol, String autor, String contingut) throws Exception {
        Pair <String,String> id = new Pair (titol, autor);
        if (!Documents.containsKey(id)) System.out.println("Doc no existeix");
        else {

            this.Documents.get(id).modi_doc(contingut);
            ArrayList<Document> docs = this.getTotDocument();
            this.actualitzar_Totdocument();
        }
        return;
    }

    /**
     *Modifica el Autor de document
     * @param titol titol del document
     * @param autor autor del document
     * @param autornuevo nou autor del document
     */
    public void modifAutor(String titol, String autor, String autornuevo) {
        Pair <String,String> id = new Pair (titol, autor);
        if (!Documents.containsKey(id)) System.out.println("Doc no existeix");
        else {
            Document D = this.Documents.get(id);
            D.modi_autor(autornuevo);
            Documents.remove(id);
            Pair <String,String> Newid = new Pair (titol, autornuevo);
            Documents.put(Newid,D);
        }
        return;
    }

    /**
     * Modifica el titol de document
     * @param titol titol del document
     * @param autor autor del document
     * @param newtitol noe titol del document
     */
    public void modifTitol(String titol, String autor, String newtitol) {
        Pair <String,String> id = new Pair (titol, autor);
        if (!Documents.containsKey(id)) System.out.println("Doc no existeix");
        else {
            Document D = this.Documents.get(id);
            D.modi_Titol(newtitol);
            Documents.remove(id);
            Pair <String,String> Newid = new Pair (newtitol, autor);
            Documents.put(Newid,D);
        }
        return;
    }
    /**
     * Crear un Document amb un titol nova, pero amb mateix autor y contingut
     * @param titol titol del document
     * @param autor autor del document
     * @param newtitol nou titol del document
     * @throws Exception
     */
    public void copiarDocument(String titol, String autor, String newtitol) throws Exception {
        Domini.Pair<String,String> id = new Domini.Pair(titol, autor);
        if (!Documents.containsKey(id)) System.out.println("Document no existeix");
        else {
            Domini.Pair<String,String> id2 = new Domini.Pair(newtitol, autor);
            if (Documents.containsKey(id2)) System.out.println("Existeix un altre Document amb mateix Titol i Autor");
            else {
                Domini.Contingut c = this.Documents.get(id).getContingut();
                this.altaDocument(newtitol,autor,c);
            }
        }
        return;
    }

    /* __________CONSULTA___________ */

    /**
     *
     * @return El hashmap de Conjut de Documents
     */
    public HashMap<Pair<String,String>, Document> getMap (){
        return Documents;
    }

    /**
     * Torna un Document amb Id que has introduit, si el document no existeix tornara un document buit
     * @param titol titol del document
     * @param autor autor del document
     * @return Document amb Id que has introduit
     */
    public Document getDocument(String titol, String autor) {
        Pair <String,String> id = new Pair <String,String>(titol, autor);
        if (!Documents.containsKey(id)) {
            System.out.println("Document no existeix.");
            return new Document();
        }
        return Documents.get(id);
    }

    /**
     * Torna un Contingut amb Id que has introduit, si el document no existeix tornara un Contingut buit
     * @param titol titol del document
     * @param autor autor del document
     * @return Contingut del Document
     */
    public Contingut getContingut(String titol, String autor) {
        Pair <String,String> id = new Pair <String,String>(titol, autor);
        Contingut Conting = new Contingut();
        if (!Documents.containsKey(id)) {
            System.out.println("Document no existeix");
            return new Contingut();
        }
        Conting = Documents.get(id).getContingut();
        return Conting;

    }

    /**
     *
     * @return  Tots els Document en un ArrayList
     */
    public ArrayList<Document> getTotDocument(){
        ArrayList<Document> Docs = new ArrayList<Document> ();
        for(Pair<String,String> key : Documents.keySet()){
            Docs.add(Documents.get(key));
        }
        return Docs;
    }

    /**
     *
     * @return Tots els Id dels Documents
     */
    public ArrayList<Pair<String,String>> getTotKey() {
        ArrayList<Pair<String,String>> Keys = new ArrayList<Pair<String,String>> ();
        for(Pair<String,String> key : Documents.keySet()){
            Keys.add(key);
        }
        return Keys;
    }

    /**
     * Actualitza el vector de pesos de tots el documents registrat
     * @throws Exception
     */
    public void actualitzar_Totdocument() throws  Exception {
        ArrayList<Document> docs = this.getTotDocument();
        for(Pair<String,String> key : Documents.keySet()){
            Contingut contin = this.Documents.get(key).getContingut();
            this.Documents.get(key).actualitza_peso(contin,docs);
        }
    }

    /**
     *
     * @param autor es l'identificador sobre el que es fara la busqueda.
     * @return Una llista amb els noms dels titols que pertanyen al autor.
     */

    public ArrayList<String> titolsAutor(String autor) {
        ArrayList<String> titols = new ArrayList<String>();
        ArrayList<Pair<String, String>> identificadors = getTotKey();
        autor = autor.toLowerCase();
        int n = identificadors.size();
        for (int i = 0; i < n; ++i) {
            Pair<String, String> id = identificadors.get(i);
            String idAut = id.getSecond().toLowerCase();
            if (idAut.compareTo(autor) == 0) titols.add(id.getFirst());
        }
        return titols;
    }

    /**
     *
     * @param prefix sobre el que es buscaran els autors.
     * @return una llista amb els noms dels autors que comencen amb el prefix.
     */
    public ArrayList<String> autorsPrefix(String prefix) {
        ArrayList<String> autors = new ArrayList<String>();
        ArrayList<Pair<String, String>> identificadors = getTotKey();
        int n = identificadors.size();
        if (prefix != "") {
            prefix = prefix.toLowerCase();
            for (int i = 0; i < n; ++i) {
                Pair<String, String> id = identificadors.get(i);
                String autor = id.getSecond();
                autor = autor.toLowerCase();
                if (autor.startsWith(prefix) && !autors.contains(autor))
                    autors.add(autor);
            }
        } else {
            for (int i = 0; i < n; ++i) {
                Pair<String, String> id = identificadors.get(i);
                String autor = id.getSecond();
                if (!autors.contains(autor)) autors.add(autor);
            }
        }

        return autors;
    }

    /**
     *
     * @param exp  es l'expressio sobre la que es fara la busqueda
     * @return Una llista amb el titol i l'autor dels documents que compleixen la expressio booleana.
     * @throws Exception si la expressio booleana no es correcta, o hi ha errors al comparar amb el document.
     */
    public ArrayList<Pair<String, String>> busquedaBooleana(String exp) throws Exception {
        if (exp == "") throw new Exception("Escull una opció.");
        
        ExpressioBooleana exbool = new ExpressioBooleana(exp);
        if (exbool.expressioCorrecte()) {
            ArrayList<Pair<String, String>> docSatisfa = new ArrayList<Pair<String, String>>();
            ArrayList<Pair<String, String>> identificadors = getTotKey();
            int n = identificadors.size();
            for (int i = 0; i < identificadors.size(); ++i) {
                BSTree arbre = exbool.getArbre();
                Contingut c = new Contingut();
                Pair<String, String> par = identificadors.get(i);
                String titol = par.getFirst();
                String autor = par.getSecond();
                c = getContingut(titol, autor);
                if (exbool.getDocCompleix(c, arbre)) docSatisfa.add(par);
            }
            return docSatisfa;
        }
        return null;
    }

    /**
     *
     * @param titol titol del document a comparar
     * @param autor autor del document a comparar
     * @param k numero de documents que es volen
     * @return una llista amb k titols i autors, dels documents que mes s'assemblen al document donat.
     *         En cas d'empat es donaran els que s'han trobat abans.
     * @throws IOException Si hi ha problemes al comparar documents.
     */
    public ArrayList<Pair<String, String>> documentsSemblants(String titol, String autor, int k) throws IOException {
        Document d = getDocument(titol, autor);
        //System.out.println("he conseguido el documento con titulo: " + d.getTitol() + ", autor: "+ d.getAutor());
        ArrayList<Pair<Pair<String, String>, Double>> semblants = new ArrayList<Pair<Pair<String, String>, Double>>();
        VectorPesos vec = d.getVectorPes();
        //System.out.println(Documents.size());
        for (Pair<String, String> key : Documents.keySet()) {
            if (!(titol.compareTo(key.getFirst()) == 0 && autor.compareTo(key.getSecond()) == 0) && k > 0) {
                //System.out.println("he llegado aqui 0");
                double val = vec.similarityBetween(Documents.get(key).getVectorPes().getVpesos());
                //System.out.println("he llegado aqui 1");
                Pair<Pair<String, String>, Double> ind = new Pair<>();
                ind.setFirst(key);
                ind.setSecond(val);
                semblants.add(ind);
            }
            semblants = sortPes(semblants);

        }
        //System.out.println("he llegado aqui");
        ArrayList<Pair<String, String>> fin = new ArrayList<Pair<String, String>>();
        int n = 0;
        if ( k < semblants.size()) n = k;
        else n = semblants.size();
        for (int i = 0; i < n; ++i) {
            fin.add(semblants.get(i).getFirst());
        }
        return fin;
    }

    /**
     *
     * @param ar array que es vol ordenar.
     * @return el array ordenat segons el valor del pes.
     */
    public ArrayList<Pair<Pair<String, String>, Double>>  sortPes(ArrayList<Pair<Pair<String, String>, Double>>  ar) {
        return mergeSort(ar);
    }

    /**
     *
     * @param ar array que es vol ordenar.
     * @return el array ordenat segons el valor del pes.
     */
    private static ArrayList<Pair<Pair<String, String>, Double>>  mergeSort(ArrayList<Pair<Pair<String, String>, Double>>  ar)
    {
        if (ar.size() <= 1) return ar;

        ArrayList<Pair<Pair<String, String>, Double>>  left, right;
        left = new ArrayList<>();
        right = new ArrayList<>();

        for (int i = 0; i < ar.size(); i++)
        {
            if (i % 2 != 0) left.add(ar.get(i));
            else right.add(ar.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);

         return mergePes(left, right);
    }

    /**
     *
     * @param left part esquerra del array que es vol ordenar.
     * @param right part dreta del array que es vol ordenar.
     * @return el array ordenat segons el valor del pes.
     */
    private static ArrayList<Pair<Pair<String, String>, Double>>  mergePes(ArrayList<Pair<Pair<String, String>, Double>>  left, ArrayList<Pair<Pair<String, String>, Double>>  right)
    {
        ArrayList<Pair<Pair<String, String>, Double>> ret = new ArrayList<Pair<Pair<String, String>, Double>> ();

        while (!left.isEmpty() && !right.isEmpty())
        {
            if (left.get(0).getSecond() > right.get(0).getSecond())
            {
                ret.add(left.get(0));
                left.remove(0);
            }
            else
            {
                ret.add(right.get(0));
                right.remove(0);
            }
        }

        while (!left.isEmpty())
        {
            ret.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty())
        {
            ret.add(right.get(0));
            right.remove(0);
        }

        return ret;
    }
}