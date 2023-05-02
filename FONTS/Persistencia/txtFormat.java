package Persistencia;

import Domini.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;

public class txtFormat extends DocumentGuardat{

    /**
     * Serialitza el document donat
     * @param file fitxer a serialitzar
     * @param path path del fitxer
     * @throws IOException
     * @return retorna un pair amb el titol i l'autor
     */
    public Pair<String,String> serialize(File file, String path) throws IOException {
        //llegirNou
        Pair<String,String> titaut=new Pair<String,String>();
        String patho=path;
        FileReader fr=new FileReader(file);
        BufferedReader bf=new BufferedReader(fr);
        //BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

        String autor="";
        String titol="";
        String content="";
        autor= bf.readLine();
        titaut.setSecond(autor);
        titol= bf.readLine();
        titaut.setFirst(titol);
        if(this.existeix(titol,autor)) return null;
        String take=null;
        //take.concat
        while(null!=(take=bf.readLine())){
            content=content.concat(take);
            content=content.concat("\n");
            take=null;
        }

        bf.close();
        //fr.close();
        //crearNou
        this.insereixFitxer(titol,autor,content);
        //borrar antic
        //File ficher= new File(patho);
        //ficher.delete();
        return titaut;
    }
    /**
     *
     * @return converteix a document a exportar
     */
    public void deserialize(String titol, String autor, String nomFitx, String path) throws IOException {
        File file= new File(camino+titol+autor+".jm");
        FileReader fr=new FileReader(file);
        BufferedReader bf=new BufferedReader(fr);
        //BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(camino+titol+autor+".jm"), "UTF8"));

        ArrayList<String> content=new ArrayList<>();

        String take=null;
        //take.concat
        while(null!=(take=bf.readLine())){
            content.add(take);
            take=null;
        }
        bf.close();
        //fr.close();
        //this.eliminaFitxer(titol,autor);

        File exportat= new File(path+File.separator+nomFitx+".txt");
        FileWriter fichero = new FileWriter(exportat);
        BufferedWriter escrive = new BufferedWriter(fichero);
        //BufferedWriter escrive = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+File.separator+nomFitx+".txt"), StandardCharsets.UTF_8));

        escrive.write(autor+"\n");
        escrive.write(titol+"\n");
        for(int i=0;i<content.size();i++) {
            escrive.write(content.get(i)+"\n");
        }

        escrive.close();
    }

}
