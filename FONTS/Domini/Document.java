package Domini;

import java.util.ArrayList;
import Domini.Contingut;
import Domini.VectorPesos;

/**
 * Classe feta per Wenqi
 */
public class Document {
    private String Titol;
    private String Autor;
    private  Contingut contingut;
    private  VectorPesos peso;


    private boolean carregat;

    /**
     * @Constructor Crear un Doc buit
     */
    public Document() {
        this.Titol = null;
        this.Autor = null;
        this.contingut = new Contingut();
        this.peso = new VectorPesos();
        carregat = true;
    }
    /**
     * @param titol titol que es vol ficar
     * @param autor autor que es vol ficar
     * @constructor Crear un Doc buit amb titol i autor
     */
    public Document(String titol, String autor) {
        this.Titol = titol;
        this.Autor = autor;
        this.contingut = new Contingut();
        this.peso= new VectorPesos();
        carregat = false;
    }
    /**
     *
     * @constructor Crear un Doc amb titol, autor i contingut
     */
    //Constructor puede crear un documento vacio poniendo el contingut vacio en tercera parametro
    public Document(String nuevoTitol, String nuevoAutor, Contingut newcontingut) {
        this.Titol = nuevoTitol;
        this.Autor = nuevoAutor;
        this.contingut = newcontingut;
        this.peso = new VectorPesos();
        carregat = true;
    }

    /**
     *
     * @return torna el titol
     */
    public String getTitol() {
        return Titol;
    }

    /**
     *
     * @return torna l'autor
     */
    public String getAutor() {
        return Autor;
    }
    /**
     *
     * @return torna el contingut
     */
    public Contingut getContingut() {
        return contingut;
    }
    /**
     *
     * @return torna el vector de pesos del Document
     */
    public VectorPesos getVectorPes() {
        return peso;
    }


    /**
     *
     * @return torna un boolea que indica si s'ha carregat el contingut
     */
    public boolean getCarregat(){return carregat;}

    /**
     *
     * @param Newcontingut string amb el contingut que es vol ficar
     * @throws Exception
     */
    public void modi_doc(String Newcontingut) throws Exception{
        this.contingut.modificarContingut(Newcontingut);
        carregat = true;
    }

    /**
     *
     * @param nuevoTitol string amb el nou titol
     */
    public void modi_Titol(String nuevoTitol) {
        this.Titol = nuevoTitol;
    }

    /**
     *
     * @param nuevoautor string amb el nou autor
     */
    public void modi_autor(String nuevoautor) {
        this.Autor = nuevoautor;
    }

    /**
     *
     * @param contingut contingut a comparar
     * @param cjtDocs conjunt de docunents a comparar
     * @throws Exception
     */
    public void actualitza_peso(Contingut contingut, ArrayList<Document> cjtDocs) throws Exception{
        peso.crearVector(contingut, cjtDocs);

    }
}
