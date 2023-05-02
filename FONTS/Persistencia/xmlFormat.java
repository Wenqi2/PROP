package Persistencia;

import Domini.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;

public class xmlFormat extends DocumentGuardat{

    /**
     * Serialitza el document donat
     * @param file fitxer a serialitzar
     * @param path path del fitxer
     * @throws IOException
     * @return retorna un pair amb el titol i l'autor
     */
    public Pair<String,String> serialize(File file, String path) throws IOException {
        String patho=path;
        FileReader fr=new FileReader(file);
        BufferedReader bf=new BufferedReader(fr);
        //BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

        String autor="";
        String titol="";
        String content="";

        String take=null;
        //take.concat
        while(null!=(take=bf.readLine())){
            //System.out.println(take);
            content=content.concat(take+"\n");
            take=null;

        }

        String[] titolazo=content.split("<titol>");
        if(titolazo.length>1){
            String[] titulazo2=titolazo[titolazo.length-1].split("</titol>");
            titol=titulazo2[0];
        }
        else{
            String[] titolaz=content.split("<títol>");
            String[] titulazo2=titolaz[titolaz.length-1].split("</títol>");
            titol=titulazo2[0];
        }

        String[] autorazo=content.split("<autor>");
        String[] autorazo2=autorazo[autorazo.length-1].split("</autor>");
        autor=autorazo2[0];
        autor=autor.replaceAll(" ","");
        autor=autor.replaceAll("\n","");

        titol=titol.replaceAll(" ","");
        titol=titol.replaceAll("\n","");
        //System.out.println(titol);
        //System.out.println(autor);
        String[] cont=content.split("<contingut>");
        String[] cont2=cont[cont.length-1].split("</contingut>");
        content=cont2[0];
        if(cont2.length==1 || autorazo2.length==1 || titolazo.length==1) return null;
        //content=content.replaceAll(" ","");
        bf.close();
        //fr.close();
        if(this.existeix(titol,autor)) return null;

        //crearNou
        //if(content.charAt(0)=='\n') content.replaceFirst("\n","");

        //System.out.println(content);
        this.insereixFitxer(titol,autor,content);


        Pair<String,String> titaut=new Pair<String,String>();
        titaut.setSecond(autor);
        titaut.setFirst(titol);
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
        ArrayList<String> content=new ArrayList<>();

        String take=null;
        //take.concat
        while(null!=(take=bf.readLine())){
            content.add(take);
            take=null;
        }
        bf.close();
        fr.close();
        //this.eliminaFitxer(titol,autor);

        File exportat= new File(path+File.separator+nomFitx+".xml");
        FileWriter fichero = new FileWriter(exportat);
        BufferedWriter escrive = new BufferedWriter(fichero);
        //BufferedWriter escrive = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+File.separator+nomFitx+".xml"), StandardCharsets.UTF_8));

        escrive.write("<autor>"+autor+"</autor>"+"\n");
        escrive.write("<titol>"+titol+"</titol>"+"\n");
        escrive.write("<contingut>");
        for(int i=0;i<content.size();i++) {
            escrive.write(content.get(i));
            if(i<content.size()-1) escrive.write("\n");
        }
        escrive.write("</contingut>");
        escrive.close();

    }
}
