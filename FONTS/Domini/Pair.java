package Domini;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe feta per Wenqi
 *
 */
public class Pair<F, S> implements Serializable{

    F first;
    S second;

    /**
     * @construcor Pair empty
     */
    public Pair() {

    }

    /**
     *
     * @return First element
     */
    public F getFirst() {
        return first;
    }

    /**
     *
     * @param first
     */
    public void setFirst(F first) {
        this.first = first;
    }

    /**
     *
     * @return Second element
     */
    public S getSecond() {
        return second;
    }

    /**
     *
     * @param second
     */
    public void setSecond(S second) {
        this.second = second;
    }

    /**
     *
     * @param first
     * @param second
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     *
     * @return Pair[X,Y]
     */
    @Override
    public String toString() {
        return String.format("Pair[%s,%s]", first, second);
    }

    /**
     *
     * @param obj
     * @return bool
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (first == null) {
            if (other.first != null)
                return false;
        } else if (!first.equals(other.first))
            return false;
        if (second == null) {
            if (other.second != null)
                return false;
        } else if (!second.equals(other.second))
            return false;
        return true;
    }

    /**
     *
     * @return HasCode of Pair
     */
    public int hashCode() {
        return Objects.hash(first, second);
    }

}
