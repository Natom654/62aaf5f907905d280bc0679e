package ua.ithillel.homework.phonebook;

public class Record {
    private final String name;
    private final String phone;

    public Record(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name= " + name + ", phone=" + phone;
    }
}
