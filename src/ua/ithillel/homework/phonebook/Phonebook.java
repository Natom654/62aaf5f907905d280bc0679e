package ua.ithillel.homework.phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Phonebook {
    private List<Record> phonebook;

    public Phonebook() {
        this.phonebook = new ArrayList<>();
    }

    public void add(Record record) {
        this.phonebook.add(record);
    }

    public Record find(String name) {
        for (Record record : this.phonebook) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> listname = phonebook.stream().filter(element -> element.getName().equals(name)).collect(Collectors.toList());
        return listname;
    }
}
