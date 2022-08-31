package ua.ithillel.homework.tasklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationList {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("bird");
        words.add("cow");
        words.add("elephant");
        words.add("cat");
        words.add("dog");
        words.add("chicken");
        words.add("pig");
        words.add("dog");

        System.out.println(countOccurance(words, "dog")); // task1

        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(numbers).toList()); // task2

        List<Integer> fullist1 = new ArrayList<>();
        fullist1.add(1);
        fullist1.add(5);
        fullist1.add(1);
        fullist1.add(5);
        fullist1.add(6);
        fullist1.add(1);
        System.out.println(findUnique(fullist1)); // task3

        calcOccurance(words);//task 4**
        findOccurance(words);//task 4***
    }



    // task 1
    public static int countOccurance(List<String> words, String text) {
        int count = 0;
        for (Object element : words) {
            if (element.equals(text)) {
                count += 1;
            }
        }
        return count;
    }

    // task2
    public static ArrayList<Integer> toList(Integer[] numbers) {
        ArrayList<Integer> listnumbers = new ArrayList<Integer>(numbers.length);
        for (int i : numbers) {
            listnumbers.add(Integer.valueOf(i));
        }
        return listnumbers;
    }
     // task3
    public static List<Integer> findUnique(List<Integer> fullist1) {
        List<Integer> listUnique = fullist1.stream().distinct().collect(Collectors.toList());
        return listUnique;
    }

     //task 4**
    public static void calcOccurance(List<String> words) {
        Collections.sort(words);
        Object o = words.get(0);
        int n = 1;
        for (int i = 1; i < words.size(); i++) {
            Object t = words.get(i);
            if (o.equals(t)) {
                n++;
            } else {
                System.out.println(o + " - " + n);
                n = 1;
                o = t;
            }
        }
        System.out.println(o + " - " + n);
    }

    //task 4***
    public static List<String> findOccurance(List<String> words) {
        Collections.sort(words);
        Object object = words.get(0);
        int n = 1;
        List<String> newwords = new ArrayList<>();
        for (int i = 1; i < words.size(); i++) {
            Object t = words.get(i);
            if (object.equals(t)) {
                n++;
            } else {
                newwords.add("{name: " + object + " , occurance " + n+ "}");
                n = 1;
                object = t;
            }
        }
        newwords.add("{name: " + object + " , occurance " + n+ "}");
        newwords.forEach(System.out::println);
        return newwords;
    }
}


