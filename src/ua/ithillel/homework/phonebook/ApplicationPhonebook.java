package ua.ithillel.homework.phonebook;

import java.util.ArrayList;
import java.util.List;

public class ApplicationPhonebook {
    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();
        Record record1 = new Record("Omelchenko", "0679966457");
        Record record2 = new Record("Omelchenko", "0972332929");
        Record record3 = new Record("Omelchenko", "0972333333");
        Record record4 = new Record("Ivanov", "0972333555");
        phoneBook.add(record1);
        phoneBook.add(record2);
        phoneBook.add(record3);
        phoneBook.add(record4);

        System.out.println(phoneBook.find("Omelchenko"));
        System.out.println(phoneBook.findAll("Omelchenko"));
    }
}
