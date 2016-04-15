package sun.algorithm.tree;

import java.util.Iterator;

/**
 * Created by yamorn on 2016/4/15.
 */
public interface Tree<E> extends Iterable<E> {

    Position<E> root();

    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    int numChildren(Position<E> p) throws IllegalArgumentException;

    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    @Override
    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
