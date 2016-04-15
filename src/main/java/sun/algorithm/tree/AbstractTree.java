package sun.algorithm.tree;

/**
 * Created by yamorn on 2016/4/15.
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p){
        if(isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }

    // Return the height of the subtree rooted at Position p
    public int height(Position<E> p){
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }


}
