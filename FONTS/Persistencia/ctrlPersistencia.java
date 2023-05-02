package Persistencia;
import Domini.Pair;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;

public class ctrlPersistencia {

    /**
     * Guarda un document importat
     * @param file fitxer
     * @param path path al document
     * @throws IOException
     * @return  retorna un pair amb titol i autor en aquest ordre
     */
    public Pair<String,String> importarFitxer(File file, String path) throws IOException {

        String name= path;
        DocumentGuardat fitx;
        String extension = "";

        int i = name.lastIndexOf('.');
        if (i > 0) {
            extension = name.substring(i+1);
        }

        if(extension.equals("txt")){
            fitx=new txtFormat();
        }
        else if(extension.equals("xml")){
            fitx=new xmlFormat();
        }
        else {
            fitx=new txtFormat();
        }


        return fitx.serialize(file,path);
    }

    /**
     *
     * @param titol titol del document
     * @param autor autor del document
     * @param format format en que es vol exportar el document
     * @return exporta un fitxer a fora l'aplicacio
     */
    public void exportarFitxer(String titol,String autor,String nomFitx, String path,String format) throws IOException {

        DocumentGuardat fitx;
        if(format.equals("txt")){
            fitx=new txtFormat();
        }
        else if(format.equals("xml")){
            fitx=new xmlFormat();
        }
        else {
            fitx=new txtFormat();
        }
        fitx.deserialize(titol,autor,nomFitx,path);

    }

    /**
     * Guarda un document en format propietari
     * @param title titol del document a guardar
     * @param author autor del document
     * @param content contingut del document
     * @throws IOException
     */
    public void insereixFitxer(String title, String author, String content) throws IOException {

        DocumentGuardat doc=new DocumentGuardat();
        doc.insereixFitxer(title,author,content);
    }

    /**
     * Borra de la persistencia el document desitjat
     * @param title titol del doument
     * @param author autor del document
     * @throws IOException
     */
    public void eliminaFitxer(String title,String author) throws IOException {
        DocumentGuardat doc=new DocumentGuardat();
        doc.eliminaFitxer(title,author);
    }

    /**
     *
     * @return retorna els titols i els autors dels documents guardats
     * @throws IOException
     */
    public ArrayList<Pair<String,String>> llegirIndex() throws IOException {

        DocumentGuardat doc=new DocumentGuardat();

        return  doc.llegirIndex();
    }

    /**
     *
     * @param title titol del document
     * @param author autor del document
     * @return retorna el contingut d'un document
     * @throws IOException
     */
    public String getContentFitxer(String title, String author) throws IOException {
        DocumentGuardat doc=new DocumentGuardat();
        return doc.getContentFitxer(title,author);
    }

    public void guardarExpressions(ArrayList<String> a) throws IOException {
        DocumentGuardat doc=new DocumentGuardat();
        doc.saveExp(a);
    }
    public ArrayList<String> getArrayExps() throws IOException {
        DocumentGuardat doc=new DocumentGuardat();
        return doc.getExps();
    }

}
