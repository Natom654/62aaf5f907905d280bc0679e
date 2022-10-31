package ua.ithillel.homework.threadsafe;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class COWIterator implements Iterator {
    private Object[] elements;
    private int cursor;

    public COWIterator(Object[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return elements[cursor++];
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }

    public void add(Object element) {
        throw new UnsupportedOperationException();
    }
}

