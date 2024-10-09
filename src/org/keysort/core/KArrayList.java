package org.keysort.core;

import java.util.Iterator;

public class KArrayList<T> implements KList<T> {

    private T[] elements;
    private int size;
    private int capacity;

    private static final int MIN_CAPACITY = 8;
    private static final int GROW_FACTOR = 2;

    @SuppressWarnings("unchecked")
    public KArrayList() {
        capacity = MIN_CAPACITY;
        elements = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public KArrayList(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public T get(int index) {
        if (isInRange(index)) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T set(int index, T value) {
        if (isInRange(index)) {
            T old = elements[index];
            elements[index] = value;
            return old;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(T value) {
        if(size == capacity) {
            resize();
        }

        this.elements[size++] = value;
    }

    @Override
    public T remove(int index) {
        if (isInRange(index)) {
            T old = elements[index];
            elements[index] = null;
            return old;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T remove(T value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                T old = elements[i];
                elements[i] = null;
                return old;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newElements = (T[]) new Object[capacity * GROW_FACTOR];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
        capacity = elements.length;
    }

    private boolean isInRange(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public Iterator<T> iterator() {
        return new KArrayListIterator<>(this);
    }
}
