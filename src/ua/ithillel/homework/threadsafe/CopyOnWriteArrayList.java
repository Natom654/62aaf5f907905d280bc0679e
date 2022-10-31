package ua.ithillel.homework.threadsafe;

public interface CopyOnWriteArrayList<String> {
    public boolean add(Object e);
    public void remove(int index);
    public boolean get(int index);
}
