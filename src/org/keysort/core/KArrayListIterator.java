package org.keysort.core;

import java.util.Iterator;

public class KArrayListIterator<T> implements Iterator<T> {

    private final KArrayList<T> list;
    private int index;

    public KArrayListIterator(KArrayList<T> array) {
        this.list = array;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
