package org.keysort.core;

public interface KList<T> extends Iterable<T> {

    int size();
    boolean isEmpty();
    T get(int index);
    T set(int index, T value);
    void add(T value);
    T remove(int index);
    T remove(T value);
}
