package Domini;

import Persistencia.ctrlPersistencia;
import Presentacio.CtrlPresentacio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.print.Doc;
import javax.swing.DefaultListModel;


/**
 * Classe feta per Arnau i Wenqi
 */
public class CtrlDomini {
    private ctrlDocument ctrlDocument;
    private ctrlPersistencia persistencia;
    private ctrlExpressio ctrlExpressio;
    private static DefaultListModel listModel;

    /**
     * @constructor Crear un Control Domini buit
     */
    public CtrlDomini() {
        this.ctrlDocument = new ctrlDocument();
        //this.ctrlExpressio = new ctrlExpressio();
        this.persistencia = new ctrlPersistencia();
        try{
            this.carregaIni();
        }catch(Exception ex){

        }
    }
    //-------------------------------------------------------------------------------
    // FUNCIONES DE DOCUMENTOS

    /**
     * Registra un Document al sistema
     *
     * @param titol titol del document
     * @param autor autor del document
     * @param contingut contingut del document
     * @throws Exception
     */
    public void altaDocument(String titol, String autor, Contingut contingut) throws Exception {
        ctrlDocument.altaDocument(titol, autor, contingut);
        persistencia.insereixFitxer(titol,autor,contingut.getStringContingut());

    }

    /**
     *
     * @param titol titol del document
     * @param autor autor del document
     * @throws Exception
     */
    public void altaDocumentBuit(String titol, String autor) throws Exception {
        ctrlDocument.altaDocumentBuit(titol, autor);
    }

    /**
     *
     * @param titol titol del document
     * @param autor autor del document
     * @param contingut contingut del document
     * @throws Exception
     */
    public void altaDocument (String titol, String autor, String contingut) throws Exception {
        Contingut c = this.StringToContingut(contingut);

        ctrlDocument.altaDocument(titol, autor, c);
        persistencia.insereixFitxer(titol,autor,contingut);
    }

    /**
     * Eliminar un Document del sistema
     *
     * @param titol titol del document
     * @param autor autor del document
     * @throws Exception
     */
    public void bajaDocument(String titol, String autor) throws Exception {
        ctrlDocument.bajaDocument(titol, autor);
        persistencia.eliminaFitxer(titol,autor);
    }

    /**
     * Modifica el Contingut de document amb mateix Titol i Autor
     *
     * @param titol titol del document
     * @param autor autor del document
     * @param contingut contingut del document
     * @throws Exception
     */
    public void modifDocument(String titol, String autor, String contingut) throws Exception {
        persistencia.eliminaFitxer(titol,autor);
        persistencia.insereixFitxer(titol,autor,contingut);
        carregaDoc(titol, autor);
        ctrlDocument.modifDocument(titol, autor, contingut);

    }

    /**
     * Modifica el Autor de document amb mateix Titol i Autor
     *
     * @param titol titol del document
     * @param autor autor del document
     * @param autornuevo nou autor del document
     */
    public void modifAutor(String titol, String autor, String autornuevo) throws IOException {
        String zz=ctrlDocument.getContingut(titol,autor).getStringContingut();
        ctrlDocument.modifAutor(titol, autor, autornuevo);
        persistencia.eliminaFitxer(titol,autor);
        persistencia.insereixFitxer(titol,autornuevo,zz);
    }

    /**
     * Modifica el Titol de document amb mateix Titol i Autor
     *
     * @param titol titol del document
     * @param autor autor del document
     * @param newtitol nou document del titol
     */
    public void modifTitol(String titol, String autor, String newtitol) throws IOException {
        String zz=ctrlDocument.getContingut(titol,autor).getStringContingut();
        ctrlDocument.modifTitol(titol, autor, newtitol);
        persistencia.eliminaFitxer(titol,autor);
        persistencia.insereixFitxer(newtitol,autor,zz);

    }

    /**
     * Crear un Document amb un titol nova, pero amb mateix autor y contingut
     *
     * @param titol titol del document
     * @param autor autor del document
     * @param newTitol nou titol del document
     * @throws Exception
     */
    public void copiarDocument(String titol, String autor, String newTitol) throws Exception {
        carregaDoc(titol,autor);
        ctrlDocument.copiarDocument(titol, autor, newTitol);
        persistencia.insereixFitxer(newTitol,autor,ctrlDocument.getContingut(titol,autor).getStringContingut());

    }

