package Presentacio;

import Domini.CtrlDomini;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import Presentacio.vistaPrincipal;
import javax.swing.JOptionPane;


public class CtrlPresentacio {
    private static CtrlDomini Domini = new CtrlDomini();
    private static DefaultListModel listModel;

    /**
     *  Inicia la presentacio
     */
    public static void iniPresentacion() {

        vistaPrincipal vista = new vistaPrincipal();
    }

    /**
     * Crea un document nou
     * @param titol Titol del document
     * @param autor Autor del document
     * @param con Contingut del document
     */
    public static void altaDoc(String titol, String autor, String con) {
        try{
        Domini.altaDocument(titol,autor,con);
        }
        catch (Exception ex) {
        }
    }

    /**
     * Elimina un document
     * @param titol Titol d'un document
     * @param autor Autor d'un document
     */
    public static void bajaDoc(String titol, String autor) {
        try{
            Domini.bajaDocument(titol,autor);
        }
        catch (Exception ex) {
        }
    }

    /**
     * Modifica el contingut d'un document
     * @param titol Titol d'un document
     * @param autor autor d'un document
     * @param contingut Contingut d'un document
     */
    public static void modifContingut(String titol, String autor, String contingut){
        try{
            Domini.modifDocument(titol, autor, contingut);
        }
        catch (Exception ex) {
        }
    }

