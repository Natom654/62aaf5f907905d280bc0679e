package it.hillel;

public class Employee {
    private String surname;
    private String name;
    private String fathername;
    private String jobtitle;
    private String email;
    private String telephon;
    private int age;

    public Employee(String surname, String name, String fathername, String jobtitle, String email, String telephon, int age) {
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.jobtitle = jobtitle;
        this.email = email;
        this.telephon = telephon;
        this.age = age;
    }
}