    /**
     * @return Control del Document
     */
    public ctrlDocument getCtrlDocument() {
        return ctrlDocument;
    }
    //-----------------------------------------------------------------

    //BUSQUEDAS DE DOCUMENTS

    /**
     * @param titol titol del document sobre el que es buscara.
     * @param autor autor del document sobre el que es buscara.
     * @return El contingut del document escollit
     * @throws Exception Si del document no existeix
     */
    public Contingut getContingut(String titol, String autor) throws Exception {
        carregaDoc(titol,autor);
        return ctrlDocument.getContingut(titol, autor);
    }
    public Contingut StringToContingut (String contingut) throws Exception {
        Contingut c = new Contingut();
        c.modificarContingut(contingut);
        return c;
    }


    /**
     * @param autor autor sobre el que es fa la busqueda.
     * @return Una llista amb els titols del autor escollit.
     */
    public ArrayList<String> titolsDeAutor(String autor) {
        return ctrlDocument.titolsAutor(autor);
    }

    /**
     * @param prefix prefix sobre el que es fara la busqueda.
     * @return Una llista amb els autors que comencen amb el prefix donat.
     */
    public ArrayList<String> AutorsPerPrefix(String prefix) {
        return ctrlDocument.autorsPrefix(prefix);
    }

    /**
     * @param exp expressio sobre la que es fara la busqueda.
     * @return Una llista amb els titols i els autors dels documents que compleixen la expressio booleana.
     * @throws Exception si la expressio no es correcta.
     */
    public ArrayList<Pair<String, String>> busquedaPerBool(String exp) throws Exception {
        ArrayList<Pair<String,String>> a = ctrlDocument.getTotKey();
        //System.out.println("exp:"+exp);
        for (int i = 0; i < a.size(); ++i) {
            //System.out.println("doc:"+a.get(i).getFirst()+" "+a.get(i).getSecond());

            carregaDoc(a.get(i).getFirst(), a.get(i).getSecond());
        }
        return ctrlDocument.busquedaBooleana(exp);
    }

    /**
     * @param titol titol del document sobre el que es fara la busqueda.
     * @param autor autor del document sobre el que es fara la busqueda.
     * @param k     numero de documents que es vol.
     * @return Una llista amb els titols i els autors dels k documents mes semblants a el document donat,
     * Si hi ha empats anira abans el primer que s'ha comparat.
     * @throws IOException Si hi ha errors al comparar continguts.
     */
    public ArrayList<Pair<String, String>> documentsSimilars(String titol, String autor, int k) throws Exception {
        ArrayList<Pair<String,String>> a = ctrlDocument.getTotKey();
        for (int i = 0; i < a.size(); ++i) {
            carregaDoc(a.get(i).getFirst(), a.get(i).getSecond());
            
        }
        return ctrlDocument.documentsSemblants(titol, autor, k);
    }

    /* __________SORT___________*/

    /**
     * @param ar array que es vol ordenar
     * @return El array ordenat ascendentment pel titol.
     */
    public ArrayList<Pair<String, String>> sortTitolAsc(ArrayList<Pair<String, String>> ar) {
        return mergeSort(ar, 1);
    }

    /**
     * @param ar array que es vol ordenar
     * @return El array ordenat descendentment pel titol.
     */
    public ArrayList<Pair<String, String>> sortTitoldesc(ArrayList<Pair<String, String>> ar) {
        return mergeSort(ar, 2);
    }

    /**
     * @param ar array que es vol ordenar
     * @return El array ordenat ascendentment pel autor.
     */
    public ArrayList<Pair<String, String>> sortAutorAsc(ArrayList<Pair<String, String>> ar) {
        return mergeSort(ar, 3);
    }

    /**
     * @param ar array que es vol ordenar
     * @return El array ordenat descendentment pel autor.
     */
    public ArrayList<Pair<String, String>> sortAutordesc(ArrayList<Pair<String, String>> ar) {
        return mergeSort(ar, 4);
    }

