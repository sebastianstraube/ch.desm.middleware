package ch.desm.middleware.app.common;

/**
 *
 * @param <L>
 * @param <R>
 */
public class CommonPair<L, R> {

    private final L left;
    private final R right;

    public CommonPair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof CommonPair)) return false;
        CommonPair<?, ?> pairo = (CommonPair<?, ?>) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }

    public String toString(){
        String s="";
        s+= left;
        s+= ": ";
        s+= right;

        return s;
    }

}
