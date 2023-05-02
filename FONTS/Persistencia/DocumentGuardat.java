package Persistencia;

import Domini.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;

public class DocumentGuardat {

    final String camino=".."+File.separator+"Fitxers"+File.separator;
    /**
     *
     * @return Retorna una llista de pairs amb tots els titols i autors (en aquest ordre) de dins la aplicació(crida feta al inici)
     * @throws IOException
     */
    public ArrayList<Pair<String,String>> llegirIndex() throws IOException {

        //File index= new File("../../Fitxers/indexacio.jm");
        /*File index= new File(camino+"indexacio.jm");
        FileReader fr=new FileReader(index);*/
        //BufferedReader bf=new BufferedReader(fr);
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(camino+"indexacio.jm"), "UTF8"));

        String kk=null;
        ArrayList<Pair<String,String>> docus=new ArrayList<Pair<String,String>>();
        while(null!=(kk=bf.readLine())){

            String[] parte = kk.split(";");
            String title=parte[0];
            String author=parte[1];
            Pair<String,String> adder=new Pair<>(title,author);
            docus.add(adder);
        }
        bf.close();
        return docus;
    }

    //només té en compte fitxers txt

    /**
     *
     * @param title titol del document
     * @param author autor del document
     * @return Retorna el contingut del fitxer amb titol i autor
     * @throws IOException
     */
    public String getContentFitxer(String title, String author) throws IOException {
        String content="";
        /*File index= new File(camino+title+author+".jm");
        FileReader fr=new FileReader(index);
        BufferedReader bf=new BufferedReader(fr);*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(camino+title+author+".jm"), "UTF8"));

        String extra=null;
        //extra= bf.readLine();
        //extra= bf.readLine();
        String take=null;
        //take.concat
        while(null!=(take=bf.readLine())){
            content=content.concat(take+"\n");
            take=null;
        }

        return content;
    }

    //coña
    /**
     * Guarda les expressions donades
     * @param exps Llista de expressions booleanes
     * @throws IOException
     */
    public void saveExp(ArrayList<String> exps) throws IOException {
        //File index= new File(camino+"indexExp.jm");
        //FileWriter fichero = new FileWriter(index);
        //BufferedWriter escrive = new BufferedWriter(fichero);
        BufferedWriter escrive = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camino+"indexExp.jm"), StandardCharsets.UTF_8));
        for(int i=0;i<exps.size();i++) {
            escrive.write(exps.get(i)+"\n");
        }
        escrive.close();

    }

    //coña
    /**
     *
     * @return Retorna totes les expressions guardades
     * @throws IOException
     */
    public ArrayList<String> getExps() throws IOException {
        /*File index= new File(camino+"indexExp.jm");
        FileReader fr=new FileReader(index);
        BufferedReader bf=new BufferedReader(fr);*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(camino+"indexExp.jm"), "UTF8"));

        String kk=null;
        ArrayList<String> docus=new ArrayList<String>();
        while(null!=(kk=bf.readLine())){
            docus.add(kk);
        }
        bf.close();
        return docus;

    }

    //coña
    /**
     *
     * @param title titol del document
     * @param author autor del document
     * @throws IOException
     * Elimina el fitxer amb titol i autor
     */
    public void eliminaFitxer(String title,String author) throws IOException {
        ArrayList<String> doc=new ArrayList<String>();
        File ficher= new File(camino+title+author+".jm");
        ficher.delete();
        //File index= new File(camino+"indexacio.jm");


        //FileReader fr=new FileReader(index);
        //BufferedReader bf=new BufferedReader(fr);
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(camino+"indexacio.jm"), "UTF8"));

        String take=null;

        while(null!=(take=bf.readLine())){
            if(!take.equals(title+";"+author)){
                doc.add(take);

            }
            take=null;
        }
        bf.close();

        /*File index2= new File(camino+"indexacio.jm");
        FileWriter fichero = new FileWriter(index2);
        BufferedWriter escrive = new BufferedWriter(fichero);*/
        BufferedWriter escrive = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camino+"indexacio.jm"), StandardCharsets.UTF_8));

        //FileOutputStream fo=new FileOutputStream(index2);
        for(int i=0;i<doc.size();i++) {
            //System.out.println(doc.get(i));
            escrive.write(doc.get(i)+"\n");
        }
        escrive.close();

    }

    //coña
    /**
     *
     * @param title titol del document
     * @param author autor del document
     * @param content contingut del document
     * @throws IOException
     * Insereix el fitxer amb titol, autor i contingut(String)
     */
    public void insereixFitxer(String title, String author, String content) throws IOException {
        /*File ficher= new File(camino+title+author+".jm");
        FileWriter fw = new FileWriter(ficher);
        BufferedWriter bw = new BufferedWriter(fw);*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camino+title+author+".jm"), StandardCharsets.UTF_8));

        //bw.write(author+"\n");
        //bw.write(title+"\n");
        bw.write(content);
        bw.close();
        File index= new File(camino+"indexacio.jm");

        ArrayList<String> doc=new ArrayList<String>();
        //FileReader fr=new FileReader(index);
        //BufferedReader bf=new BufferedReader(fr);
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(camino+"indexacio.jm"), "UTF8"));

        String take=null;

        while(null!=(take=bf.readLine())){
            doc.add(take);
            take=null;
        }
        bf.close();
        //fr.close();

        //FileWriter fichero = new FileWriter(index);
        //BufferedWriter escrive = new BufferedWriter(fichero);
        BufferedWriter escrive = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camino+"indexacio.jm"), StandardCharsets.UTF_8));

        for(int i=0;i<doc.size();i++) {
            escrive.write(doc.get(i)+"\n");
        }
        escrive.write(title+";"+author);
        escrive.close();
    }

    /**
     *
     * @param title
     * @param author
     * @return retorna true si el document ja existeix
     * @throws IOException
     */
    public boolean existeix(String title,String author) throws IOException {
        //File index=new File(camino+"indexacio.jm");
        //FileReader fr=new FileReader(index);
        //BufferedReader bf=new BufferedReader(fr);
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(camino+"indexacio.jm"), "UTF8"));

        String take=null;

        while(null!=(take=bf.readLine())){
            if(take.equals(title+";"+author)) return true;
            take=null;
        }
        bf.close();
        return false;
    }

    /**
     * Funcio abstracta
     * Serialitza el document donat
     * @param file fitxer a serialitzar
     * @param path path del fitxer
     * @throws IOException
     * @return retorna nom i autor
     */
    public Pair<String,String> serialize(File file, String path) throws IOException {
        System.out.println("liada");
        return null;
    }

    /**
     * Funcio abstracta
     * @return converteix a document a exportar
     */
    public void deserialize(String titol, String autor, String nomFitx, String path) throws IOException {
        System.out.println("liada2");

    }
}
