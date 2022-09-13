package ua.hillel.homework.lesson11.fruit;

import java.util.ArrayList;
import java.util.List;


public class Box<T extends Fruit> {
    private List<T> fruitlist;

    public Box() {
        this.fruitlist = new ArrayList<>();
    }

    public void add(T fruit) {
        fruitlist.add(fruit);
    }

    public void add(List<T> fruit) {
        fruitlist.addAll(fruit);
    }

    public double getboxWeight() {
        return fruitlist.isEmpty() ? 0 : fruitlist.size() * fruitlist.get(0).getWeight();
    }

    public boolean compare(Box box) {
        return this.getboxWeight() == box.getboxWeight();
    }

    public void merge(Box<T> box) {
        fruitlist.addAll(box.fruitlist);
        box.fruitlist.clear();
    }

    public static <T> List<T> toList(T[] array) {
        List<T> listT = new ArrayList<>();
        for (T i : listT) {
            // listT.add(i);
        }
        return listT;
    }
}


