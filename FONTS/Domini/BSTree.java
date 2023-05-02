package Domini;
import Domini.Bool;

/**
 * Classe feta per Joban
 */
public class BSTree {
    private BSTree esq;
    private BSTree dr;
    private Bool node;

    /**
     * @constructor Crea una instància de la classe BSTree buida.
     */
    public BSTree() {
        esq = null;
        dr = null;
        node = null;

    }

    /**
     *
     * @param b Una instància de la classe Bool que es vol assignar al node.
     */
    public void node(Bool b){
        node = new Bool();
        this.node = b;
    }

    /**
     *
     * @param e Una instància de la classe BSTree que es vol assignar com a fill esquerre.
     */
    public void left(BSTree e){
        this.esq = e;
    }

    /**
     *
     * @param d Una instància de la classe BSTree que es vol assignar com a fill dret.
     */
    public void right(BSTree d){
        this.dr = d;
    }

    /**
     *
     * @return Retorna el node que s'ha assignat previament.
     */
    public Bool getNode(){
        return node;
    }

    /**
     *
     * @return Retorna el fill esquerre.
     */
    public BSTree getEsquerre(){
        return esq;
    }

    /**
     *
     * @return Retorna el fill dret.
     */
    public BSTree getDret(){
        return dr;
    }

    /**
     *
     * @return Retorna cert si no té fill esquerre ni dret i fals en el cas contrari.
     */
    public boolean fulla() {
        return (esq == null & dr == null);
    }

    /**
     * Imprimeix l'arbre
     * @throws Exception Salta si no s'ha assignat bé l'operador o l'operand
     */
    public void imprimirTree() throws Exception{
        if (this.fulla()) {
            if (this.node.getnot()) {
                System.out.print('!');
            }
            if (this.node.esOperand()) {
                System.out.print(this.node.getOperand());
            } else {
                System.out.print(this.node.getOperador());
            }
        } else {
            if (this.node.getnot()) {
                System.out.print('!');
            }
            System.out.print('(');
            this.esq.imprimirTree();
            if (this.node.esOperand()) {
                System.out.print(this.node.getOperand());
            } else {
                System.out.print(this.node.getOperador());
            }
            this.dr.imprimirTree();
            System.out.print(')');
        }
    }
    public void exc(String s) throws Exception {
        System.out.println(s);
        throw new Exception();
    }


}

