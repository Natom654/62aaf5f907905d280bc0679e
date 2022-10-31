package ua.ithillel.homework.threadsafe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;

public class ThreadSafeList implements CopyOnWriteArrayList {
    private Object[] threadSafeList;
    Lock lock;

    public boolean add(Object e) {
        lock.lock();
        try {
            Object[] newElements = Arrays.copyOf(threadSafeList, threadSafeList.length + 1);
            newElements[threadSafeList.length] = e;
            threadSafeList = newElements;
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void remove(int index) {
    }

    @Override
    public boolean get(int index) {
        return (boolean) threadSafeList[index];
    }

    public Iterator iterator() {
        return new COWIterator(threadSafeList);
    }
}