    /**
     * Modificar el autor d'un document
     * @param titol Titol d'un document
     * @param autor Autor d'un document
     * @param autornuevo Nou autor d'un document
     */
    public static void modifAutor(String titol, String autor, String autornuevo) {
        try {
            Domini.modifAutor(titol, autor, autornuevo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Modificar el titol d'un document
     * @param titol Titol d'un document
     * @param autor Autor d'un document
     * @param newtitol Nou titol d'un document
     */
    public static void modifTitol(String titol, String autor, String newtitol) {
        try {
            Domini.modifTitol(titol, autor, newtitol);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Crear un document nou amb un titol introduit, pero amb la mateixa contingut
     * @param titol Titol d'un document
     * @param autor Autor d'un document
     * @param newTitol Nou titol d'un document
     */
    public static void copiarDocument(String titol, String autor, String newTitol){
        try {
            Domini.copiarDocument(titol, autor,newTitol);
        } catch (Exception ex) {
            Logger.getLogger(CtrlPresentacio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * importar un document al sistema
     * @param fitxer Fitxer a Importar
     * @param path Path absolut del fitxer
     */
    public static void importarDoc(File fitxer, String path){
        try {
            Domini.importar(fitxer, path);
        } catch (Exception ex) {
            Logger.getLogger(CtrlPresentacio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Exportar un document del sistema al directori introduit en format txt
     * @param titul Titol d'un document
     * @param autor Autor d'un document
     * @param nomDocExportat Nom del document a exportar
     * @param path Path del document a exportar
     */
    public static void exportarTXT(String titul, String autor, String nomDocExportat, String path) {
        try {
            Domini.exportar(titul,autor, nomDocExportat, path, "txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Exportar un document del sistema al directori introduit en format txt
     * @param titul Titol d'un document
     * @param autor Autor d'un document
     * @param nomDocExportat Nom del document a exportar
     * @param path Path del document a exportar
     */
    public static void exportarXML(String titul, String autor, String nomDocExportat, String path)  {
        try {
            Domini.exportar(titul,autor, nomDocExportat, path, "xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Consultar si existeix el document
     * @param titol Titol d'un document
     * @param autor Autor d'un document
     * @return
     */
    public static boolean ExisteixDoc(String titol, String autor) {
        return Domini.ExisteixDoc(titol, autor);
    }

    /**
     * inicia la vista AltaDoc
     */
    public static void vistaAltaDoc(){
        vistaAltaDoc vista = new vistaAltaDoc();
    }
    /**
     * inicia la vista BaixaDoc
     */
    public static void vistaBaixaDoc(){
        vistaBaixaDoc vista = new vistaBaixaDoc();
    }
    /**
     * inicia la vista CtrlDocument
     */
    public static void vistaCtrlDocument(){
        vistaCtrlDocument vista = new vistaCtrlDocument();
    }
    /**
     * inicia la vista CopiarDoc
     */
    public static void vistaCopiarDoc(){
        vistaCopiar vista = new vistaCopiar();
    }
    /**
     * inicia la vista modificar document
     */
    public static void vistaModificaDoc(){
        vistaModificaDoc vista = new vistaModificaDoc();
    }
    /**
     * inicia la vista modificar titol
     */
    public static void vistaModifTitul(){
        vistaModifTitul vista = new vistaModifTitul();
    }
    /**
     * inicia la vista modificar autor
     */
    public static void vistaModifAutor(){
        vistaModifAutor vista = new vistaModifAutor();
    }
    /**
     * inicia la vista modificar contingut
     */
    public static void vistaModifContingut(){
        vistaModifContingut vista = new vistaModifContingut();
    }

    //___________________Consultas_____________________
    
    /**
     * Funció que fa consultes amb expressions
     * @param s String amb l'expressió
     * @param selecti int amb forma de ordenar
     * @return Retorna el model amb la llista dels documents que coincideixen amb l'expressió
     */
    public static DefaultListModel busquedaPerBoolVista(String s, int selecti) throws Exception{
        listModel = new DefaultListModel();
        listModel = Domini.busquedaPerBoolVista(s, selecti);
        return  listModel;
    }

    /**
     * Funció que guarda l'expressió
     * @param s String amb l'expressió a guardar
     */
    public static void guardaExp(String s) throws Exception{
        Domini.guardaExpressio(s);
    }
    
    /**
     * Funció que modifica l'expressió
     * @param mod String amb l'expressió a modificar
     * @param selecti Índex de l'expressió a sustituir
     */
    public static void modificaExp(String mod, int selecti) throws Exception{
            Domini.modificaExp(mod, selecti);
    }
    
    /**
     * Funció que elimina una expressió
     * @param selecti Índex de l'expressió a eliminar
     */
    public static void eliminaExp(int selecti) throws Exception{
        Domini.eliminaExpressio(selecti);
    }

    /**
     * Funció que imprimeix les expressions
     * @return Retorna el model amb la llista de les expressions
     */
    public static DefaultListModel imprimeixExpressio(){
        listModel = new DefaultListModel();
        try {
            listModel = Domini.imprimirExpressio();
        }catch(Exception ex){
            System.out.println("error imprimir");
        }
        return listModel;
    }
    
    /**
     * Funció que mostra els autors
     * @param s String amb el prefix
     * @param selecti Int amb el mode de ordenació
     * @return Retorna el model amb la llista dels autors
     */
    public static DefaultListModel mostraAutors(String s, int selecti){
        listModel = new DefaultListModel();
        try {
            listModel = Domini.AutorsPerPrefixVista(s, selecti);
        } catch (Exception ex) {
            System.out.println("error al mostrar autors");
        }
        return listModel;
    }
    
    /**
     * Funció que mostra els títols d'un autor
     * @param autor String amb l'autor 
     * @param selecti Int amb el mode de ordenació
     * @return Retorna el model amb la llista dels títols 
     */
    public static DefaultListModel mostraTitols(String autor, int selecti){
        listModel = new DefaultListModel();
        try {
            listModel = Domini.titolsDeAutorVista(autor, selecti);
        } catch (Exception ex) {
            System.out.println("error al mostrar titols");
        }
        return listModel;
    }
    
    /**
     * Funció que mostra el contingut
     * @param t Títol del contingut a mostrar
     * @param a Autor del contingut a mostrar
     * @return Retorna el contingut
     */
    public static String getContingut(String t, String a) {
        String s = "";
        try {
            s = Domini.getContingutVista(t, a);
        }catch(Exception ex) {
            System.out.println("error al conseguir contenido");
        }
        return s;
    }
    
    /**
     * Funció que imprimeix els documents
     * @return Retorna el model amb la llista de tots els documents
     */
    public static DefaultListModel imprimeixDocs(){
        listModel = new DefaultListModel();
        try {
            listModel = Domini.imprimeixDocs();
        }catch(Exception ex){
            System.out.println("error imprimir presentacion");
        }
        return listModel;
    }
    
    /**
     * Funció que imprimeix els documents
     * @return Retorna un Array amb tots els documents
     */
    public static ArrayList<String> imprimeixDocsArray(){
        ArrayList<String> docs = new ArrayList<String>();
        try {
            docs = Domini.imprimeixDocsArray();
        }catch(Exception ex){
            System.out.println("error imprimir presentacion");
        }
        return docs;
    }
    
    
    /**
     * Funció que mostra documents semblants
     * @param titol Títol del document amb el cual han de semblar
     * @param autor Autor del document amb el cual han de semblar
     * @param k Nombre de douments amb el cual han de semblar
     * @return Retorna un Array amb la llista del douments semblants
     * @throws Exception 
     */
    public static ArrayList<String>docsSemblantsVistaArray(String titol, String autor, int k) throws Exception{
       ArrayList<String> docs = new ArrayList<String>();
       docs = Domini.documentsSemblantsVistaArray(titol, autor, k);  
       return docs;
    }
    
     /**
      * 
      * @param s String amb l'expressió
      * @return Retorna cert si l'expressió és correcte o no
      * @throws Exception 
      */
    public static boolean expressioCorrecete(String s) throws Exception {
        return Domini.expressioCorrecete(s);
    }
  
}
