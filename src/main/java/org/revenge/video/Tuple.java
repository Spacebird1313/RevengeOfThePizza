package org.revenge.video;

/**
 * Created by sdecleen.
 */
public class Tuple<L, R> {

    private L lhs;

    private R rhs;

    public Tuple(L lhs, R rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public L getLhs() {
        return lhs;
    }

    public R getRhs() {
        return rhs;
    }

    public void setRhs(R rhs)
    {
        this.rhs = rhs;
    }

    @Override
    public int hashCode() {
        return lhs.hashCode() ^ rhs.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Tuple)) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return this.lhs.equals(tuple.getLhs()) && this.rhs.equals(tuple.getRhs());
    }

}
