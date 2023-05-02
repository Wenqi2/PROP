package Domini;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import Domini.Bool;
import Domini.BSTree;
import Domini.Paraula;
import Domini.Frase;
import Domini.Contingut;

/**
 * Classe feta per Joban
 */
public class ExpressioBooleana {
    //public ArrayList<Paraula> p;
    private String e;
    private int sizeExp;
    //public String f;
    private ArrayList<Bool> bools;
    private ArrayList<Bool> post_t;
    private BSTree arbre;
    private boolean totbe;

    public void exc(String s) throws Exception {
        //System.out.println(s);
        throw new Exception(s);
    }

    /**
     *
     * @param exp Un string amb l'expressió booleana que es vol evaluar.
     * @throws Exception Salta si el string del parametre está buit.
     */
    public ExpressioBooleana(String exp) throws Exception {
            if (exp == "") exc("Expressio buida");
            else {
                e = "(" + exp + ")";
                sizeExp = e.length();
                bools = new ArrayList<>();
                post_t = new ArrayList<>();
                totbe = true;
            }
    }

    /**
     *
     * @return Retorna l'excepció assignada prèviament.
     * @throws Exception Salta si l'expressió està buida.
     */
    public String getExp() throws Exception{
        String s = e.substring(1, e.length() - 1);
        try {
            if (s == "") throw new IOException("Expressio buida");
            //return s;
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        finally {
            return s;
        }
    }

    /**
     *
     * @return Retorna cert si l'expressió introduida previament està correcte i crea l'arbre o fals en cas contrari.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public Boolean expressioCorrecte() throws Exception {
        if (parentesisCorrecte()) {
            notRepetit();
            separarExpOp(); //separa los operandos y los operadores de la expression inicial

            identificarNot(0); //localiza los ! : a la palabra o al primer parentesi si es compuesto

            quitarNot(); //quita ! de la expresion

            infixtopostfix(); //convierte la array de infix a postfix para poder crear el arbol

            arbre = expressionTree();
            //arbre.imprimirTree();
        }
        else {
            exc("Expressió incorrecte");
        }
        return totbe;
    }

    /**
     * Treu els '!' repetits de l'expressió.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public void notRepetit() throws Exception{
        boolean not = false;
        int ini;
        int i = 0;
        char c;
        while (i  < e.length()) {
            c = e.charAt(i);
            if (c == '!') {
                not = true;
                ini = i;
                do {
                    i++;
                    c = e.charAt(i);
                }
                while (c == '!');
                int aux = i - ini;

                if (aux % 2 == 0) {
                    e = e.substring(0, ini) + e.substring(i, e.length());
                } else {
                    e = e.substring(0, ini) + e.substring(i-1 , e.length());
                }
            }
            i++;
        }
    }

    /**
     *
     * @return Retorn l'arbre creat per l'expressió.
     */
    public BSTree getArbre() {
        return this.arbre;
    }

    /**
     *
     * @return Retorna l'array amb els operdors i els operands separats.
     */
    public ArrayList<Bool> getArrayBool() {
        return this.bools;
    }

    /**
     *
     * @return Retorna l'array amb la expressió en postfix.
     */
    public ArrayList<Bool> getArrayPost() {
        return this.post_t;
    }

    /**
     *
     * @return Retorna cert si els parentesis són correcte i fals en cas contrari.
     * @throws Exception Salta si està mal parentetitzat.
     */
    public boolean parentesisCorrecte() throws Exception {
        boolean correcte = true;
        int p = 0;
        int k = 0;
        int c = 0;
        int i = 0;
        while (i < sizeExp) {
            if (e.charAt(i) == '(') p++;
            else if (e.charAt(i) == ')') p--;
            else if (e.charAt(i) == '{') k++;
            else if (e.charAt(i) == '}') k--;
            else if (e.charAt(i) == '"') c++;
            ++i;
            if (p < 0 || k < 0) correcte = false;
        }
        if (p == 0 && k == 0 && c%2 == 0) {
            return true;
        }
        else  {
            exc("Mal parentetitzat");
            return false;
        }
    }

    /**
     *
     * @param c Un char que es vol assignar com operador.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public void esOperador(char c) throws Exception {
        Bool b = new Bool();
        b.setOperador(c);
        bools.add(b);
    }

    /**
     *
     * @param s Un string que es vol assignar com operand.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public void esOperand(String s) throws Exception{
        Bool b = new Bool();
        b.setOperand(s);
        bools.add(b);
    }

    /**
     * Separa l'expressió inicial en operdaors i operands.
     * @throws Exception Salta si no ha recorregut tota el string de l'expressió.
     */
    public void separarExpOp() throws Exception{
        char c = e.charAt(0);
        esOperador(c);
        int x = separarExpOp(1);
        if (x+1 != e.length()) exc("Expressio incorrectament separada");
    }

    /**
     * Separa l'expressió inicial en operdaors i operands.
     * @param i És l'índex del string de l'expressió que es vol evaluar.
     * @return Retorna l'index (recursividad).
     * @throws Exception Salta si no separa bé l'expressió
     */
    public int separarExpOp(int i) throws Exception{
        while (i < sizeExp) {
            char c = e.charAt(i);
            if (c != ' ') {
                if (c != ')') {
                    if (c == '{' | c == '"') {
                        if (c == '{') {
                            i = esConjunt(i);
                        }
                        else if (c == '"') {
                            i = esSequencia(i);
                        }
                    }
                    else if (c == '|' | c == '&' | c == '!' | c == '(') {
                        esOperador(c);
                        if (c == '(') {
                            i = esParentesi(i);
                        }
                    }
                    else {
                        i = esParaula(i);
                    }
                }
                else {
                    esOperador(c);
                    return i;
                }
            }
            ++i;
        }
        exc("Error SepararExpOp");
        totbe = false;
        return 0;
    }

    /**
     * Separa el conjunt.
     * @param i Índex d'on comença el conjunt.
     * @return Retorna l'índex d'on acaba el conjunt.
     * @throws Exception Salta si el conjunt no acaba o té un operador a dins.
     */
    public int esConjunt(int i) throws Exception {
        int fin = i+1;
        while (fin < sizeExp) {
            char c = e.charAt(fin);
            //System.out.print(c);
            if (c == '}') {
                //fin++;
                String s = e.substring(i, fin+1);
                //System.out.print(s);
                esOperand(s);
                //if (e.charAt(fin) == ')') fin--; // puesto porque al hacer fin++ si hay parentesi ')' se lo come
                return fin;
            }
            else if (c == '{' | c == '"' | c == '|' | c == '&' |
                    c == '!' | c == '(' | c == ')') {
                exc("Operador dins conjunt");
                totbe = false;//System.out.println("Operador dins de conjunt");
            }
            fin++;
        }
        exc("Conjunt no termina");
        totbe=false;//System.out.println("El conjunt no termina");
        return 0;
    }

    /**
     * Separa la sequencia.
     * @param i Índex d'on comença la sequencia.
     * @return Retorna l'índex d'on acaba la sequencia.
     * @throws Exception Salta si la sequencia no termina.
     */
    public int esSequencia(int i) throws Exception {
        int fin = i+1;
        while (fin < sizeExp) {
            char c = e.charAt(fin);
            if (c == '"') {
                //fin++;
                String s = e.substring(i, fin+1);
                esOperand(s);
                //if (e.charAt(fin) == ')') fin--;
                return fin;
            }
            fin++;
        }
        exc("Sequencia no termina");
        totbe = false;//System.out.println("la sequencia no termina");
        return 0;
    }

    /**
     *
     * @param i Índex d'on comença el parèntsis.
     * @return Retorna l'índex d'on acaba el parèntesis.
     * @throws Exception Salta si no ha recorregut tota el string de l'expressió.
     */
    public int esParentesi(int i) throws Exception {
        int fin = i+1;
        //char c = e.charAt(fin);
        return separarExpOp(fin);
    }

    /**
     * Separa la paraula
     * @param i Índex d'on comença la paraula.
     * @return Retorna l'índex d'on acaba la paraula.
     * @throws Exception
     */
    public int esParaula(int i) throws Exception {
        int fin = i;
        while (fin < sizeExp) {
            char c = e.charAt(fin);
            if (c == ' ' | ((c == '&') | (c == '|') | (c == '!') | (c == '(') | (c == ')') |
                    (c == '{') | (c == '}') | (c == '"'))) {
                String s = e.substring(i, fin);
                esOperand(s);
                fin--;
                return fin;
            }
            fin++;
        }
        exc("Error Paraula");
        totbe = false; //System.out.println("error esparaula");
        return 0;
    }

    /**
     * Identifica i assigna el not als operands o a l'operador '('.
     * @param i i = 0.
     * @throws Exception Salta si es fa un ús inadequat de l'operador '!'.
     */
    public void identificarNot(int i) throws  Exception{
        boolean not = false;
        int mida = bools.size();
        while(i < mida) {
            Bool b = bools.get(i);
            if (b.esOperador()) {
                char op = b.getOperador();
                if (not) {
                    if (op != '(') {
                        totbe = false;//System.out.println("error quitarnot");
                        exc("us inadequat del operador !");
                    }
                    else {
                        b.setnot();
                    }
                    not = false;
                }
                if (op == '!') not = true;
            }
            else {
                if(not) {
                    b.setnot();
                }
                not = false;
            }
            i++;
        }
    }

    /**
     * Treu els operadors not '!'.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public void quitarNot() throws Exception{
        int i = 0;
        Bool b = new Bool();
        while (i < bools.size()){
            b = bools.get(i);
            if (b.esOperador() && (b.getOperador() == '!')) {
                bools.remove(b);
            }
            i++;
        }
    }

    /**
     * Transforma l'expressió en infix a postfix per poder crear l'arbre
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public void infixtopostfix() throws Exception{
        Deque<Bool> stack = new ArrayDeque<Bool>();
        boolean n = false;
        for (int i = 0; i < bools.size(); ++i) {
            Bool b = bools.get(i);
            if (b.esOperand()){
                post_t.add(b);
            }
            else if(b.getOperador() == '(') {
                stack.push(b);
                if(b.getnot() == true) n = true;
            }
            else if(b.getOperador() == ')') {
                //he puesto este if para resolver el caso de parentesis redundantes !(hola), !((hola)), !((({p1 p2})))
                if (stack.peek().getOperador() == '(' && n == true) {
                    int mida = post_t.size();
                    if (mida != 0) {
                        if(post_t.get(mida-1).esOperand()) {
                            //System.out.println(post_t.get(mida-1).getOperand());
                            post_t.get(mida-1).setnot();
                        }
                    }
                    n = false;
                }
                while (!stack.isEmpty() && stack.peek().getOperador() != '(') {
                    //System.out.println("he entrado aqui");
                    Bool aux = stack.peek();
                    if (n) aux.setnot();
                    post_t.add(aux);
                    stack.pop();
                }

                n = false;
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && prec(b.getOperador()) <= prec(stack.peek().getOperador())) {
                    post_t.add(stack.peek());
                    stack.pop();
                }
                // puesto por el caso !(hola & (pep | joan)) sin esto niega el or enves de and
                if (n == true){
                    b.setnot();
                    n = false;
                }
                stack.push(b);
            }
        }
        while (!stack.isEmpty()){
            if(stack.peek().getOperador() == '(') totbe = false; //System.out.println("invalid expression");
            post_t.add(stack.peek());
            stack.pop();
        }
    }

    /**
     *
     * @param c Char amb l'operador a evaluar.
     * @return Retorna la prioritat de l'operador.
     */
    static int prec(char c){
        switch(c) {
            //case '(': return 3;
            case '&': return 2;
            case '|': return 1;
            default: return -1;
        }
        //return -1;
    }

    /**
     * Crea un arbre d'expressions amb els operands a les fulles i els operdors als nodes inermedis amb l'expressió en postfix.
     * @return Retorna un arbre.
     */
    public BSTree expressionTree() {
        Stack<BSTree> st = new Stack<BSTree>();
        BSTree t1, t2, tmp;
        for (int i = 0; i < post_t.size(); i++) {
            Bool b = post_t.get(i);
            if (!b.esOperador()) {
                tmp = new BSTree();
                tmp.node(b);
                st.push(tmp);
            }
            else {
                tmp = new BSTree();
                tmp.node(b);

                t1 = st.pop();
                t2 = st.pop();

                tmp.left(t2);
                tmp.right(t1);

                st.push(tmp);
            }
        }
        tmp = st.pop();
        return tmp;
    }

    /**
     *
     * @param c Contigut a evaluar.
     * @param a Arbre de l'expressió booleana.
     * @return Retorna cert si el contingut compleix l'expressió booleana i fals en el cas contrari.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public boolean getDocCompleix(Contingut c, BSTree a) throws Exception{
        ArrayList<Frase> frases = c.getFrases();
        Boolean compleix = false;
        for (Frase f : frases) {
            if (compleixExp(f, a)) {
                compleix = true;
                break;
            }
        }
        return compleix;
    }

    /**
     *
     * @param frase Frase a evaluar.
     * @param a Arbre de l'expressió booleana.
     * @return Retorna cert si la frase compleix l'expressió booleana i fals en el cas contrari.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public Boolean compleixExp (Frase frase, BSTree a) throws Exception{
        if (a.fulla()) {
            String e = a.getNode().getOperand();
            boolean comp;
            switch(e.charAt(0)){
                case '{': {
                    comp = compleixConjunt(e, frase.getFrase());
                    break;
                }
                case '"': {
                    comp = compleixSequencia(e, frase.getFrase());
                    //System.out.println("cumple seq "+comp);
                    break;
                }
                default: {
                    comp = compleixParula(e, frase.getFrase());
                    //System.out.println("cumple paraula "+ comp);
                }
            }
            if (a.getNode().getnot()) return !comp;
            else return comp;
        }
        else {
            boolean esq = compleixExp(frase, a.getEsquerre());
            char op = 0;
            if (a.getNode().esOperador()) {
                op = a.getNode().getOperador();
            }
            //else System.out.print("error compleix");
            boolean dr = compleixExp(frase, a.getDret());

            switch(op) {
                case '&': {
                    if (a.getNode().getnot()) return !(esq & dr);
                    else return (esq & dr);
                }
                case '|': {
                    if (a.getNode().getnot()) return !(esq | dr);
                    else return (esq | dr);
                }
                default: totbe = false;//System.out.print("error compleix");
            }
        }
        return false;

    }

    /**
     * Comprova si dues paraules són iguals.
     * @param p1 Una instància de la classe Paraula.
     * @param p2 Una altra instància de la classe Paraula.
     * @return Retorna cert si són iguals i fals en cas contrari.
     */
    public boolean paraulesIguals(Paraula p1, Paraula p2){
        String par1 = p1.getParaula().toLowerCase();
        String par2 = p2.getParaula().toLowerCase();
        int mida1 = par1.length();
        int mida2 = par2.length();
        if (mida1 != mida2) return false;
        else {
            for(int i = 0; i < mida1; i++) {
                if (par1.charAt(i) != par2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param conj Conjunt a evaluar.
     * @param f Frase a comprovar.
     * @return Retorna cert si el conjunt hi és a la frase.
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public boolean compleixConjunt(String conj, ArrayList<Paraula> f) throws Exception{
        //System.out.println(conj);
        conj = conj.substring(1, conj.length()-1);
        //System.out.println(conj);
        //conj = " " + conj + " ";
        ArrayList<Paraula> p = new ArrayList<>();
        String aux = "";
        for (int i = 0; i < conj.length(); i++){
            char c = conj.charAt(i);
            if (c != ' ') {
                aux += c;
            }
            if (c == ' ' | i == conj.length()-1) {
                Paraula par = new Paraula();
                par.setParaula(aux);
                p.add(par);
                aux = "";
            }
        }
        for (Paraula p1 : p) {
            boolean comp = false;
            for (Paraula p2 : f) {
                if(paraulesIguals(p1, p2)) {
                    comp = true;
                    break;
                }
            }
            if (!comp) return false;
        }
        return true;
    }

    /**
     *
     * @param e Sequencia a evaluar.
     * @param f Frase a comprovar.
     * @return Retorna cert si la sequencia hi és a la frase.
     */
    public  boolean compleixSequencia(String e, ArrayList<Paraula> f) {
        //System.out.println(e);
        e = e.substring(1, e.length()-1);
        Frase fr = new Frase();
        for (Paraula p : f) {
            fr.afegir(p);
        }
        //return seq.matches(e);
        String s = fr.getFraseCompleta();
        return s.matches("(.*)" + e + "(.*)");
        //return s.indexOf(e) != -1? true: false;
    }

    /**
     *
     * @param e Parual a comprovar
     * @param f Frase a comprovar
     * @return Retorna cert si la Paraula hi és a la frase;
     * @throws Exception Salta si alguna de les funcions que utilitza fan saltar una excepció.
     */
    public  boolean compleixParula(String e, ArrayList<Paraula> f) throws Exception{
        Paraula p1 = new Paraula();
        p1.setParaula(e);
        for (Paraula p2 : f) {
            if (paraulesIguals(p1, p2)) return true;
        }
        return false;
    }

}

