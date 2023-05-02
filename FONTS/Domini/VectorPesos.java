package Domini;

import Domini.Frase;
import Domini.Contingut;
import Domini.Paraula;
import Domini.Document;
import Domini.tfidfCalc;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe feta per Edgar
 */
public class VectorPesos {

    private HashMap<String, Double> Vpesos;
    final private String path = ".."+File.separator+"FONTS"+File.separator+"Domini"+File.separator+"StopWords"+File.separator;

    public VectorPesos(){
        Vpesos=new HashMap<String, Double>();
    }

    /**
     *  crea el vector de pesos amb el contingut d'un document i el cjt de documents per comparar paraules
     * @param contingut contingut a evaluar
     * @param cjtDocs documents sobre on s'evaluara
     * @throws Exception
     */

    public void crearVector(Contingut contingut,ArrayList<Document> cjtDocs) throws Exception {
        ArrayList<Frase> frasesContingut = new ArrayList<Frase>();
        if(contingut.buit()) Vpesos=new HashMap<String, Double>();
        else {
            frasesContingut = contingut.getFrases();
            Paraula par=new Paraula();
            Frase fra=new Frase();
            for(int i=0;i<frasesContingut.size();i++) {
                fra = frasesContingut.get(i);
                ArrayList<Paraula> paraulesFrase = fra.getFrase();
                for (int j = 0; j < paraulesFrase.size(); j++) {
                    String paraulota = paraulesFrase.get(j).getParaula();
                    paraulota=paraulota.replaceAll("[-,!¿?(¡;./|ªº{}<>=)+*'%&¬#@:_]", "");
                    paraulota=paraulota.toLowerCase();
                    tfidfCalc tfidf = new tfidfCalc();
                    boolean a = Vpesos.containsKey(paraulota);
                    if (a == false) {
                        double tfNumber = tfidf.tfIdf(frasesContingut, cjtDocs, paraulota);
                        Vpesos.put(paraulota, tfNumber);
                    }

                }
            }
        }

    }
    public HashMap<String, Double> getVpesos(){
        return Vpesos;
    }

    /**
     *
     * @param doc2 vector de pesos a comparar
     * @return torna el grau de similaritat amb un altre document
     * @throws IOException
     */
    public double similarityBetween(HashMap<String, Double> doc2) throws IOException {
        double cosAlpha;
        double dividendo1=0;
        double dividendo2=0;
        cosAlpha = 0;
        ArrayList<String> stop=new ArrayList<String>();


        File a= new File(path+"castella.txt");
        FileReader fr=new FileReader(a);
        BufferedReader bf=new BufferedReader(fr);
        String kk=null;
        //ArrayList<String> stop=new ArrayList<String>();
        while(null!=(kk=bf.readLine())){
            stop.add(kk);
        }
        bf.close();
        File b= new File(path+"english.txt");
        FileReader fren=new FileReader(b);
        BufferedReader bfen=new BufferedReader(fren);
        String kken=null;
        while(null!=(kken=bfen.readLine())){
            stop.add(kken);
        }
        bfen.close();
        File c= new File(path+"catala.txt");
        FileReader frca=new FileReader(c);
        BufferedReader bfca=new BufferedReader(frca);
        String kkca=null;
        while(null!=(kkca=bfca.readLine())){
            stop.add(kkca);
        }

        for(Map.Entry<String, Double> doc1 : Vpesos.entrySet()){
            if(!stop.contains(doc1.getKey())) {

                if (doc2.containsKey(doc1.getKey())) {

                    cosAlpha = cosAlpha + (doc1.getValue() * doc2.get(doc1.getKey()));
                    dividendo1 = dividendo1 + (doc1.getValue() * doc1.getValue());
                    dividendo2 = dividendo2 + (doc2.get(doc1.getKey()) * doc2.get(doc1.getKey()));
                } else {
                    dividendo1 = dividendo1 + (doc1.getValue() * doc1.getValue());
                }
            }
        }
        if(dividendo1==0||dividendo2==0) return 0;

        dividendo1=Math.sqrt(dividendo1);
        dividendo2=Math.sqrt(dividendo2);
        double divTot=dividendo1*dividendo2;
        cosAlpha=cosAlpha/divTot;
        return cosAlpha;
    }

}
