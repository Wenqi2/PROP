package Domini;

/**
 * Classe feta per Joban
 */
public class Bool {
    private boolean esOperador;
    private boolean esOperand;
    private char operador;
    private String operand;

    private boolean not;

    /**
     * @constructor Crea una instancia de la classe bool buida.
     */
    public Bool() {
        esOperador = false;
        esOperand = false;
        not = false;
    }

    /**
     *
     * @param op Un char amb l'operador que es vol assignar.
     * @throws Exception Salta si el char rebut no es un dels operadors.
     */
    public void setOperador(char op) throws Exception{
        if (op == '(' | op == ')' | op == '{' | op == '}' |
                op == '&' | op == '|' | op == '!' | op == '"') {
            esOperador = true;
            this.operador = op;
        }
        else exc("No es operador.");
    }

    /**
     *
     * @param op Un string amb l'operand que es vol assignar.
     * @throws Exception Salta si el string rebut está buit.
     */

    public void setOperand(String op) throws Exception{
        if (op.isEmpty()) exc("Operand buit");
        else {
            esOperand = true;
            this.operand = op;
        }
    }

    /**
     *
     * @return Retorna un char amb l'operador que s'ha assignat previament.
     * @throws Exception Salta si no és un operador.
     */
    public char getOperador() throws Exception{
        if (esOperador) {
            return operador;
        }
        else exc("No es operador");
        return 0;
    }

    /**
     *
     * @return Retorna un String amb l'operand que s'ha assignat previament.
     * @throws Exception Salta si no és un operand.
     */
    public String getOperand() throws Exception{
        if (esOperand) {
            return operand;
        }
        else exc ("No es un operand");
        return "0";
    }

    /**
     *
     * @return Retorna l'operador assigant.
     */
    public boolean esOperador() {
        return this.esOperador;
    }

    /**
     *
     * @return Retorna l'operand assignat.
     */
    public boolean esOperand() {
        return this.esOperand;
    }

    /**
     * Nega l'operador o l'operand.
     */
    public void setnot() {
        not = true;
    }

    /**
     *
     * @return Retorna si l'operador o l'operand estan negats o no.
     */
    public boolean getnot() {
        return not;
    }

    public void exc(String s) throws Exception {
        System.out.println(s);
        throw new Exception();
    }

}