    /**
     * @param ar   array que es vol ordenar.
     * @param tipo tipus d'ordre que es vol conseguir.
     * @return el array ordenat segons el tipus que s'hagi demanat.
     */
    private static ArrayList<Pair<String, String>> mergeSort(ArrayList<Pair<String, String>> ar, int tipo) {
        if (ar.size() <= 1) return ar;

        ArrayList<Pair<String, String>> left, right;
        left = new ArrayList<>();
        right = new ArrayList<>();

        for (int i = 0; i < ar.size(); i++) {
            if (i % 2 != 0) left.add(ar.get(i));
            else right.add(ar.get(i));
        }

        left = mergeSort(left, tipo);
        right = mergeSort(right, tipo);

        if (tipo == 1) return mergeTitAsc(left, right);
        else if (tipo == 2) return mergeTitDesc(left, right);
        else if (tipo == 3) return mergeAutAsc(left, right);
        else if (tipo == 4) return mergeAutDesc(left, right);
        else return mergeTitAsc(left, right);
    }

    /**
     * @param left  part esquerra del array a ordenar.
     * @param right part dreta del array a ordenar.
     * @return El array ordenat ascendentment pel titol.
     */
    private static ArrayList<Pair<String, String>> mergeTitAsc(ArrayList<Pair<String, String>> left, ArrayList<Pair<String, String>> right) {
        ArrayList<Pair<String, String>> ret = new ArrayList<Pair<String, String>>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).getFirst().compareTo(right.get(0).getFirst()) < 0) {
                ret.add(left.get(0));
                left.remove(0);
            } else if (left.get(0).getFirst().compareTo(right.get(0).getFirst()) > 0) {
                ret.add(right.get(0));
                right.remove(0);
            } else {
                if (left.get(0).getSecond().compareTo(right.get(0).getSecond()) < 0) {
                    ret.add(left.get(0));
                    left.remove(0);
                } else {
                    ret.add(right.get(0));
                    right.remove(0);
                }
            }
        }

        while (!left.isEmpty()) {
            ret.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty()) {
            ret.add(right.get(0));
            right.remove(0);
        }

        return ret;
    }

    /**
     * @param left  part esquerra del array a ordenar.
     * @param right part dreta del array a ordenar.
     * @return El array ordenat descendentment pel titol.
     */
    private static ArrayList<Pair<String, String>> mergeTitDesc(ArrayList<Pair<String, String>> left, ArrayList<Pair<String, String>> right) {
        ArrayList<Pair<String, String>> ret = new ArrayList<Pair<String, String>>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).getFirst().compareTo(right.get(0).getFirst()) > 0) {
                ret.add(left.get(0));
                left.remove(0);
            } else if (left.get(0).getFirst().compareTo(right.get(0).getFirst()) < 0) {
                ret.add(right.get(0));
                right.remove(0);
            } else {
                if (left.get(0).getSecond().compareTo(right.get(0).getSecond()) > 0) {
                    ret.add(left.get(0));
                    left.remove(0);
                } else {
                    ret.add(right.get(0));
                    right.remove(0);
                }
            }
        }

        while (!left.isEmpty()) {
            ret.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty()) {
            ret.add(right.get(0));
            right.remove(0);
        }

        return ret;
    }

    /**
     * @param left  part esquerra del array a ordenar.
     * @param right part dreta del array a ordenar.
     * @return El array ordenat ascendentment pel autor.
     */
    private static ArrayList<Pair<String, String>> mergeAutAsc(ArrayList<Pair<String, String>> left, ArrayList<Pair<String, String>> right) {
        ArrayList<Pair<String, String>> ret = new ArrayList<Pair<String, String>>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).getSecond().compareTo(right.get(0).getSecond()) < 0) {
                ret.add(left.get(0));
                left.remove(0);
            } else if (left.get(0).getSecond().compareTo(right.get(0).getSecond()) > 0) {
                ret.add(right.get(0));
                right.remove(0);
            } else {
                if (left.get(0).getFirst().compareTo(right.get(0).getFirst()) < 0) {
                    ret.add(left.get(0));
                    left.remove(0);
                } else {
                    ret.add(right.get(0));
                    right.remove(0);
                }
            }
        }

        while (!left.isEmpty()) {
            ret.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty()) {
            ret.add(right.get(0));
            right.remove(0);
        }

        return ret;
    }

    /**
     * @param left  part esquerra del array a ordenar.
     * @param right part dreta del array a ordenar.
     * @return El array ordenat descendentment pel autor.
     */
    private static ArrayList<Pair<String, String>> mergeAutDesc(ArrayList<Pair<String, String>> left, ArrayList<Pair<String, String>> right) {
        ArrayList<Pair<String, String>> ret = new ArrayList<Pair<String, String>>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).getSecond().compareTo(right.get(0).getSecond()) > 0) {
                ret.add(left.get(0));
                left.remove(0);
            } else if (left.get(0).getSecond().compareTo(right.get(0).getSecond()) < 0) {
                ret.add(right.get(0));
                right.remove(0);
            } else {
                if (left.get(0).getFirst().compareTo(right.get(0).getFirst()) > 0) {
                    ret.add(left.get(0));
                    left.remove(0);
                } else {
                    ret.add(right.get(0));
                    right.remove(0);
                }
            }
        }

        while (!left.isEmpty()) {
            ret.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty()) {
            ret.add(right.get(0));
            right.remove(0);
        }

        return ret;
    }

    /**
     * carrega un document de la capa de persistencia
     * @param titol titol del document a carregar
     * @param autor autor del document a carregar
     * @throws Exception
     */
    public void carregaDoc(String titol, String autor) throws Exception {
        if (!ctrlDocument.getDocument(titol, autor).getCarregat()) {
            String cont = persistencia.getContentFitxer(titol,autor);
            ctrlDocument.modifDocument(titol, autor, cont);
        }

    }

    /**
     *
     * @param titol titols del document
     * @param autor autor del document
     * @return torna true si el document ja existeix
     */
    public boolean ExisteixDoc(String titol, String autor) {
        return ctrlDocument.ExisteixDoc(titol, autor);
    }

    /**
     * importa el fitxer File
     * @param file fitxer a importar
     * @param path path del fitxer
     * @throws Exception
     */
    public void importar(File file, String path) throws Exception {
        Pair<String,String> id = persistencia.importarFitxer(file,path);
        ctrlDocument.altaDocumentBuit(id.getFirst(),id.getSecond());
    }

    /**
     * exporta un document
     * @param titul nou titol del document
     * @param autor autor del document
     * @param nomDocExportat nom del document
     * @param path path del document
     * @param format dormat del document
     * @throws IOException
     */
    public void exportar(String titul, String autor, String nomDocExportat, String path, String format) throws IOException {
        ctrlPersistencia pers = new ctrlPersistencia();
        pers.exportarFitxer(titul,autor,nomDocExportat,path,format);
    }

    /**
     * carrega expressions.
     * @return un arraylist de les expressions
     * @throws IOException
     */
    public ArrayList<String> cargaexp() throws IOException {
        return persistencia.getArrayExps();
    }
    //_____________________Vista consultas_____________________

    /**
     * Funció que guarda l'expressió
     * @param s String amb l'expressió a guardar
     * @throws Exception
     */
    public void guardaExpressio(String s) throws Exception{
        this.ctrlExpressio.afageixExp(s);
        persistencia.guardarExpressions(ctrlExpressio.getArrayExp());
    }

    /**
     * Funció que elimina una expressió
     * @param selecti Índex de l'expressió a eliminar
     * @throws Exception
     */
    public void eliminaExpressio(int selecti) throws Exception{
        //this.ctrlExpressio.eliminaExp(s);
        this.ctrlExpressio.eliminaExp(selecti);
        persistencia.guardarExpressions(ctrlExpressio.getArrayExp());
    }

    /**
     * Funció que imprimeix les expressions
     * @return Retorna el model amb la llista de les expressions
     * @throws Exception
     */
    public DefaultListModel imprimirExpressio() throws Exception{
        return ctrlExpressio.vistaimprimeixExp();
    }

    /**
     * Funció que modifica l'expressió
     * @param mod String amb l'expressió a modificar
     * @param i Índex de l'expressió a sustituir
     * @throws IOException
     */
    public void modificaExp(String mod, int i) throws Exception {
        //ctrlExpressio.modificaExp(mod, select);
        this.ctrlExpressio.modificaExp(i, mod);
        persistencia.guardarExpressions(ctrlExpressio.getArrayExp());
    }

    /**
     * Funció que fa consultes amb expressions
     * @param s String amb l'expressió
     * @param selecti int amb forma de ordenar
     * @return Retorna el model amb la llista dels documents que coincideixen amb l'expressió
     * @throws Exception
     */
    public DefaultListModel busquedaPerBoolVista(String s, int selecti) throws Exception{
        listModel = new DefaultListModel();
        ArrayList<Pair<String,String>> exp = busquedaPerBool(s);
        if (selecti == 0) exp = sortTitolAsc(exp);
        if (selecti == 1) exp = sortTitoldesc(exp);
        if (selecti == 2) exp = sortAutorAsc(exp);
        if (selecti == 3) exp = sortAutordesc(exp);
        int mida = exp.size();
        for (int i = 0; i < mida; ++i) {
            listModel.addElement("Títol: {" + exp.get(i).getFirst() + "}  " + "Autor: {" + exp.get(i).getSecond() + "}" );
        }
        return listModel;
    }



    /**
     *
     * @param s prefix sobre el que es fara la busqueda.
     * @param selecti fomra de orndearn la llista
     * @return Un model amb la llista dels autors que comencen amb el prefix donat.
     */
    public DefaultListModel AutorsPerPrefixVista(String s, int selecti) {
        listModel = new DefaultListModel();
        ArrayList<String> a = AutorsPerPrefix(s);
        Collections.sort(a);
        if (selecti == 1) Collections.reverse(a);

        int mida = a.size();
        for (int i = 0; i < mida; i++) {
            listModel.addElement(a.get(i));
        }
        return listModel;
    }

    /**
     * busqueda de titols d'autor
     * @param autor autor sobre el que buscar
     * @param selecti ordre desitjat
     * @return la llista amb els resultats ordenats
     */
    public DefaultListModel titolsDeAutorVista(String autor, int selecti) {
        listModel = new DefaultListModel();
        ArrayList<String> a = titolsDeAutor(autor);
        Collections.sort(a);
        if (selecti == 1) Collections.reverse(a);

        int mida = a.size();
        for (int i = 0; i < mida; i++) {
            listModel.addElement(a.get(i));
        }
        return listModel;
    }

    /**
     * carrega els documents de persistencia
     * @throws Exception
     */
    public void carregaIni() throws Exception {
        ArrayList<Pair<String,String>> claus = persistencia.llegirIndex();
        for (int i = 0; i < claus.size(); ++i) {
            altaDocumentBuit(claus.get(i).getFirst(), claus.get(i).getSecond());
        }
        ctrlExpressio =new ctrlExpressio(persistencia.getArrayExps());

    }

    /**
     * obte el contingut
     * @param titol titol del document
     * @param autor titol del autor
     * @return el contingut demanat
     * @throws Exception
     */
    public String getContingutVista(String titol, String autor) throws Exception {
        carregaDoc(titol,autor);
        Contingut c = new Contingut();
        c = ctrlDocument.getContingut(titol, autor);
        return c.getStringContingut();
    }

    /**
     * imprimeix els documents
     * @return la llista de documents
     * @throws Exception
     */
    public DefaultListModel imprimeixDocs() throws Exception {
        listModel = new DefaultListModel();
        ArrayList<Pair<String,String>> doc = ctrlDocument.getTotKey();
        int mida = doc.size();
        for (int i = 0; i < mida; ++i) {
            listModel.addElement(doc.get(i).getFirst());
            listModel.addElement(doc.get(i).getSecond());
        }
        return listModel;
    }

    /**
     * imprimeix els documents en array
     * @return la llista de documents
     * @throws Exception
     */
    public ArrayList<String> imprimeixDocsArray() throws Exception {
        ArrayList<Pair<String,String>> docs = ctrlDocument.getTotKey();
        ArrayList<String> docs2 = new ArrayList<String>();
        int mida = docs.size();
        for (int i = 0; i < mida; i++) {
            docs2.add(docs.get(i).getFirst());
            docs2.add(docs.get(i).getSecond());

        }
        return docs2;
    }

    
     /**
     * busqueda de documents semblants
     * @param titol titol del document
     * @param autor autor del document
     * @param k numero de documents a buscar
     * @return Array amb els resultats
     * @throws Exception
     */
     public ArrayList<String> documentsSemblantsVistaArray(String titol, String autor, int k) throws Exception{   
        ArrayList<Pair<String,String>> docs = documentsSimilars(titol, autor, k);
        ArrayList<String> docs2 = new ArrayList<String>();
        
        int mida = docs.size();
        for (int i = 0; i < mida; i++) {
            docs2.add(docs.get(i).getFirst());
            docs2.add(docs.get(i).getSecond());
        }
       return docs2;
        
    }
    
     /**
      * 
      * @param s String amb l'expressió
      * @return Retorna cert si l'expressió és correcte o no
      * @throws Exception 
      */
    public boolean expressioCorrecete(String s) throws Exception {
        ExpressioBooleana ex = new ExpressioBooleana(s);
        return ex.expressioCorrecte();
    } 

}