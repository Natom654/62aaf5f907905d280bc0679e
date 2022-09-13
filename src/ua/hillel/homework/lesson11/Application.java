package ua.hillel.homework.lesson11;

import ua.hillel.homework.lesson11.fruit.Apple;
import ua.hillel.homework.lesson11.fruit.Box;
import ua.hillel.homework.lesson11.fruit.Orange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Apple> applelist = new ArrayList<>();
        Apple apple = new Apple();
        applelist.add(apple);
        applelist.add(apple);
        applelist.add(apple);
        applelist.add(apple);
        Box<Apple> appleBoxone = new Box<>();
        Box<Apple> appleBoxmany = new Box<>();
        appleBoxone.add(apple);
        appleBoxmany.add(applelist);


        System.out.println("Weight of box with one apple -" + appleBoxone.getboxWeight());
        System.out.println("Weight of box with many apples- " + appleBoxmany.getboxWeight());

        List<Orange> orangelist = new ArrayList<>();
        Orange orange = new Orange();
        orangelist.add(orange);
        orangelist.add(orange);
        Box<Orange> orangeBoxone = new Box<>();
        Box<Orange> orangeBoxmany = new Box<>();
        orangeBoxone.add(orange);
        orangeBoxmany.add(orangelist);
        System.out.println("Weight of box with one orange -" + orangeBoxone.getboxWeight());
        System.out.println("Weight of box with many oranges -" + orangeBoxmany.getboxWeight());

        System.out.println(appleBoxmany.compare(orangeBoxmany));

        appleBoxmany.merge(appleBoxone);
        System.out.println("Weight of merge boxes apple -" + appleBoxmany.getboxWeight());
        System.out.println("Weight of empty box of apple -" + appleBoxone.getboxWeight());
    }
}

