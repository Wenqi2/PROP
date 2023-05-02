package Domini;

import java.util.ArrayList;
import Domini.Frase;
import Domini.Contingut;
import Domini.Paraula;
import Domini.Document;

/**
 * Classe feta per Edgar
 */
public class tfidfCalc {

    /**
     *
     * @param doc Frases on es busca la paraula
     * @param term paraula que es busca
     * @return retorna el numero de cops que apareix la paraula entre el numero de paraules
     */
    public double tf(ArrayList<Frase> doc, String term) {
        double result = 0;
        int sumaParaules=0;
        for (Frase frase: doc) {
            ArrayList<Paraula> listpar= frase.getFrase();

            for (Paraula word : listpar) {
                sumaParaules=sumaParaules+1;
                if (term.equalsIgnoreCase(word.getParaula()))
                    result++;
            }
        }
        return result / sumaParaules;
    }

    /**
     *
     * @param docs Documents on es busca la paraula
     * @param term paraula que es busca
     * @return el logaritme del numero de documents entre el numero de cops que apareix la paraula
     * @throws Exception
     */
    public double idf(ArrayList<Document> docs, String term) throws Exception {
        double n = 0;
        int k=0;
        for (Document doc : docs) {
            ArrayList<Frase> cont = doc.getContingut().getFrases();
            for(Frase frase : cont){
                ArrayList<Paraula> list= frase.getFrase();
                for (Paraula word : list) {
                    if (term.equalsIgnoreCase(word.getParaula())) {
                        n++;
                        k=1;
                        //break;

                    }
                }
                if(k==1){
                    k=0;
                    //break;
                }
            }
        }
        if(n==0) n=1;
        return 1+Math.log(docs.size() / n);
    }

    /**
     *
     * @param doc frases on es busca la paraula
     * @param docs documents on es busca la paraula
     * @param term paraula que es busca
     * @return el pes de la paraula dins del conjunt de documents
     * @throws Exception
     */
    public double tfIdf(ArrayList<Frase> doc, ArrayList<Document> docs, String term) throws Exception {
        return tf(doc, term) * idf(docs, term);
    }



}